package edu.curso.java.spring.proyectospring.service;

import java.util.List;

import edu.curso.java.spring.proyectospring.bo.Authority;

public interface AuthorityService {

	List<Authority> buscarAuthorities();

	List<Authority> buscarAuthorities(String authority);
	
	Authority buscarAuthoritiesPorNombre(String nombreUsuario);

	Authority buscarAuthorityPorId(Long id);

	Long altaAuthority(Authority authority);

	void actualizarAuthority(Authority authority);

	void borrarAuthority(Long id);

}