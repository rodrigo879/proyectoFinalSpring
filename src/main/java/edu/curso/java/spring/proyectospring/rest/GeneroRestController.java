package edu.curso.java.spring.proyectospring.rest;

import java.util.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import edu.curso.java.spring.proyectospring.bo.Genero;
import edu.curso.java.spring.proyectospring.rest.dto.GeneroDTO;
import edu.curso.java.spring.proyectospring.service.GeneroService;

@RestController
@RequestMapping("/api/generos")
public class GeneroRestController {

	@Autowired
	private GeneroService generoService;
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<GeneroDTO> recuperarGeneroPorId(@PathVariable Long id) {
		Genero genero = generoService.buscarGeneroPorId(id);
		GeneroDTO generoDTO = new GeneroDTO(genero);
		return ResponseEntity.ok(generoDTO);
	}
	
	@GetMapping
	public ResponseEntity<List<GeneroDTO>> buscarGeneros() {
		List<Genero> generos = generoService.buscarGeneros();
		List<GeneroDTO> generoDTO = new ArrayList<GeneroDTO>();
		for(Genero g : generos) {
			generoDTO.add(new GeneroDTO(g));
		}
		
		return ResponseEntity.ok(generoDTO);
	}
	
	@PostMapping
	public ResponseEntity<GeneroDTO> altaGenero(@Valid @RequestBody GeneroDTO generoDto) {
		
		Genero genero = new Genero();
		genero.setNombre(generoDto.getNombre());
		
		Long idGenerado = generoService.altaGenero(genero);
		generoDto.setId(idGenerado);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(generoDto);
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity actualizarGenero(@PathVariable Long id, @RequestBody GeneroDTO generoDTO) {
		Genero genero = generoService.buscarGeneroPorId(id);
		genero.setNombre(generoDTO.getNombre());
		
		generoService.actualizarGenero(genero);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity borrarGenero(@PathVariable Long id) {
		generoService.borrarGenero(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
