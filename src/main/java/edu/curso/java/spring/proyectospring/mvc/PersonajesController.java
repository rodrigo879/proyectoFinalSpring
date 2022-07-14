package edu.curso.java.spring.proyectospring.mvc;

import java.io.*;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import edu.curso.java.spring.proyectospring.bo.Pelicula;
import edu.curso.java.spring.proyectospring.bo.Personaje;
import edu.curso.java.spring.proyectospring.mvc.form.PersonajeForm;
import edu.curso.java.spring.proyectospring.service.PeliculaService;
import edu.curso.java.spring.proyectospring.service.PersonajeException;
import edu.curso.java.spring.proyectospring.service.PersonajeService;

@Controller
@RequestMapping("/personajes")
public class PersonajesController {
	
	@Autowired
	private PersonajeService personajeService;
	
	@Autowired
	private PeliculaService peliculaService;
	
	@GetMapping
	public String listarPersonaje(Model model) { 
		this.cargarPeliculas(model);
		List<Personaje> personajes = personajeService.buscarPersonajes();
		model.addAttribute("personajes", personajes);
		model.addAttribute("personajeForm", new PersonajeForm());
		return "/personajes/listarPersonajes";
	}
	
	@GetMapping("/pelicula/{id}")
	public String filtrarPersonajesPorPelicula(Model model,@PathVariable Long id) {
		this.cargarPeliculas(model);
		List<Personaje> personajes = personajeService.buscarPersonajesPorPelicula(id);		
		model.addAttribute("personajes", personajes);
		model.addAttribute("personajeForm", new PersonajeForm());
		return "/personajes/listarPersonajes";
	}
	
	@GetMapping("/{id}")
	public String verPersonaje(Model model, @PathVariable Long id) {
		Personaje personajes = personajeService.buscarPersonajePorId(id);
		model.addAttribute("personajes", personajes);
		return "/personajes/verPersonajes";
	}
	
	private void cargarPeliculas(Model model) {
		List<Pelicula> peliculas = personajeService.buscarPeliculas();
		model.addAttribute("peliculas", peliculas);
	}
	
	@GetMapping("/nuevo")
	public String nuevoPersonaje(Model model) {
		this.cargarPeliculas(model);
		model.addAttribute("personajeForm", new PersonajeForm());
		return "/personajes/formPersonajes";
	}
	
	@PostMapping("/guardar")
	public String guardarPersonaje(@Valid @ModelAttribute(name = "personajeForm") PersonajeForm personajeForm, BindingResult bindingResult, Model model, @RequestParam("foto") MultipartFile foto) {
		if(bindingResult.hasErrors()) {
			this.cargarPeliculas(model);
			model.addAttribute("personajeForm", personajeForm);
			return "/personajes/formPersonajes";
		}
		
		if(!foto.isEmpty()) {
			
			Personaje personaje;
			
			Long idPersonaje = personajeForm.getId();
			
			if(idPersonaje == null) {
				personaje = new Personaje();
			} else {
				personaje = personajeService.buscarPersonajePorId(idPersonaje);
			}
			
			Pelicula pelicula = peliculaService.buscarPeliculaPorId(personajeForm.getIdPelicula());
				
			personaje.setNombre(personajeForm.getNombre());
			personaje.setEdad(personajeForm.getEdad());
			personaje.setHistoria(personajeForm.getHistoria());
			personaje.setPeso(personajeForm.getPeso());
			personaje.setPelicula(pelicula);
			
			String originalName = personajeForm.getFoto().getOriginalFilename();
			String extensionFile = ".";
			int i = originalName.lastIndexOf(".");
			if(i>0) {
				extensionFile = originalName.substring(i);
			}
			
			Date date = new Date();
			File archivoImagen = new File("C:/Rodrigo/Kolektor/proyecto-spring-final/src/main/webapp/image/personaje" + "-" + date.getTime() + extensionFile);
			personaje.setImagen(archivoImagen.getName());
			
			
			
			try(FileOutputStream fileOut = new FileOutputStream(archivoImagen)){
				fileOut.write(personajeForm.getFoto().getBytes());
			} catch (Exception e) {
				
			}
			
			if(idPersonaje == null) {
				try {
					personajeService.altaPersonaje(personaje, personajeForm.getIdPelicula());
				} catch (PersonajeException e) {
					return "redirect:/error";
				}
			} else {
				personajeService.actualizarPersonaje(personaje);
			}
			
			return "redirect:/personajes";
		}
		
		return "redirect:/error";
	}
	
	@GetMapping("/{id}/editar")
	public String editarPersonaje(Model model, @PathVariable Long id) {
		Personaje personaje = personajeService.buscarPersonajePorId(id);
		PersonajeForm personajeForm = new PersonajeForm();
		personajeForm.setNombre(personaje.getNombre());
		personajeForm.setEdad(personaje.getEdad());
		personajeForm.setHistoria(personaje.getHistoria());
		//personajeForm.setImagen(personaje.getImagen());
		personajeForm.setPeso(personaje.getPeso());
		
		if(personaje.getPelicula() != null) {
			personajeForm.setIdPelicula(personaje.getPelicula().getId());
			this.cargarPeliculas(model);
			model.addAttribute("personajeForm", personajeForm);
		}
			return "/personajes/formPersonajes";
	}
	
	@GetMapping("/{id}/borrar")
	public String borrarPersonaje(Model model, @PathVariable Long id) {
		personajeService.borrarPersonaje(id);
		return "redirect:/personajes";
	}
}
