package edu.curso.java.spring.proyectospring.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.curso.java.spring.proyectospring.bo.Authority;
import edu.curso.java.spring.proyectospring.bo.Pelicula;
import edu.curso.java.spring.proyectospring.repository.AuthorityRepository;

@Service
@Transactional
public class AuthorityServiceImpl implements AuthorityService {

	@Autowired
	private AuthorityRepository authorityRepository;
	
	@Override
	public List<Authority> buscarAuthorities(){
		return authorityRepository.buscarAuthorities();
	}
	
	@Override
	public List<Authority> buscarAuthorities(String authority){
		return authorityRepository.buscarAuthorities(authority);
	}
	
	@Override
	public Authority buscarAuthorityPorId(Long id) {
		Optional<Authority> authority = authorityRepository.findById(id);
		if(authority.isEmpty()) {
			return null;
		}
		return authority.get();
	}
	
	@Override
	public Long altaAuthority(Authority authority) {
		authorityRepository.save(authority);
		return authority.getId();
	}
	
	@Override
	public void actualizarAuthority(Authority authority) {
		authorityRepository.save(authority);
	}
	
	@Override
	public void borrarAuthority(Long id) {
		authorityRepository.deleteById(id);;
	}

	@Override
	public Authority buscarAuthoritiesPorNombre(String nombreUsuario) {
		// TODO Auto-generated method stub
		return authorityRepository.buscarAuthoritiesPorNombre(nombreUsuario);
	}
}
