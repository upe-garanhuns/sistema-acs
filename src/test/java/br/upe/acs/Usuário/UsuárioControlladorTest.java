package br.upe.acs.Usuário;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.upe.acs.controlador.UsuarioControlador;
import br.upe.acs.servico.ControleAcessoServico;
import br.upe.acs.utils.AcsExcecao;
import jakarta.servlet.http.HttpServletRequest;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;

import br.upe.acs.dominio.dto.AlterarSenhaDTO;

public class UsuárioControlladorTest {
	
		@InjectMocks
	    private UsuarioControlador controlador;

	    @Mock
	    private ControleAcessoServico controleAcessoServico;
	    
	    @BeforeEach
	    public void setUp() {
	        MockitoAnnotations.openMocks(this);
	    }

	    @Test
	    public void testAlterarSenhaComSucesso() {
	        String token = "Token";
	        AlterarSenhaDTO alterarSenhaDTO = new AlterarSenhaDTO();
	        alterarSenhaDTO.setSenha("Senha123@");
	        alterarSenhaDTO.setNovaSenha("NovaSenha123@");

	        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
	        Mockito.when(request.getHeader("Authorization")).thenReturn("Bearer " + token);

	        try {
				Mockito.doNothing().when(controleAcessoServico).alterarSenha(token, alterarSenhaDTO.getSenha(), alterarSenhaDTO.getNovaSenha());
			} catch (AcsExcecao e) {
				e.printStackTrace();
			}

	        ResponseEntity<?> resposta = controlador.alterarSenha(request, alterarSenhaDTO);

	        assertEquals(HttpStatus.NO_CONTENT, resposta.getStatusCode());
	    }
	    
	    @Test
		public void testAlterarSenha_Falha() throws AcsExcecao {
			String token = "Token";
			AlterarSenhaDTO alterarSenhaDTO = new AlterarSenhaDTO();
			alterarSenhaDTO.setSenha("SenhaAtual123@");
			alterarSenhaDTO.setNovaSenha("NovaSenha123@");

			HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
			Mockito.when(request.getHeader("Authorization")).thenReturn("Bearer " + token);

			String mensagemErro = "Erro ao alterar a senha";
			Mockito.doThrow(new AcsExcecao(mensagemErro)).when(controleAcessoServico).alterarSenha(token, alterarSenhaDTO.getSenha(),
					alterarSenhaDTO.getNovaSenha());

			ResponseEntity<?> resposta = controlador.alterarSenha(request, alterarSenhaDTO);

			assertEquals(HttpStatus.BAD_REQUEST, resposta.getStatusCode());
			assertEquals(mensagemErro, resposta.getBody());
			
		}

}
