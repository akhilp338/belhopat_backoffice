package com.belhopat.backoffice.service;

import javax.mail.MessagingException;

import com.belhopat.backoffice.service.session.MailSessionObject;

public interface MailService {

	void sendMail ( MailSessionObject mailSessionObject ) throws MessagingException;
	
    void sendPasswordResetMail( String userEmail, String emailBody )
        throws MessagingException;
}
