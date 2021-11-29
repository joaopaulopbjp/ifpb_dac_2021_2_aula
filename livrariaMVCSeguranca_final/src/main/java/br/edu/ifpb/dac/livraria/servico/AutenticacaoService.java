package br.edu.ifpb.dac.livraria.servico;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.edu.ifpb.dac.livraria.modelo.Usuario;
import br.edu.ifpb.dac.livraria.repositorio.UsuarioRepositorio;


@Service
public class AutenticacaoService implements UserDetailsService {

	@Autowired
	private UsuarioRepositorio usuarioRep;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> usuarioRecuperado = usuarioRep.findByEmail(username);
		if (usuarioRecuperado.isPresent()) {
			return usuarioRecuperado.get();
		}
		
		throw new UsernameNotFoundException("Usuário ou senha inválidos.");
	}

}
