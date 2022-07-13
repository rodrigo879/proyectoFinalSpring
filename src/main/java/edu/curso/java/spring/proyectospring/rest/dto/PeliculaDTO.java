package edu.curso.java.spring.proyectospring.rest.dto;

import java.util.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import edu.curso.java.spring.proyectospring.bo.Pelicula;


public class PeliculaDTO {
	
	private Long idPelicula;
	private String titulo;
	
	//@JsonFormat(shape = Shape.NUMBER, pattern="s")
	private Date fechaCreacion;
	
	@Min(value = 1)
	@Max(value = 5)
	private Integer calificacion;
	private Long idGenero;
	
	public PeliculaDTO() {}
	
	public PeliculaDTO(Pelicula pelicula) {
		this.idPelicula = pelicula.getId();
		this.titulo = pelicula.getTitulo();
		this.fechaCreacion = pelicula.getFechaCreacion();
		this.calificacion = pelicula.getCalificacion();
		this.idGenero= pelicula.getGenero().getId();
	}
	
	public Long getIdPelicula() {
		return idPelicula;
	}
	public void setIdPelicula(Long idPelicula) {
		this.idPelicula = idPelicula;
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
	public Long getIdGenero() {
		return idGenero;
	}
	public void setIdGenero(Long idGenero) {
		this.idGenero = idGenero;
	}
}
