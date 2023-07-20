package br.upe.acs.controleAcesso;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import br.upe.acs.controlador.ControleAcessoControlador;
import br.upe.acs.servico.ControleAcessoServico;
import br.upe.acs.dominio.dto.RegistroDTO;


@ExtendWith(MockitoExtension.class)
public class ControleAcessoTest {
	
	@InjectMocks
	private ControleAcessoControlador controller;
	
	@Mock
	private ControleAcessoServico servico;
	
	private RegistroDTO registro;
	
	@Mock
	private BindingResult result;
	
	@BeforeEach
	void setup() {
		MockitoAnnotations.initMocks(this); // Inicializar as anotações Mockito
		registro = new RegistroDTO("Emilio", "69851309095", "698513", 2, "87991234693", 
				"teste@hotmail.com", "12345678", "56280000", "Rua X", "Bairro X", "Cidade X", "Pe", 10, (long) 134);
	}
	
	@Test
	void deveSalvarUsuarioComSucesso() {
        ResponseEntity<?> response = assertDoesNotThrow(() -> controller.cadastrarUsuario(registro, result));
        assertEquals(ResponseEntity.ok().build(), response);

 	
	}
	
	@Test
	void nãoDeveSalvarUsuario() {
		registro.setNomeCompleto("E"); // dado inválido
		registro.setPeriodo(-2); // dado inválido
		registro.setEmail("email"); //dado inválido

        ResponseEntity<?> response = controller.cadastrarUsuario(registro, result);
        assertNotEquals(ResponseEntity.status(200).build(), response);

	}



}