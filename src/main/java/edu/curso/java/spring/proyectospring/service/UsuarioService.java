package edu.curso.java.spring.proyectospring.service;

import java.util.List;

import edu.curso.java.spring.proyectospring.bo.Usuario;

public interface UsuarioService {

	List<Usuario> buscarUsuarios();

	List<Usuario> buscarUsuarios(String nombreUsuario);

	Usuario buscarUsuarioPorId(Long id);
	
	Usuario buscarUsuarioPorNombreUsuario(String nombreUsuario);

	Long altaUsuario(Usuario usuario);

	void actualizarUsuario(Usuario usuario);

	void borrarUsuario(Long id);

}