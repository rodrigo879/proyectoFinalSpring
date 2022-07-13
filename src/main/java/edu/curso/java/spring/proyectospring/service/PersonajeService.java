package edu.curso.java.spring.proyectospring.service;

import java.util.List;

import edu.curso.java.spring.proyectospring.bo.Pelicula;
import edu.curso.java.spring.proyectospring.bo.Personaje;

public interface PersonajeService {

	public	List<Personaje> buscarPersonajes();
	public	List<Personaje> buscarPersonajes(String nombre);
	public	Personaje buscarPersonajePorId(Long id);
	public	Long altaPersonaje(Personaje personaje, Long idPelicula) throws PersonajeException;
	public	void borrarPersonaje(Long id);
	public	void actualizarPersonaje(Personaje personaje);
	public List<Pelicula> buscarPeliculas();
	public List<Personaje> buscarPersonajesPorPelicula(Long id);
	public Pelicula buscarPeliculaPorId(Long id);

}