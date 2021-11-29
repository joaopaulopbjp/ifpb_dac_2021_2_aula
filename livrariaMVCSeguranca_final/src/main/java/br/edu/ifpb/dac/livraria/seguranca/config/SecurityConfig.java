package br.edu.ifpb.dac.livraria.seguranca.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.edu.ifpb.dac.livraria.servico.AutenticacaoService;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private AutenticacaoService autenticacaoService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(autenticacaoService).passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers(HttpMethod.GET, "/autores/publico/lista").permitAll()
	    .antMatchers(HttpMethod.GET, "/autores/protegido/*").hasAuthority("ADMIN")
		.antMatchers(HttpMethod.POST, "/autores/protegido/*").hasAuthority("ADMIN")
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.defaultSuccessUrl("/autores/publico/lista",true);
	}

	
	/** Para facilitar a geração de senha encriptada */
	public static void main(String[] args) {
		System.out.println(new BCryptPasswordEncoder().encode("123"));
	}
	
}
