package edu.curso.java.spring.proyectospring.bo;

import javax.persistence.*;


@Entity
@Table(name = "AUTHORITIES")
public class Authority {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "USERNAME")
	private String nombreUsuario;
	

	@Column(nullable = false, name = "AUTHORITY")
	private String authority;

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
}
