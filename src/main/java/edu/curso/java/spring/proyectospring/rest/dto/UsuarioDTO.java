package edu.curso.java.spring.proyectospring.rest.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import edu.curso.java.spring.proyectospring.bo.Usuario;

public class UsuarioDTO {

	private Long id;
	private String nombre;
	private String apellido;
	private String nombreUsuario;
	private String password;
	
	@Min(value = 0)//Usuario inactivo
	@Max(value = 1)//Usuario activo
	private Boolean activo;

	
	public UsuarioDTO() {}
	
	public UsuarioDTO(Usuario usuario) {
		this.id = usuario.getId();
		this.nombre = usuario.getNombre();
		this.apellido = usuario.getApellido();
		this.nombreUsuario = usuario.getNombreUsuario();
		this.password = usuario.getPassword();
		this.activo = usuario.getActivo();
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}	
}
