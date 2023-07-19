package br.upe.acs.interceptador;

import br.upe.acs.config.JwtService;
import br.upe.acs.dominio.Aluno;
import br.upe.acs.repositorio.AlunoRepositorio;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Optional;

@Configuration
@RequiredArgsConstructor
public class InterceptadorVerficacao implements HandlerInterceptor {

    private final AlunoRepositorio alunoRepositorio;

    private final JwtService jwtService;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        final String token = request.getHeader("Authorization").substring(7);
        final String email = jwtService.extractUsername(token);
        Optional<Aluno> aluno = alunoRepositorio.findByEmail(email);
        if (aluno.isPresent() && !aluno.get().isVerificado()) {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.setStatus(403);
            response.getWriter().write("""
                    {
                        "mensagem": "Usuário não verificado"
                    }
                    """);
            return false;
        }
        return true;
    }


}
