package br.edu.ifpb.dac.livraria.controlador;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpb.dac.livraria.modelo.Usuario;
import br.edu.ifpb.dac.livraria.modelo.dto.JwtRespostaDto;
import br.edu.ifpb.dac.livraria.modelo.dto.LoginDto;
import br.edu.ifpb.dac.livraria.seguranca.util.JwtUtils;

@RestController
@RequestMapping("/seguranca")
public class SegurancaControlador {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtUtils jwtUtils;

	@PostMapping("/login")
	public JwtRespostaDto login(@Valid @RequestBody LoginDto loginRequest){
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getLogin(), loginRequest.getSenha()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		Usuario userDetails = (Usuario) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());

		JwtRespostaDto resposta = new JwtRespostaDto(jwt, 
				 userDetails.getId(), 
				 userDetails.getNome(),
				 userDetails.getUsername(), 
				 userDetails.getEmail(), 
				 roles);
		
		return resposta;
	}
}
