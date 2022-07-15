package edu.curso.java.spring.proyectospring.rest;

import java.util.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import edu.curso.java.spring.proyectospring.bo.Usuario;
import edu.curso.java.spring.proyectospring.rest.dto.UsuarioDTO;
import edu.curso.java.spring.proyectospring.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioRestController {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<UsuarioDTO> recuperarUsuarioPorId(@PathVariable Long id) {
		Usuario usuario = usuarioService.buscarUsuarioPorId(id);
		UsuarioDTO usuarioDTO = new UsuarioDTO(usuario);
		return ResponseEntity.ok(usuarioDTO);
	}
	
	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> buscarUsuarios() {
		List<Usuario> usuarios = usuarioService.buscarUsuarios();
		List<UsuarioDTO> usuarioDTO = new ArrayList<UsuarioDTO>();
		for(Usuario u : usuarios) {
			usuarioDTO.add(new UsuarioDTO(u));
		}
		
		return ResponseEntity.ok(usuarioDTO);
	}
	
	@PostMapping
	public ResponseEntity<UsuarioDTO> altaUsuario(@Valid @RequestBody UsuarioDTO usuarioDTO) {
		
		Usuario usuario = new Usuario();
		usuario.setNombre(usuarioDTO.getNombre());
		usuario.setApellido(usuarioDTO.getApellido());
		usuario.setNombreUsuario(usuarioDTO.getNombreUsuario());
		usuario.setPassword(usuarioDTO.getPassword());
		usuario.setActivo(true);
		
		Long idGenerado = usuarioService.altaUsuario(usuario);
		usuario.setId(idGenerado);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioDTO);
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity actualizarUsuario(@PathVariable Long id, @RequestBody UsuarioDTO usuarioDTO) {
		Usuario usuario = usuarioService.buscarUsuarioPorId(id);
		usuario.setNombre(usuarioDTO.getNombre());
		usuario.setApellido(usuarioDTO.getApellido());
		usuario.setNombreUsuario(usuarioDTO.getNombreUsuario());
		usuario.setPassword(usuarioDTO.getPassword());
		usuario.setActivo(usuarioDTO.getActivo());
		
		usuarioService.actualizarUsuario(usuario);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity borrarUsuario(@PathVariable Long id) {
		usuarioService.borrarUsuario(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
