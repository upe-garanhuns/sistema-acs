package br.upe.acs.controlador;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.upe.acs.controlador.respostas.CertificadoResposta;
import br.upe.acs.servico.CertificadoServico;
import br.upe.acs.utils.AcsExcecao;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/certificado")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class CertificadoControlador {

    private final CertificadoServico servico;

    @Operation(summary = "Buscar certificado por id")
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarCertificadoPorId(@PathVariable("id") Long id) {
        ResponseEntity<?> resposta;
        try {
            CertificadoResposta certificadoResposta = new CertificadoResposta(servico.buscarCertificadoPorId(id).orElseThrow());
            resposta = ResponseEntity.ok(certificadoResposta);
        } catch (AcsExcecao e) {
            resposta = ResponseEntity.badRequest().body(e.getMessage());
        }
        
        return resposta;
    }
}
