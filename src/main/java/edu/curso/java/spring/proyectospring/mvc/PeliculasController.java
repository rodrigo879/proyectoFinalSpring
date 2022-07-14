package edu.curso.java.spring.proyectospring.mvc;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import edu.curso.java.spring.proyectospring.bo.Genero;
import edu.curso.java.spring.proyectospring.bo.Pelicula;
import edu.curso.java.spring.proyectospring.bo.Personaje;
import edu.curso.java.spring.proyectospring.mvc.form.PeliculaForm;
import edu.curso.java.spring.proyectospring.service.GeneroService;
import edu.curso.java.spring.proyectospring.service.PeliculaException;
import edu.curso.java.spring.proyectospring.service.PeliculaService;
import edu.curso.java.spring.proyectospring.service.PersonajeService;

@Controller
@RequestMapping("/peliculas")
public class PeliculasController {
	
	@Autowired
	private PeliculaService peliculaService;
	
	@Autowired
	private PersonajeService personajesService;
	
	@Autowired
	private GeneroService generoService;
	
	@GetMapping
	public String listarPeliculas(HttpServletRequest request, Model model) { 
		HttpSession session = request.getSession();
		String texto = (String) session.getAttribute("texto");
		List<Pelicula> peliculas = peliculaService.buscarPeliculas();
		model.addAttribute("peliculas", peliculas);
		return "/peliculas/listarPeliculas";
	}
	
	@GetMapping("/{id}")
	public String verPeliculas(Model model, @PathVariable Long id) {
		Pelicula peliculas = peliculaService.buscarPeliculaPorId(id);
		List<Personaje> personajes = personajesService.buscarPersonajesPorPelicula(id);
		model.addAttribute("peliculas", peliculas);
		model.addAttribute("personajes", personajes);
		return "/peliculas/verPeliculas";
	}
	
	private void cargarGeneros(Model model) {
		List<Genero> generos= peliculaService.buscarGenero();
		model.addAttribute("generos", generos);
	}
	
	@GetMapping("/nuevo")
	public String nuevaPelicula(Model model) {
		this.cargarGeneros(model);
		model.addAttribute("peliculaForm", new PeliculaForm());
		return "/peliculas/formPeliculas";
	}
	
	@PostMapping("/guardar")
	public String guardarPelicula(@Valid @ModelAttribute(name = "peliculaForm") PeliculaForm peliculaForm, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			this.cargarGeneros(model);
			model.addAttribute("peliculaForm", peliculaForm);			
			return "/peliculas/formPeliculas";
		}
		
		Pelicula pelicula;
		Long idPelicula = peliculaForm.getId();
		
		if(idPelicula == null) {
			pelicula = new Pelicula();
		} else {
			pelicula = peliculaService.buscarPeliculaPorId(idPelicula);
		}
		
		pelicula.setTitulo(peliculaForm.getTitulo());
		pelicula.setCalificacion(peliculaForm.getCalificacion());
		pelicula.setFechaCreacion(peliculaForm.getFechaCreacion());
		pelicula.setGenero(generoService.buscarGeneroPorId(peliculaForm.getIdGenero()));
		
		if(idPelicula == null) {
			try {
				peliculaService.altaPelicula(pelicula, peliculaForm.getIdGenero());
			} catch (PeliculaException e) {
				return "redirect:/error";
			}
		} else {
			peliculaService.actualizarPelicula(pelicula);
		}
		return "redirect:/";
	}
	
	@GetMapping("/{id}/editar")
	public String editarPelicula(Model model, @PathVariable Long id) {
		Pelicula pelicula = peliculaService.buscarPeliculaPorId(id);
		PeliculaForm peliculaForm = new PeliculaForm();
		peliculaForm.setTitulo(pelicula.getTitulo());
		peliculaForm.setFechaCreacion(pelicula.getFechaCreacion());
		peliculaForm.setCalificacion(pelicula.getCalificacion());
		
		if(pelicula.getGenero() != null) {
			peliculaForm.setIdGenero(pelicula.getGenero().getId());
			this.cargarGeneros(model);
			model.addAttribute("peliculaForm", peliculaForm);
		}
			return "/peliculas/formPeliculas";
	}
	
	@GetMapping("/{id}/borrar")
	public String borrarPelicula(Model model, @PathVariable Long id) {
		peliculaService.borrarPelicula(id);
		return "redirect:/";
	}
}
