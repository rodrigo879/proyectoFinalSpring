package edu.curso.java.spring.proyectospring.service;

import java.util.List;

import edu.curso.java.spring.proyectospring.bo.Genero;

public interface GeneroService {

	public List<Genero> buscarGeneros();
	public	List<Genero> buscarGeneros(String nombre);
	public Genero buscarGeneroPorId(Long id);
	public	Long altaGenero(Genero genero);
	public	void borrarGenero(Long id);
	public	void actualizarGenero(Genero genero);
}