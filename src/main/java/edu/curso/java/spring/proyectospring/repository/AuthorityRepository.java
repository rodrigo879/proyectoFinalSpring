package edu.curso.java.spring.proyectospring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.curso.java.spring.proyectospring.bo.Authority;



@Repository
public interface AuthorityRepository extends CrudRepository<Authority, Long> {

	@Query(value = "select a from Authority a")
	public List<Authority> buscarAuthorities();
	
	@Query(value = "select a from Authority a where a.authority like %:authority%")
	public List<Authority> buscarAuthorities(@Param("authority") String authority);
	
	@Query(value = "select a from Authority a where a.nombreUsuario like %:nombreUsuario%")
	public Authority buscarAuthoritiesPorNombre(@Param("nombreUsuario") String nombreUsuario);
}
