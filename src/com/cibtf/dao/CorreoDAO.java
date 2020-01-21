package com.cibtf.dao;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class CorreoDAO {
	private String destinatarioSppt = "bolsaempleo.ad@gmail.com";
	
	public CorreoDAO() {
		
	}
	
	public String enviarCorreoDAOSppt(String asunto, String mensaje) {
		
		Properties props = new Properties();
		props.setProperty("mail.smtp.host", "smtp.gmail.com");
		props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.port", "587");
        props.setProperty("mail.smtp.auth", "true");
        
        Session session = Session.getDefaultInstance(props);
        
        String correoEnvia = "bolsaempleo.sppt@gmail.com";
        String contrasena = "administrador";
        
        MimeMessage mail = new MimeMessage(session);
        
        try {
            mail.setFrom(new InternetAddress (correoEnvia));
            mail.addRecipient(Message.RecipientType.TO, new InternetAddress (destinatarioSppt));
            mail.setSubject(asunto);
            mail.setText(mensaje);
            
            Transport transportar = session.getTransport("smtp");
            transportar.connect(correoEnvia,contrasena);
            transportar.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));          
            transportar.close();
            
            
            
        } catch (AddressException ex) {
            
        } catch (MessagingException ex) {
            
        }
       
        return "done";
		
	}
	
	public void enviarCorreoDAO(String asunto, String mensaje, String destinatario) {
		
		Properties props = new Properties();
		props.setProperty("mail.smtp.host", "smtp.gmail.com");
		props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.port", "587");
        props.setProperty("mail.smtp.auth", "true");
        
        Session session = Session.getDefaultInstance(props);
        
        String correoEnvia = "bolsaempleo.sppt@gmail.com";
        String contrasena = "administrador";
        
        MimeMessage mail = new MimeMessage(session);
        
        try {
            mail.setFrom(new InternetAddress (correoEnvia));
            mail.addRecipient(Message.RecipientType.TO, new InternetAddress (destinatario));
            mail.setSubject(asunto);
            mail.setText(mensaje);
            
            Transport transportar = session.getTransport("smtp");
            transportar.connect(correoEnvia,contrasena);
            transportar.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));          
            transportar.close();
            
            
            
        } catch (AddressException ex) {
            
        } catch (MessagingException ex) {
            
        }
		
	}

}
