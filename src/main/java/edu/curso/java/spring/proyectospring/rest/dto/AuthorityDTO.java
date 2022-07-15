package edu.curso.java.spring.proyectospring.rest.dto;

import edu.curso.java.spring.proyectospring.bo.Authority;

public class AuthorityDTO {

	private Long id;
	private String nombreUsuario;
	private String authority;
	
	
	public AuthorityDTO() {}
	
	public AuthorityDTO(Authority authority) {
		this.id = authority.getId();
		this.nombreUsuario = authority.getNombreUsuario();
		this.authority = authority.getAuthority();
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	
}
