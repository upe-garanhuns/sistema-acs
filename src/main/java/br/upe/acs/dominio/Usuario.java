package br.upe.acs.dominio;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Usuario implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nomeCompleto;
	
	private String cpf;
	
	private String telefone;
	
	private String email;
	
	private String senha;
	
	@ManyToOne
	private Curso curso;

	private String tokenRecuperacaoSenha;

	private LocalDateTime dataExpiracaoToken;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority(getClass().getSimpleName()));
	};

	@Override
	public String getPassword() {
		return senha;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setTokenRecuperacaoSenha(String token) {
        this.tokenRecuperacaoSenha = token;
    }

    public void setDataExpiracaoToken(LocalDateTime dataExpiracao) {
        this.dataExpiracaoToken = dataExpiracao;
    }
    
    public LocalDateTime getDataExpiracaoToken() {
        return dataExpiracaoToken;
    }
    
    public boolean isTokenRecuperacaoSenhaValido() {
        return tokenRecuperacaoSenha != null && dataExpiracaoToken != null && dataExpiracaoToken.isAfter(LocalDateTime.now());
    }

    
    public String getEmail() {
        return email;
    }


}
