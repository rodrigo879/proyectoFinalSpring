package edu.curso.java.spring.proyectospring.mvc.form;

import java.util.*;

import javax.validation.constraints.*;

public class PeliculaForm {

	private Long id;
	private Long idGenero;
	
	@NotBlank
	private String titulo;
	
	private Date fechaCreacion;
		
	@Min(value = 1)
	@Max(value = 5)
	private Integer calificacion;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdGenero() {
		return idGenero;
	}
	public void setIdGenero(Long idGenero) {
		this.idGenero = idGenero;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Date getFechaCreacion() {		
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public Integer getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(Integer calificacion) {
		this.calificacion = calificacion;
	}
}
