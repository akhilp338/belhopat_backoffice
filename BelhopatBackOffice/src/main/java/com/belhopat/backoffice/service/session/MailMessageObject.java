package com.belhopat.backoffice.service.session;

import javax.activation.DataSource;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class MailMessageObject {

	private MimeMessage mimeMessage;
	
	private MimeMessageHelper helper;

	public MimeMessage getMimeMessage() {
		return mimeMessage;
	}

	public void setMimeMessage(MimeMessage mimeMessage) {
		this.mimeMessage = mimeMessage;
	}

	public MailMessageObject( String emailTo, String emailFrom, String subject, String emailBody, JavaMailSender mailSender )
			throws MessagingException {
		this.mimeMessage = mailSender.createMimeMessage();
		this.helper = new MimeMessageHelper( this.mimeMessage );
		this.helper.setTo( emailTo );
		this.helper.setFrom( new InternetAddress ( emailFrom ) );
		this.helper.setSubject( subject );
		this.helper.setText ( emailBody, true );
	}
	
	public MailMessageObject( InternetAddress[] emailToList, String emailFrom, String subject, String emailBody, JavaMailSender mailSender )
			throws MessagingException {
		this.mimeMessage = mailSender.createMimeMessage();
		this.helper = new MimeMessageHelper( this.mimeMessage );
		this.helper.setTo( emailToList );
		this.helper.setFrom( new InternetAddress ( emailFrom ) );
		this.helper.setSubject( subject );
		this.helper.setText ( emailBody, true );
	}
	
	public MailMessageObject( String emailTo, String emailFrom, String subject, String emailBody, DataSource attachment, JavaMailSender mailSender )
			throws MessagingException {
		this.mimeMessage = mailSender.createMimeMessage();
		this.helper = new MimeMessageHelper( this.mimeMessage, true );
		this.helper.setTo( emailTo );
		this.helper.setFrom( new InternetAddress ( emailFrom ) );
		this.helper.setSubject( subject );
		this.helper.setText ( emailBody, true );
		this.helper.addAttachment( "Replace with file name", attachment );
	}
	
	public MailMessageObject( InternetAddress[] emailToList, String emailFrom, String subject, String emailBody, DataSource attachment, JavaMailSender mailSender )
			throws MessagingException {
		this.mimeMessage = mailSender.createMimeMessage();
		this.helper = new MimeMessageHelper( this.mimeMessage, true );
		this.helper.setTo( emailToList );
		this.helper.setFrom( new InternetAddress( emailFrom ) );
		this.helper.setSubject( subject );
		this.helper.setText ( emailBody, true );
		this.helper.addAttachment( "Replace with file name", attachment );
	}

}
