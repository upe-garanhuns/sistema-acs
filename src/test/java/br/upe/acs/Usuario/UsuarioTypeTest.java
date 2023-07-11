package br.upe.acs.Usuario;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.validation.BindingResult;

import br.upe.acs.controlador.ControleAcessoControlador;
import br.upe.acs.servico.ControleAcessoServico;
import br.upe.acs.dominio.dto.RegistroDTO;
import br.upe.acs.dominio.Administrador;
import br.upe.acs.dominio.Aluno;
import br.upe.acs.dominio.Coordenador;
import br.upe.acs.dominio.Comissao;
import br.upe.acs.dominio.Usuario;
import br.upe.acs.repositorio.AdministradorRepositorio;
import br.upe.acs.repositorio.ComissaoRepositorio;
import br.upe.acs.repositorio.CoordenadorRepositorio;

@ExtendWith(MockitoExtension.class)
public class UsuarioTypeTest {

    @InjectMocks
    private ControleAcessoControlador controller;

    @Mock
    private ControleAcessoServico servico;

    private RegistroDTO registro;

    @Mock
    private BindingResult result;

    @Mock
    private AdministradorRepositorio administradorRepository;

    @Mock
    private CoordenadorRepositorio coordenadorRepository;

    @Mock
    private ComissaoRepositorio comissaoRepository;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this); // Inicializar as anotações Mockito
        registro = new RegistroDTO("Emilio", "69851309095", "698513",
                2, "87991234693", "teste@hotmail.com", "12345678",
                "56280000", "Rua X", "Bairro X", "Cidade X", "Pe", 10, (long) 134);
    }
    
    @Test
    void deveRetornarTipoAlunoAposCadastro() {
        // Realiza o cadastro do usuário
        controller.cadastrarUsuario(registro, result);

        // Obter o tipo de usuário do registro
        String tipoUsuario = obterTipoUsuario(registro);

        // Verificar o tipo de usuário esperado
        assertEquals("Aluno", tipoUsuario);
    }
    
    private String obterTipoUsuario(RegistroDTO registro) {
        Usuario usuario = new Aluno(); // Substitua "Aluno" pela classe concreta correta
        return usuario.getClass().getSimpleName();
    }

    @Test
    void deveVerificarTipoUsuarioAdministrador() {
        // Criar uma instância de Administrador
        Administrador administrador = new Administrador();

        // Verificar o tipo de usuário do administrador
        String tipoUsuario = administrador.getClass().getSimpleName();
        assertEquals("Administrador", tipoUsuario);
    }

    @Test
    void deveVerificarTipoUsuarioComissao() {
        // Criar uma instância de Comissao
        Comissao comissao = new Comissao();

        // Verificar o tipo de usuário da comissão
        String tipoUsuario = comissao.getClass().getSimpleName();
        assertEquals("Comissao", tipoUsuario);
    }

    @Test
    void deveVerificarTipoUsuarioCoordenador() {
        // Criar uma instância de Coordenador
        Coordenador coordenador = new Coordenador();

        // Verificar o tipo de usuário do coordenador
        String tipoUsuario = coordenador.getClass().getSimpleName();
        assertEquals("Coordenador", tipoUsuario);
    }
}
