package edu.curso.java.spring.proyectospring.mvc.form;


import javax.validation.constraints.NotBlank;

public class GeneroForm {

	private Long id;
	
	@NotBlank
	private String nombre;

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
