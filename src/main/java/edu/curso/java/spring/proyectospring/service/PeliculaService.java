package edu.curso.java.spring.proyectospring.service;

import java.util.List;

import edu.curso.java.spring.proyectospring.bo.Genero;
import edu.curso.java.spring.proyectospring.bo.Pelicula;

public interface PeliculaService {

	public	List<Pelicula> buscarPeliculas();
	public	List<Pelicula> buscarPeliculas(String titulo);
	public	Pelicula buscarPeliculaPorId(Long id);
	public	Long altaPelicula(Pelicula pelicula, Long id) throws PeliculaException;
	public	void borrarPelicula(Long id);
	public	void actualizarPelicula(Pelicula pelicula);
	public List<Genero> buscarGenero();
	public List<Pelicula> buscarPeliculasPorGenero(Long id);
	public Genero buscarGeneroPorId(Long id);

}