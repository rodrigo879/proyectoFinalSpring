package edu.curso.java.spring.proyectospring.rest.dto;

import edu.curso.java.spring.proyectospring.bo.Personaje;

public class PersonajeDTO {

	private Long idPersonaje;	
	private String nombre;
	private Long edad;
	private Double peso;
	private String historia;
	private String imagen;
	private Long idPelicula;
	
	public PersonajeDTO() {}
	
	public PersonajeDTO(Personaje personaje) {
		this.idPersonaje = personaje.getId();
		this.nombre = personaje.getNombre();
		this.edad = personaje.getEdad();
		this.peso = personaje.getPeso();
		this.historia = personaje.getHistoria();
		this.imagen = personaje.getImagen();
		this.idPelicula = personaje.getPelicula().getId();
	}
	
	public Long getIdPersonaje() {
		return idPersonaje;
	}
	public void setIdPersonaje(Long idPersonaje) {
		this.idPersonaje = idPersonaje;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Long getEdad() {
		return edad;
	}
	public void setEdad(Long edad) {
		this.edad = edad;
	}
	public Double getPeso() {
		return peso;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	public String getHistoria() {
		return historia;
	}
	public void setHistoria(String historia) {
		this.historia = historia;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public Long getIdPelicula() {
		return idPelicula;
	}
	public void setIdPelicula(Long idPelicula) {
		this.idPelicula = idPelicula;
	}
}
