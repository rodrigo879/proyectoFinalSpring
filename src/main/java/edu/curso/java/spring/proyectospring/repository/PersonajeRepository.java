package edu.curso.java.spring.proyectospring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.curso.java.spring.proyectospring.bo.Personaje;


@Repository
public interface PersonajeRepository extends CrudRepository<Personaje, Long> {
	
	@Query(value = "select p from Personaje p")
	public List<Personaje> buscarPersonajes();
	
	@Query(value = "select p from Personaje p where p.nombre like %:nombre%")
	public List<Personaje> buscarPersonajes(@Param("nombre") String nombre);
	
	//@Query(value = "select p from Personaje as p where p.pelicula.id = ?1")
	//public List<Personaje> recuperarPersonajePorPelicula(Long id);
	
	@Query(value = "select * from Personajes p where p.pelicula_id = ?1", nativeQuery = true)
	public List<Personaje> recuperarPersonajePorPelicula(Long id);
	
	//public List<Personaje> ordenarPersonajesPor

}
