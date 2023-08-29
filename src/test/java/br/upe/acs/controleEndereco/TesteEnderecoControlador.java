package br.upe.acs.controleEndereco;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import br.upe.acs.dominio.dto.ViaCepDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import br.upe.acs.servico.EnderecoServico;
import br.upe.acs.utils.CepInvalidoExcecao;

@ExtendWith(MockitoExtension.class)
public class TesteEnderecoControlador {

    @Mock
    private EnderecoServico enderecoServico;

    @InjectMocks
    private br.upe.acs.controlador.EnderecoControlador enderecoControlador;

    private MockMvc mockMvc;

    @Test
    public void testBuscarEnderecoPorCep() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(enderecoControlador).build();

        String cep = "12345678";

        ViaCepDTO viaCepDTO = new ViaCepDTO();
        viaCepDTO.setLocalidade("Cidade Mock");

        when(enderecoServico.buscarEnderecoPorCep(cep)).thenReturn(viaCepDTO);

        mockMvc.perform(get("/api/endereco/{cep}", cep))
                .andExpect(status().isOk());
    }
}
