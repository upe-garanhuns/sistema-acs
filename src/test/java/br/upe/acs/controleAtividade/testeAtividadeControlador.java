package br.upe.acs.controleAtividade;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import br.upe.acs.dominio.Atividade;
import br.upe.acs.dominio.enums.EixoEnum;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import br.upe.acs.servico.AtividadeServico;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class testeAtividadeControlador {

    @Mock
    private AtividadeServico atividadeServico;

    @InjectMocks
    private br.upe.acs.controlador.AtividadeControlador atividadeControlador;

    private MockMvc mockMvc;

    @Test
    public void testListarAtividades() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(atividadeControlador).build();

        //Lista de mock de atividades
        List<Atividade> atividadesMock = new ArrayList<>();
        Atividade atividadeMock = new Atividade();
        atividadeMock.setId(0L);
        atividadeMock.setEixo(EixoEnum.PESQUISA);
        atividadeMock.setDescricao("string");
        atividadeMock.setChMaxima(0);
        atividadesMock.add(atividadeMock);

        when(atividadeServico.listarAtividades()).thenReturn(atividadesMock);

        mockMvc.perform(get("/api/atividade"))
                .andExpect(status().isOk());
    }

    @Test
    public void testBuscarAtividadePorId() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(atividadeControlador).build();

        Long idAtividade = 1L;

        List<Atividade> atividadesMock = new ArrayList<>();
        Atividade atividadeMock = new Atividade();
        atividadeMock.setId(0L);
        atividadeMock.setEixo(EixoEnum.PESQUISA);
        atividadeMock.setDescricao("string");
        atividadeMock.setChMaxima(0);
        atividadesMock.add(atividadeMock);

        when(atividadeServico.buscarAtividadePorId(idAtividade)).thenReturn(atividadeMock);

        mockMvc.perform(get("/api/atividade/{id}", idAtividade))
                .andExpect(status().isOk());
    }

    @Test
    public void testBuscarAtividadePorEixo() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(atividadeControlador).build();

        String eixo = "PESQUISA";

        List<Atividade> atividadesMock = new ArrayList<>();
        Atividade atividadeMock = new Atividade();
        atividadeMock.setId(0L);
        atividadeMock.setEixo(EixoEnum.PESQUISA);
        atividadeMock.setDescricao("string");
        atividadeMock.setChMaxima(0);
        atividadesMock.add(atividadeMock);

        when(atividadeServico.buscarAtividadePorEixo(eixo)).thenReturn(atividadesMock);

        mockMvc.perform(get("/api/atividade/eixo").param("eixo", eixo))
                .andExpect(status().isOk());
    }
}
