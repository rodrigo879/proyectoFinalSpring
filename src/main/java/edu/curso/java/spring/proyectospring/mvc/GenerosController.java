package edu.curso.java.spring.proyectospring.mvc;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import edu.curso.java.spring.proyectospring.bo.Genero;
import edu.curso.java.spring.proyectospring.mvc.form.GeneroForm;
import edu.curso.java.spring.proyectospring.service.GeneroService;


@Controller
@RequestMapping("/generos")
public class GenerosController {
	
	@Autowired
	private GeneroService generoService;
	
	@GetMapping
	public String listarGeneros(Model model) { 
		List<Genero> generos = generoService.buscarGeneros();
		model.addAttribute("generos", generos);
		return "/generos/listarGeneros";
	}
	
	@GetMapping("/{id}")
	public String verGeneros(Model model, @PathVariable Long id) {
		Genero generos = generoService.buscarGeneroPorId(id);
		model.addAttribute("generos", generos);
		return "/generos/verGeneros";
	}
	
	@GetMapping("/nuevo")
	public String nuevoGenero(Model model) {
		model.addAttribute("generoForm", new GeneroForm());
		return "/generos/formGeneros";
	}
	
	@PostMapping("/guardar")
	public String guardarGenero(@Valid @ModelAttribute(name = "generoForm") GeneroForm generoForm, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("generoForm", generoForm);
			return "/generos/formGeneros";
		}
		
		Genero genero = null;
		Long idGenero = generoForm.getId();
		
		if(idGenero == null) {
			genero = new Genero();
		} else {
			genero = generoService.buscarGeneroPorId(idGenero);
		}
		genero.setNombre(generoForm.getNombre());
		
		if(idGenero == null) {
			try {
				generoService.altaGenero(genero);
			} catch (Exception e) {
				return "redirect:/error";
			}
		} else {
			generoService.actualizarGenero(genero);
		}
		return "redirect:/generos";
	}
	
	@GetMapping("/{id}/editar")
	public String editarGenero(Model model, @PathVariable Long id) {
		Genero genero = generoService.buscarGeneroPorId(id);
		GeneroForm generoForm = new GeneroForm();
		generoForm.setNombre(genero.getNombre());
		model.addAttribute("generoForm",generoForm);
		return "/generos/formGeneros";
	}
	
	@GetMapping("/{id}/borrar")
	public String borrarGenero(Model model, @PathVariable Long id) {
		generoService.borrarGenero(id);
		return "redirect:/generos";
	}
}
