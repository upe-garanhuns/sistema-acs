package br.upe.acs.config;

import br.upe.acs.dominio.Usuario;
import br.upe.acs.interceptador.InterceptadorVerficacao;
import br.upe.acs.repositorio.AdministradorRepositorio;
import br.upe.acs.repositorio.AlunoRepositorio;
import br.upe.acs.repositorio.ComissaoRepositorio;
import br.upe.acs.repositorio.CoordenadorRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig implements WebMvcConfigurer {

	private final AlunoRepositorio alunoRepositorio;
	private final CoordenadorRepositorio coordenadorRepositorio;
	private final ComissaoRepositorio comissaoRepositorio;
	private final AdministradorRepositorio administradorRepositorio;
	private final JwtService jwtService;

	@Bean
	public UserDetailsService userDetailsService() {
		return this::findByEmail;
	}

	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());

		return authProvider;
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}


	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new InterceptadorVerficacao(alunoRepositorio, jwtService))
				.addPathPatterns("/api/requisicao/**", "/api/atividade/**", "/api/certificado/**");
	}
	private Usuario findByEmail(String email) {
		Usuario usuario = null;
		if (alunoRepositorio.findByEmail(email).isPresent()) {
			usuario = alunoRepositorio.findByEmail(email).orElseThrow();
		} else if (coordenadorRepositorio.findByEmail(email).isPresent()) {
			usuario = coordenadorRepositorio.findByEmail(email).orElseThrow();
		} else if (comissaoRepositorio.findByEmail(email).isPresent()) {
			usuario = comissaoRepositorio.findByEmail(email).orElseThrow();
		} else if (administradorRepositorio.findByEmail(email).isPresent()) {
			usuario = administradorRepositorio.findByEmail(email).orElseThrow();
		}

		if (usuario == null) {
			throw new UsernameNotFoundException("Usuário não encontrado");
		}

		return usuario;
	}
}
