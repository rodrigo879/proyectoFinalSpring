package edu.curso.java.spring.proyectospring.rest;

import java.util.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import edu.curso.java.spring.proyectospring.bo.Pelicula;
import edu.curso.java.spring.proyectospring.bo.Personaje;
import edu.curso.java.spring.proyectospring.rest.dto.PersonajeDTO;
import edu.curso.java.spring.proyectospring.service.PeliculaService;
import edu.curso.java.spring.proyectospring.service.PersonajeException;
import edu.curso.java.spring.proyectospring.service.PersonajeService;

@RestController
@RequestMapping("/api/personajes")
public class PersonajeRestController {
	
	@Autowired
	private PersonajeService personajeService;
	
	@Autowired
	private PeliculaService peliculaService;
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<PersonajeDTO> recuperarPersonajePorId(@PathVariable Long id){
		Personaje personaje = personajeService.buscarPersonajePorId(id);
		PersonajeDTO personajeDTO = new PersonajeDTO(personaje);
		return ResponseEntity.ok(personajeDTO);
	}
	
	@GetMapping
	public ResponseEntity<List<PersonajeDTO>> buscarPersonajes(){
		List<Personaje> personajes = personajeService.buscarPersonajes();
		List<PersonajeDTO> personajeDTO = new ArrayList<PersonajeDTO>();
		for(Personaje p :  personajes) {
			personajeDTO.add(new PersonajeDTO(p));
		}
		
		return ResponseEntity.ok(personajeDTO);
	}
	
	@PostMapping
	public ResponseEntity<PersonajeDTO> altaPersonaje(@Valid @RequestBody PersonajeDTO personajeDTO) {
		
		Pelicula pelicula = peliculaService.buscarPeliculaPorId(personajeDTO.getIdPelicula());
		if (pelicula == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"No existe una pelicula con ese id(" + pelicula + ")");
		}
		
		Personaje personaje = new Personaje();
		personaje.setNombre(personajeDTO.getNombre());
		personaje.setEdad(personajeDTO.getEdad());
		personaje.setHistoria(personajeDTO.getHistoria());
		personaje.setImagen(personajeDTO.getImagen());
		personaje.setPeso(personajeDTO.getPeso());
		personaje.setPelicula(pelicula);
		
		Long idGeneardo;
		try {
			idGeneardo = personajeService.altaPersonaje(personaje, personajeDTO.getIdPelicula());
			personajeDTO.setIdPersonaje(idGeneardo);
			
		} catch (PersonajeException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
				
		return ResponseEntity.status(HttpStatus.CREATED).body(personajeDTO);
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity actualizarPersonaje(@PathVariable Long id, @RequestBody PersonajeDTO personajeDTO) {
		Personaje personaje = personajeService.buscarPersonajePorId(id);
		personaje.setNombre(personajeDTO.getNombre());
		personaje.setEdad(personajeDTO.getEdad());
		personaje.setHistoria(personajeDTO.getHistoria());
		personaje.setImagen(personajeDTO.getImagen());
		personaje.setPeso(personajeDTO.getPeso());
		
		personajeService.actualizarPersonaje(personaje);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity borrarPersonaje(@PathVariable Long id){
		
		personajeService.borrarPersonaje(id);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}