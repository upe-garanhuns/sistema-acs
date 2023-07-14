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
	private static final String EMAIL_USERNAME = "email@gmail.com";
	private static final String EMAIL_PASSWORD = "senha";
	
	 public static void enviarEmailRecuperacaoSenha(String email, String token) {
	        String assunto = "Recuperação de Senha";
	        String corpo = "Olá,\n\nVocê solicitou a recuperação de senha. Utilize o seguinte link para redefinir sua senha:\n\n" +
	                gerarLinkRecuperacaoSenha(token);

	        enviarEmail(email, assunto, corpo);
	    }

	    private static String gerarLinkRecuperacaoSenha(String token) {
	        return "http://example.com/recuperar-senha?token=" + token;
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