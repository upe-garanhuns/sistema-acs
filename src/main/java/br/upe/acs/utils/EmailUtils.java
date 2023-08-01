package br.upe.acs.utils;

import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.*;

public class EmailUtils {

	private static final String EMAIL_HOST = "smtp.gmail.com";
	private static final String EMAIL_PORT = "587";
	private static final String EMAIL_USERNAME = "emailexemplo123@gmail.com";
	private static final String EMAIL_PASSWORD = "senha123";

	public static void enviarEmailRecuperacaoSenha(String email, String token) {
		String assunto = "Recuperação de Senha";
		String corpo = "<html><body>" +
				"<h1>Redefinir Senha</h1>" +
				"<p>Olá,</p>" +
				"<p>Você solicitou a recuperação de senha. Utilize o formulário abaixo para redefinir sua senha:</p>" +
				"<form method=\"POST\" action=\"http://localhost:8080/api/usuario/recuperar-senha\">" +
				"<input type=\"hidden\" name=\"token\" value=\"" + token + "\">" +
				"<label for=\"novaSenha\">Nova Senha:</label>" +
				"<input type=\"password\" name=\"novaSenha\" id=\"novaSenha\" minlength=\"8\" maxlength=\"16\" required><br>" +
				"<label for=\"confirmarNovaSenha\">Confirmar Nova Senha:</label>" +
				"<input type=\"password\" name=\"confirmarNovaSenha\" id=\"confirmarNovaSenha\" minlength=\"8\" maxlength=\"16\" required><br>" +
				"<input type=\"submit\" value=\"Redefinir Senha\">" +
				"</form>" +
				"<p>Atenção: o link expirará em 5 minutos.</p>" +
				"</body></html>";

		enviarEmail(email, assunto, corpo);
	}

	private static void enviarEmail(String emailDestinatario, String assunto, String corpo) {
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", EMAIL_HOST);
		props.put("mail.smtp.port", EMAIL_PORT);

		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(EMAIL_USERNAME, EMAIL_PASSWORD);
			}
		});

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(EMAIL_USERNAME));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailDestinatario));
			message.setSubject(assunto);
			message.setText(corpo);

			Transport.send(message);

			System.out.println("Email enviado com sucesso!");
		} catch (MessagingException e) {
			System.out.println("Erro ao enviar o email: " + e.getMessage());
		}
	}
}