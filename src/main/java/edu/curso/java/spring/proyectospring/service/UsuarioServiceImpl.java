package edu.curso.java.spring.proyectospring.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.curso.java.spring.proyectospring.bo.Usuario;
import edu.curso.java.spring.proyectospring.repository.UsuarioRepository;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public List<Usuario> buscarUsuarios(){
		return usuarioRepository.buscarUsuarios();
	}
	
	@Override
	public List<Usuario> buscarUsuarios(String nombreUsuario){
		return usuarioRepository.buscarUsuarios(nombreUsuario);
	}
	
	@Override
	public Usuario buscarUsuarioPorId(Long id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		if(usuario.isEmpty()) {
			return null;
		}
		return usuario.get();
	}
	
	public Usuario buscarUsuarioPorNombreUsuario(String nombreUsuario) {
		return usuarioRepository.buscarUsuarioPorNombreUsuario(nombreUsuario);
	}
	
	@Override
	public Long altaUsuario(Usuario usuario) {
		usuarioRepository.save(usuario);
		return usuario.getId();
	}
	
	@Override
	public void actualizarUsuario(Usuario usuario) {
		usuarioRepository.save(usuario);
	}
	
	@Override
	public void borrarUsuario(Long id) {
		usuarioRepository.deleteById(id);
	}

}
