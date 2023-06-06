package br.upe.acs.servico;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.upe.acs.config.JwtService;
import br.upe.acs.controlador.respostas.AutenticacaoResposta;
import br.upe.acs.dominio.Curso;
import br.upe.acs.dominio.Endereco;
import br.upe.acs.dominio.Usuario;
import br.upe.acs.dominio.dto.EmailDTO;
import br.upe.acs.dominio.dto.EnderecoDTO;
import br.upe.acs.dominio.dto.LoginDTO;
import br.upe.acs.dominio.dto.RegistroDTO;
import br.upe.acs.dominio.enums.PerfilEnum;
import br.upe.acs.repositorio.UsuarioRepositorio;
import br.upe.acs.utils.AcsExcecao;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ControleAcessoServico {

	private final UsuarioRepositorio repositorio;

	private final PasswordEncoder passwordEncoder;

	private final JwtService jwtService;

	private final AuthenticationManager authenticationManager;

	private final EmailServico emailServico;
	
	private final EnderecoServico enderecoServico;
	
	private final CursoServico cursoServico;

	public AutenticacaoResposta cadastrarUsuario(RegistroDTO registro) throws AcsExcecao {
		Usuario usuarioSalvar = new Usuario();
		
		EnderecoDTO enderecoSalvar = new EnderecoDTO();
		enderecoSalvar.setCep(registro.getCep());
		enderecoSalvar.setCidade(registro.getCidade());
		enderecoSalvar.setBairro(registro.getBairro());
		enderecoSalvar.setRua(registro.getRua());
		enderecoSalvar.setNumero(registro.getNumero());
		enderecoSalvar.setUF(registro.getUF());
		
		Endereco enderecoSalvo = enderecoServico.adicionarEndereco(enderecoSalvar);

		usuarioSalvar.setNomeCompleto(registro.getNomeCompleto());
		usuarioSalvar.setCpf(registro.getCpf());
		usuarioSalvar.setPeriodo(registro.getPeriodo());
		usuarioSalvar.setTelefone(registro.getTelefone());
		usuarioSalvar.setEmail(registro.getEmail());
		validarSenha(registro.getSenha());
		usuarioSalvar.setSenha(passwordEncoder.encode(registro.getSenha()));
		usuarioSalvar.setPerfil(PerfilEnum.USUARIO);
		String codigoVerificacao = gerarCodigoVerificacao();
		usuarioSalvar.setCodigoVerificacao(codigoVerificacao);
		usuarioSalvar.setVerificado(false);
		usuarioSalvar.setEndereco(enderecoSalvo);
		Curso cursoSalvar = cursoServico.buscarCursoPorId(registro.getCursoId()).get();
		usuarioSalvar.setCurso(cursoSalvar);

		repositorio.save(usuarioSalvar);

		CompletableFuture.runAsync(() -> {
			enviarEmail(registro, codigoVerificacao);
		});

		return gerarAutenticacaoResposta(usuarioSalvar);
	}

	public AutenticacaoResposta loginUsuario(LoginDTO login) {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getEmail(), login.getSenha()));
		Usuario usuario = repositorio.findByEmail(login.getEmail()).orElseThrow();

		return gerarAutenticacaoResposta(usuario);
	}

	private AutenticacaoResposta gerarAutenticacaoResposta(Usuario usuario) {
		String jwtToken = jwtService.generateToken(usuario);
		AutenticacaoResposta autenticacaoResposta = new AutenticacaoResposta();
		autenticacaoResposta.setToken(jwtToken);

		return autenticacaoResposta;
	}

	private void enviarEmail(RegistroDTO registro, String codigoVerificacao) {
		EmailDTO email = new EmailDTO();

		email.setAssunto("Código de verificação - Sistema ACs UPE");
		email.setDestinatario(registro.getEmail());
		email.setMensagem(
				"Confirme seu email, envie esse código na página de verificação do sistema: " + codigoVerificacao);
		emailServico.enviarEmail(email);
	}

	private static String gerarCodigoVerificacao() {
		String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		StringBuilder codigo = new StringBuilder();
		Random random = new Random();

		for (int i = 0; i < 10; i++) {
			int indice = random.nextInt(caracteres.length());
			char caractere = caracteres.charAt(indice);
			codigo.append(caractere);
		}

		return codigo.toString();
	}

	private void validarSenha(String senha) throws AcsExcecao {
		boolean comMaiuscula = false, comMinuscula = false, comNumerico = false, comEspecial = false;
		for (char caracteres : senha.toCharArray()) {
			if (caracteres >= '0' && caracteres <= '9') {
				comNumerico = true;
			} else if (caracteres >= 'A' && caracteres <= 'Z') {
				comMaiuscula = true;
			} else if (caracteres >= 'a' && caracteres <= 'z') {
				comMinuscula = true;
			} else {
				comEspecial = true;
			}
		}
		if (!(comMaiuscula && comMinuscula && comNumerico && comEspecial)) {
			String error = "Senha inválida: A senha necessita de caracteres";

			if (!comMaiuscula) {
				error += " maiusculos ";
			}

			if (!comMinuscula) {
				error += " minusculos;";
			}

			if (!comNumerico) {
				error += " numericos;";
			}

			if (!comEspecial) {
				error += " especiais;";
			}

			throw new AcsExcecao(error);
		}
	}
}
