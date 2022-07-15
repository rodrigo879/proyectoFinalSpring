package edu.curso.java.spring.proyectospring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.curso.java.spring.proyectospring.bo.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
	
	@Query(value = "select u from Usuario u")
	public List<Usuario> buscarUsuarios();
	
	@Query(value = "select u from Usuario u where u.nombreUsuario like %:nombreUsuario%")
	public List<Usuario> buscarUsuarios(@Param("nombreUsuario") String nombreUsuario);
	
	@Query(value= "select u from Usuario u where u.id = ?1")
	public Usuario buscarUsuarioPorId(Long id);
	
	@Query(value= "select u from Usuario u where u.nombreUsuario like %:nombreUsuario%")
	public Usuario buscarUsuarioPorNombreUsuario(String nombreUsuario);

}
