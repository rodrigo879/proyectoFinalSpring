package edu.curso.java.spring.proyectospring.rest;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import edu.curso.java.spring.proyectospring.bo.Genero;
import edu.curso.java.spring.proyectospring.bo.Pelicula;
import edu.curso.java.spring.proyectospring.rest.dto.PeliculaDTO;
import edu.curso.java.spring.proyectospring.service.GeneroService;
import edu.curso.java.spring.proyectospring.service.PeliculaException;
import edu.curso.java.spring.proyectospring.service.PeliculaService;

@RestController
@RequestMapping("/api/peliculas")
public class PeliculaRestController {

	
	@Autowired
	private PeliculaService peliculaService;
	
	@Autowired
	private GeneroService generoService;
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<PeliculaDTO> recuperarPeliculaPorId(@PathVariable Long id){
		Pelicula pelicula = peliculaService.buscarPeliculaPorId(id);
		PeliculaDTO peliculaDTO = new PeliculaDTO(pelicula);
		return ResponseEntity.ok(peliculaDTO);
	}
	
	@GetMapping(path = "/buscar")
	public ResponseEntity<List<PeliculaDTO>> buscarPeliculas(@RequestParam String titulo) {
		
		List<Pelicula> peliculas = peliculaService.buscarPeliculas(titulo);
		List<PeliculaDTO> peliculaDTO  = new ArrayList<PeliculaDTO>();
		for (Pelicula p : peliculas) {
			peliculaDTO.add(new PeliculaDTO(p));
		}
		return ResponseEntity.ok(peliculaDTO);
		
	}
	
	@GetMapping
	public ResponseEntity<List<PeliculaDTO>> buscarPeliculas(){
		List<Pelicula> peliculas = peliculaService.buscarPeliculas();
		List<PeliculaDTO> peliculaDTO = new ArrayList<PeliculaDTO>();
		for(Pelicula p :  peliculas) {
			peliculaDTO.add(new PeliculaDTO(p));
		}
		
		return ResponseEntity.ok(peliculaDTO);
	}
	
	@PostMapping
	public ResponseEntity<PeliculaDTO> altaPelicula(@Valid @RequestBody PeliculaDTO peliculaDTO) {
		
		Genero genero = generoService.buscarGeneroPorId(peliculaDTO.getIdGenero());
		if (genero == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"No existe una pelicula con ese id(" + genero + ")");
		}
		
		Pelicula pelicula = new Pelicula();
		pelicula.setTitulo(peliculaDTO.getTitulo());
		pelicula.setCalificacion(peliculaDTO.getCalificacion());
		pelicula.setFechaCreacion(peliculaDTO.getFechaCreacion());
		pelicula.setGenero(genero);
		
		Long idGeneardo;
		try {
			idGeneardo = peliculaService.altaPelicula(pelicula, peliculaDTO.getIdGenero());
			peliculaDTO.setIdPelicula(idGeneardo);
			
		} catch (PeliculaException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
				
		return ResponseEntity.status(HttpStatus.CREATED).body(peliculaDTO);
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity actualizarPelicula(@PathVariable Long id, @RequestBody PeliculaDTO peliculaDTO) {
		Pelicula pelicula = peliculaService.buscarPeliculaPorId(id);
		pelicula.setTitulo(peliculaDTO.getTitulo());
		pelicula.setCalificacion(peliculaDTO.getCalificacion());
		pelicula.setFechaCreacion(peliculaDTO.getFechaCreacion());
		
		peliculaService.actualizarPelicula(pelicula);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity borrarPelicula(@PathVariable Long id){
		
		peliculaService.borrarPelicula(id);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}