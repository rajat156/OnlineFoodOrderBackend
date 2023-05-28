package com.example.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.example.Entity.ClientEmail;
import com.example.dao.ClientEmailRepo;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class ClientEmailService {

	@Autowired
	private ClientEmailRepo clientEmailRepo;
	
//	@Autowired
//	private  JavaMailSender javaMailSender;

	public ClientEmail setEmail(ClientEmail clientEmail) {
//		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
//		MimeMessageHelper  helper = new MimeMessageHelper(mimeMessage,true);
//			helper.setTo("rajattyagi156@gmail.com");
//			helper.setSubject("Demo");
//			helper.setText("Test Success");
//			
//			javaMailSender.send(mimeMessage);
			
		return this.clientEmailRepo.saveAndFlush(clientEmail);
	}
}
