package br.upe.acs.controleCurso;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import br.upe.acs.dominio.Curso;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import br.upe.acs.servico.CursoServico;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class TesteCursoControlador {

    @Mock
    private CursoServico cursoServico;

    @InjectMocks
    private br.upe.acs.controlador.CursoControlador cursoControlador;

    private MockMvc mockMvc;

    @Test
    public void testListarCursos() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(cursoControlador).build();

        // Lista de mock de cursos
        List<Curso> cursosMock = new ArrayList<>();
        Curso cursoMock = new Curso();
        cursoMock.setId(0L);
        cursoMock.setNome("Curso Mock");
        cursosMock.add(cursoMock);

        when(cursoServico.listarCursos()).thenReturn(cursosMock);

        mockMvc.perform(get("/api/curso"))
                .andExpect(status().isOk());
    }

    @Test
    public void testBuscarCursoPorId() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(cursoControlador).build();

        Long idCurso = 1L;

        Curso cursoMock = new Curso();
        cursoMock.setId(0L);
        cursoMock.setNome("Curso Mock");

        when(cursoServico.buscarCursoPorId(idCurso)).thenReturn(Optional.of(cursoMock));

        mockMvc.perform(get("/api/curso/{id}", idCurso))
                .andExpect(status().isOk());
    }
}
