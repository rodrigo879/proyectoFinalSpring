package edu.curso.java.spring.proyectospring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.curso.java.spring.proyectospring.bo.Genero;
import edu.curso.java.spring.proyectospring.repository.GeneroRepository;

@Service
@Transactional
@PreAuthorize("hasRole('USER')")
public class GeneroServiceImpl implements GeneroService {

	@Autowired
	private GeneroRepository generoRepository;
	
	@Override
	public List<Genero> buscarGeneros(){
		return generoRepository.buscarGeneros();
	}
	
	@Override
	public List<Genero> buscarGeneros(String nombre){
		return generoRepository.buscarGeneros(nombre);
	}
	
	@Override
	public Genero buscarGeneroPorId(Long id) {
		Optional<Genero> genero = generoRepository.findById(id);
		if(genero.isEmpty()) {
			return null;
		}
		return genero.get();
	}
	
	@Override
	@PreAuthorize("hasRole('ADMIN')")
	public Long altaGenero(Genero genero) {
		generoRepository.save(genero);
		return genero.getId();
	}
	
	@Override
	@PreAuthorize("hasRole('ADMIN')")
	public void borrarGenero(Long id) {
		generoRepository.deleteById(id);
	}
	
	@Override
	@PreAuthorize("hasRole('ADMIN')")
	public void actualizarGenero(Genero genero) {
		generoRepository.save(genero);
	}
}