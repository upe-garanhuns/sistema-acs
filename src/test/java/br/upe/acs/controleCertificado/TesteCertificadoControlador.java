package br.upe.acs.controleCertificado;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import br.upe.acs.config.JwtService;
import br.upe.acs.dominio.Certificado;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import br.upe.acs.servico.CertificadoServico;

@ExtendWith(MockitoExtension.class)
public class TesteCertificadoControlador {

    @Mock
    private CertificadoServico certificadoServico;

    @Mock
    private JwtService jwtService;

    @InjectMocks
    private br.upe.acs.controlador.CertificadoControlador certificadoControlador;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this); // Inicializa os campos anotados com @Mock e injeta no objeto anotado com @InjectMocks
        mockMvc = MockMvcBuilders.standaloneSetup(certificadoControlador).build();
    }

    @Test
    public void testBuscarCertificadoPorId() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(certificadoControlador).build();

        Long idCertificado = 1L;

        Certificado certificadoMock = new Certificado();

        when(certificadoServico.buscarCertificadoPorId(idCertificado)).thenReturn(certificadoMock);

        mockMvc.perform(get("/api/certificado/{id}", idCertificado))
                .andExpect(status().isOk());
    }

    @Test
    public void testBuscarPdfDoCertificadoPorId() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(certificadoControlador).build();

        Long idCertificado = 1L;

        byte[] pdfData = new byte[0];

        when(certificadoServico.buscarPdfDoCertificadoPorId(idCertificado)).thenReturn(pdfData);

        mockMvc.perform(get("/api/certificado/{id}/pdf", idCertificado))
                .andExpect(status().isOk());
    }

    @Test
    public void testAdicionarCertificado() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(certificadoControlador).build();

        Long requisicaoId = 1L;
        String email = "user@example.com";

        // Simular o upload do MultipartFile

        when(certificadoServico.adicionarCertificado(any(), eq(requisicaoId), eq(email))).thenReturn(1L);

        mockMvc.perform(
                        multipart("/api/certificado")
                                .file("certificado", new byte[0]) // Substitua pelos dados reais do arquivo
                                .param("requisicaoId", requisicaoId.toString())
                                .header("Authorization", "Bearer your_jwt_token_here")
                )
                .andExpect(status().isCreated());
    }

    @Test
    public void testAlterarCertificado() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(certificadoControlador).build();

        Long certificadoId = 1L;

        // Simular dados do DTO
        String titulo = "Novo título";
        String dataInicial = "2023-08-01";
        String dataFinal = "2023-08-15";
        float quantidadeDeHoras = 20.0f;
        long atividadeId = 2L;

        Certificado certificadoMock = new Certificado();
        // Defina outros campos do certificado mock conforme a sua necessidade

        when(certificadoServico.buscarCertificadoPorId(certificadoId)).thenReturn(certificadoMock);

        mockMvc.perform(
                        put("/api/certificado/{id}", certificadoId)
                                .contentType("application/json")
                                .content("{\"titulo\":\"" + titulo + "\",\"dataInicial\":\"" + dataInicial + "\",\"dataFinal\":\"" + dataFinal + "\",\"quantidadeDeHoras\":" + quantidadeDeHoras + ",\"atividadeId\":" + atividadeId + "}")

                                .header("Authorization", "Bearer your_jwt_token_here")
                )
                .andExpect(status().isNoContent());
    }

    @Test
    public void testExcluirCertificado() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(certificadoControlador).build();

        Long certificadoId = 1L;

        when(certificadoServico.buscarCertificadoPorId(certificadoId)).thenReturn(new Certificado());

        mockMvc.perform(
                        delete("/api/certificado/{id}", certificadoId)
                                .header("Authorization", "Bearer your_jwt_token_here")
                )
                .andExpect(status().isNoContent());
    }
}
