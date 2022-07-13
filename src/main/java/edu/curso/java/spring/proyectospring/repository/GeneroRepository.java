package edu.curso.java.spring.proyectospring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.curso.java.spring.proyectospring.bo.Genero;

@Repository
public interface GeneroRepository extends CrudRepository<Genero, Long> {
	
	@Query(value = "select g from Genero g")
	public List<Genero> buscarGeneros();
	
	@Query(value = "select g from Genero g where g.nombre like %:nombre%")
	public List<Genero> buscarGeneros(@Param("nombre") String nombre);
	
	@Query(value= "select g from Genero g where g.id = ?1")
	public Genero buscarGeneroPorId(Long id);

}
