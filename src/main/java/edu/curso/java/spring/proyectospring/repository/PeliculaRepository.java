package edu.curso.java.spring.proyectospring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.curso.java.spring.proyectospring.bo.Pelicula;

@Repository
public interface PeliculaRepository extends CrudRepository<Pelicula, Long>{

	@Query(value = "select p from Pelicula p")
	public List<Pelicula> buscarPeliculas();
	
	@Query(value = "select p from Pelicula p where p.titulo like %:titulo%")
	public List<Pelicula> buscarPeliculas(@Param("titulo") String titulo);
	
	@Query(value= "select p from Pelicula p where p.id = ?1")
	public Pelicula buscarPeliculaPorId(Long id);
	
	@Query(value= "select p from Pelicula as p where p.genero.id = ?1")
	public List<Pelicula> recuperarPeliculaPorGenero(Long id);

}
