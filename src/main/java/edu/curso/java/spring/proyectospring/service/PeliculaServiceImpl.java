package edu.curso.java.spring.proyectospring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.curso.java.spring.proyectospring.bo.Genero;
import edu.curso.java.spring.proyectospring.bo.Pelicula;
import edu.curso.java.spring.proyectospring.repository.GeneroRepository;
import edu.curso.java.spring.proyectospring.repository.PeliculaRepository;

@Service
@Transactional
@PreAuthorize("hasRole('USER')")
public class PeliculaServiceImpl implements PeliculaService {

	@Autowired
	private PeliculaRepository peliculaRepository;
	
	@Autowired
	private GeneroRepository generoRepository;
	
	@Override
	public List<Pelicula> buscarPeliculas(){
		return peliculaRepository.buscarPeliculas();
	}
	
	@Override
	public List<Pelicula> buscarPeliculas(String titulo){
		return peliculaRepository.buscarPeliculas(titulo);
	}
	
	@Override
	public Pelicula buscarPeliculaPorId(Long id) {
		Optional<Pelicula> pelicula = peliculaRepository.findById(id);
		if(pelicula.isEmpty()) {
			return null;
		}
		return pelicula.get();
	}
	
	@Override
	@PreAuthorize("hasRole('ADMIN')")
	public Long altaPelicula(Pelicula pelicula, Long id) throws PeliculaException {
		peliculaRepository.save(pelicula);
		return pelicula.getId();
	}
	
	@Override
	@PreAuthorize("hasRole('ADMIN')")
	public void borrarPelicula(Long id) {
		peliculaRepository.deleteById(id);
	}
	
	@Override
	@PreAuthorize("hasRole('ADMIN')")
	public void actualizarPelicula(Pelicula pelicula) {
		peliculaRepository.save(pelicula);
	}

	@Override
	public List<Pelicula> buscarPeliculasPorGenero(Long id) {
		// TODO Auto-generated method stub
		return peliculaRepository.recuperarPeliculaPorGenero(id);
	}
	
	@Override
	public List<Genero> buscarGenero() {
		// TODO Auto-generated method stub
		return generoRepository.buscarGeneros();
	}

	@Override
	public Genero buscarGeneroPorId(Long id) {
		// TODO Auto-generated method stub
		return generoRepository.buscarGeneroPorId(id);
	}
}