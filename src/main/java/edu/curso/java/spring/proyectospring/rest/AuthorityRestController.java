package edu.curso.java.spring.proyectospring.rest;

import java.util.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import edu.curso.java.spring.proyectospring.bo.Authority;
import edu.curso.java.spring.proyectospring.rest.dto.AuthorityDTO;
import edu.curso.java.spring.proyectospring.service.AuthorityService;

@RestController
@RequestMapping("/api/authority")
public class AuthorityRestController {

	@Autowired
	private AuthorityService authorityService;
	
	@GetMapping(path = "/{nombreUsuario}")
	public ResponseEntity<AuthorityDTO> recuperarAuthorityPorId(@PathVariable Long id) {
		Authority authority = authorityService.buscarAuthorityPorId(id);
		AuthorityDTO authorityDTO = new AuthorityDTO(authority);
		return ResponseEntity.ok(authorityDTO);
	}
	
	@GetMapping
	public ResponseEntity<List<AuthorityDTO>> buscarAuthorities() {
		List<Authority> authorities = authorityService.buscarAuthorities();
		List<AuthorityDTO> authorityDTO = new ArrayList<AuthorityDTO>();
		for(Authority a : authorities) {
			authorityDTO.add(new AuthorityDTO(a));
		}
		
		return ResponseEntity.ok(authorityDTO);
	}
	
	@PostMapping
	public ResponseEntity<AuthorityDTO> altaAuthority(@Valid @RequestBody AuthorityDTO authorityDTO) {
			
		Authority authority = new Authority();
		authority.setAuthority(authorityDTO.getAuthority() + "_ROLE");
		authority.setNombreUsuario(authorityDTO.getNombreUsuario());
		
		Long idGenerado = authorityService.altaAuthority(authority);
		authority.setId(idGenerado);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(authorityDTO);
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity actualizarAuthority(@PathVariable Long id, @RequestBody AuthorityDTO authorityDTO) {
		Authority authority = authorityService.buscarAuthorityPorId(id);
		authority.setAuthority(authorityDTO.getAuthority() + "_ROLE");
		authority.setNombreUsuario(authorityDTO.getNombreUsuario());
		
		authorityService.actualizarAuthority(authority);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity borrarAuthority(@PathVariable Long id) {
		authorityService.borrarAuthority(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
