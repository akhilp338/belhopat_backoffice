package com.belhopat.backoffice.service;

import javax.mail.MessagingException;

import com.belhopat.backoffice.service.session.MailMessageObject;

public interface MailService {

	void sendMail( MailMessageObject  mailObj );
	
    void sendPasswordResetMail( String userEmail, String emailBody )
        throws MessagingException;

	void sendCandidateRegMail(String userEmail, String emailBody) throws MessagingException;

}
