package edu.curso.java.spring.proyectospring.rest.dto;

import edu.curso.java.spring.proyectospring.bo.Genero;

public class GeneroDTO {
	
	private Long id;
	private String nombre;
	
	public GeneroDTO() {}
	
	public GeneroDTO(Genero genero) {
		this.id = genero.getId();
		this.nombre = genero.getNombre();
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
