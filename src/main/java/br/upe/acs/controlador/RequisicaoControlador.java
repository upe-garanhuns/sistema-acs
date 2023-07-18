package br.upe.acs.controlador;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import br.upe.acs.config.JwtService;
import br.upe.acs.dominio.dto.RequisicaoRascunhoDTO;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.upe.acs.controlador.respostas.RequisicaoResposta;
import br.upe.acs.dominio.dto.RequisicaoDTO;
import br.upe.acs.servico.RequisicaoCertificadoServico;
import br.upe.acs.servico.RequisicaoRascunhoServico;
import br.upe.acs.servico.RequisicaoServico;
import br.upe.acs.utils.AcsExcecao;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/requisicao")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class RequisicaoControlador {

    private final RequisicaoServico servico;

    private final JwtService jwtService;

    private final RequisicaoCertificadoServico requisicaoCertificadoServico;
    
    private final RequisicaoRascunhoServico requisicaoRascunhoServico;

    @Operation(summary = "Listar todas as requisições")
    @GetMapping
    public ResponseEntity<List<RequisicaoResposta>> listarRequisicoes() {
        return ResponseEntity.ok(servico.listarRequisicoes().stream()
                .map(RequisicaoResposta::new).collect(Collectors.toList()));
    }

    @Operation(summary = "Listar as requisições com paginação")
    @GetMapping("/paginacao")
    public ResponseEntity<Map<String, Object>> listarRequisicoesPaginas(@RequestParam(defaultValue = "0") int pagina,
                                                                        @RequestParam(defaultValue = "10") int quantidade) {
        return ResponseEntity.ok(servico.listarRequisicoesPaginadas(pagina, quantidade));
    }

    @Operation(summary = "Listar as requisições de um usuário específico")
    @GetMapping("/usuario/{id}")
    public ResponseEntity<?> listarRequisicoesPorAluno(@PathVariable("id") Long alunoId) {
        try {
            return ResponseEntity.ok(servico.listarRequisicoesPorAluno(alunoId).stream()
                    .map(RequisicaoResposta::new).toList());
        } catch (AcsExcecao e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Operation(summary = "Buscar requisição por id")
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarRequisicaoPorId(@PathVariable("id") Long id) {
        try {
            RequisicaoResposta requisicaoResposta = new RequisicaoResposta(servico.buscarRequisicaoPorId(id));
            return ResponseEntity.ok(requisicaoResposta);
        } catch (AcsExcecao e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Operation(summary = "Adicionar requisição com certificados")
    @PostMapping(consumes = {"multipart/form-data"})
    public ResponseEntity<?> adicionarRequisicao(
            HttpServletRequest request,
            @RequestParam(value = "qtdCertificados") int qtdCertificados,
            @RequestPart(value = "certificados") MultipartFile[] certificados,
            @RequestPart(value = "certificadosMetadados") MultipartFile certificadosMetadados) {
        String email = jwtService.extractUsername(request.getHeader("Authorization").substring(7));
        RequisicaoDTO requisicaoDTO = new RequisicaoDTO();
        requisicaoDTO.setQtdCertificados(qtdCertificados);
        requisicaoDTO.setCertificados(certificados);
        requisicaoDTO.setCertificadosMetadados(certificadosMetadados);

        ResponseEntity<?> resposta;
        try {
            resposta = ResponseEntity.ok(requisicaoCertificadoServico.adicionarRequisicao(requisicaoDTO, email));
        } catch (Exception e) {
            resposta = ResponseEntity.badRequest().body(e.getMessage());
        }

        return resposta;
    }

    @PostMapping(path = "/rascunho", consumes = {"multipart/form-data"})
    public ResponseEntity<?> adicionarRequisicaoRascunho(@RequestParam(value = "usuarioId") Long usuarioId,
                                                         @RequestParam(value = "cursoId") Long cursoId,
                                                         @RequestParam(value = "semestre") int semestre,
                                                         @RequestParam(value = "observacao") String observacao,
                                                         @RequestParam(value = "qtdCertificados") int qtdCertificados,
                                                         @RequestPart(value = "certificados", required = false) MultipartFile[] certificados,
                                                         @RequestPart(value = "certificadosMetadados") MultipartFile certificadosMetadados) {
        RequisicaoRascunhoDTO requisicaoRascunhoDTO = new RequisicaoRascunhoDTO();
        requisicaoRascunhoDTO.setSemestre(semestre);
        requisicaoRascunhoDTO.setQtdCertificados(qtdCertificados);
        requisicaoRascunhoDTO.setUsuarioId(usuarioId);
        requisicaoRascunhoDTO.setCursoId(cursoId);
        requisicaoRascunhoDTO.setObservacao(observacao);
        requisicaoRascunhoDTO.setCertificadoArquivos(certificados);
        requisicaoRascunhoDTO.setCertificadosMetadados(certificadosMetadados);

        ResponseEntity<?> resposta;
        try {
            requisicaoCertificadoServico.salvarRascunho(requisicaoRascunhoDTO);
            resposta = ResponseEntity.ok().build();
        } catch (Exception e) {
            resposta = ResponseEntity.badRequest().body(e.getMessage());
        }

        return resposta;
    }
    
    @Operation(summary = "Editar rascunho da requisição com certificados")
    @PutMapping(path = "rascunho/{id}", consumes = {"multipart/form-data"})
    public ResponseEntity<?> editarRequisicaoRascunho(HttpServletRequest request, 
    												 @PathVariable ("id") Long id,	
											          @RequestParam(value = "cursoId") Long cursoId,
											          @RequestParam(value = "semestre") int semestre,
											          @RequestParam(value = "qtdCertificados") int qtdCertificados,
											          @RequestPart(value = "certificados", required = false) MultipartFile[] certificados,
											          @RequestPart(value = "certificadosMetadados") MultipartFile certificadosMetadados){
       
    	RequisicaoRascunhoDTO requisicaoRascunhoDTO = new RequisicaoRascunhoDTO();
        requisicaoRascunhoDTO.setSemestre(semestre);
        requisicaoRascunhoDTO.setQtdCertificados(qtdCertificados);
        requisicaoRascunhoDTO.setCursoId(cursoId);
        requisicaoRascunhoDTO.setCertificadoArquivos(certificados);
        requisicaoRascunhoDTO.setCertificadosMetadados(certificadosMetadados);
        
        
    	ResponseEntity<?> resposta;
    	String token = request.getHeader("Authorization").substring(7);
    	try {
    		requisicaoCertificadoServico.editarRequisicaoRascunho(id, token, requisicaoRascunhoDTO);
    		resposta = ResponseEntity.ok().build();    		
    	} catch(Exception e) {
    		resposta = ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    	}
    	
    	return resposta;
    }

    @Operation(summary = "Deletar rascunho de uma requisição")
    @DeleteMapping("/rascunho/{id}")
    public ResponseEntity<?> deletarRequisicaoRascunho(@PathVariable("id") Long id, 
    												   @RequestHeader(name = "Authorization", required = true) String token){
    	ResponseEntity<?> resposta;
    	String jwt =  token.substring(7);
    	try {
    		requisicaoRascunhoServico.deletarRequisicaoRascunho(id, jwt);
    		resposta = ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    		
    	} catch(Exception e) {
    		resposta = ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    	}
    	
    	return resposta;
    }

    @Operation(summary = "Baixar pdf de uma requisição")
    @GetMapping("{id}/pdf")
    public ResponseEntity<?> gerarRequisicaoPDF(@PathVariable("id") Long requisicaoId) {
        ResponseEntity<?> resposta;

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDisposition(ContentDisposition.attachment()
                    .filename("requisição" + requisicaoId + ".pdf").build());
            resposta = ResponseEntity.ok().headers(headers).body(servico.gerarRequisicaoPDF(requisicaoId));
        } catch (AcsExcecao e) {
            resposta = ResponseEntity.badRequest().body(e.getMessage());
        }

        return resposta;
    }
    
    
}
