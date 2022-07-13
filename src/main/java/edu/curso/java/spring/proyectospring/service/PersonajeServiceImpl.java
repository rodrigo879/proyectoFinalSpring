package edu.curso.java.spring.proyectospring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.curso.java.spring.proyectospring.bo.Pelicula;
import edu.curso.java.spring.proyectospring.bo.Personaje;
import edu.curso.java.spring.proyectospring.repository.PeliculaRepository;
import edu.curso.java.spring.proyectospring.repository.PersonajeRepository;

@Service
@Transactional
public class PersonajeServiceImpl implements PersonajeService {

	@Autowired
	private PersonajeRepository personajeRepository;
	
	@Autowired
	private PeliculaRepository peliculaRepository;
	
	@Override
	public List<Personaje> buscarPersonajes(){
		return personajeRepository.buscarPersonajes();
	}
	
	@Override
	public List<Personaje> buscarPersonajes(String nombre){
		return personajeRepository.buscarPersonajes(nombre);
	}
	
	@Override
	public Personaje buscarPersonajePorId(Long id) {
		Optional<Personaje> personaje = personajeRepository.findById(id);
		if(personaje.isEmpty()) {
			return null;
		}
		return personaje.get();
	}
	
	@Override
	public Long altaPersonaje(Personaje personaje, Long idPelicula) throws PersonajeException {
		// TODO Auto-generated method stub
		personajeRepository.save(personaje);
		return personaje.getId();
	}
	
	@Override
	public void borrarPersonaje(Long id) {
		personajeRepository.deleteById(id);
	}
	
	@Override
	public void actualizarPersonaje(Personaje personaje) {
		personajeRepository.save(personaje);
	}

	@Override
	public List<Personaje> buscarPersonajesPorPelicula(Long id) {
		// TODO Auto-generated method stub
		return personajeRepository.recuperarPersonajePorPelicula(id);
	}

	@Override
	public List<Pelicula> buscarPeliculas() {
		// TODO Auto-generated method stub
		return peliculaRepository.buscarPeliculas();
	}

	@Override
	public Pelicula buscarPeliculaPorId(Long id) {
		// TODO Auto-generated method stub
		return peliculaRepository.buscarPeliculaPorId(id);
	}
}
