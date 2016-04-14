package com.belhopat.backoffice.service.session;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSessionObject {
    
  private Session mailSession;
private MimeMessage mailMessage;
  private MimeMessage mimeMessage;
  
  public Session getMailSession() {
      return mailSession;
  }
  
  public void setMailSession( Session mailSession ) {
      this.mailSession = mailSession;
  }
  
  public MimeMessage getMimeMessage() {
      return mimeMessage;
  }
  
  public void setMimeMessage( MimeMessage mimeMessage ) {
      this.mimeMessage = mimeMessage;
  }

    public Properties getEmailProperties() {
        Properties mailServerProperties = System.getProperties();
        mailServerProperties.put( "mail.smtp.port", "25" );
        mailServerProperties.put( "mail.smtp.auth", "true" );
        mailServerProperties.put( "mail.smtp.starttls.enable", "true" );
        return mailServerProperties;
    }

    public MimeMessage getMailMessage() {
        return mailMessage;
    }

    public void setMailMessage( MimeMessage mailMessage ) {
        this.mailMessage = mailMessage;
    }

    
    public MailSessionObject ( String emailTo, String emailFrom, String subject, String emailBody )
        throws MessagingException {
        Properties mailServerProperties = getEmailProperties();
        this.mailSession = Session.getDefaultInstance( mailServerProperties, null );
        this.mailMessage = new MimeMessage( mailSession );
        this.mailMessage.setRecipients( Message.RecipientType.TO, emailTo );
        this.mailMessage.setFrom( new InternetAddress ( emailFrom ) );
        this.mailMessage.setSubject( subject );
        this.mailMessage.setContent( emailBody, "text/html" );
    }
    
//    public MailSessionObject ( String emailTo, String emailCc, String emailFrom, String subject, String emailBody )
//        throws MessagingException {
//        Properties mailServerProperties = getEmailProperties();
//        this.mailSession = Session.getDefaultInstance( mailServerProperties, null );
//        this.mailMessage = new MimeMessage( mailSession );
//        this.mailMessage.setRecipients( Message.RecipientType.TO, emailTo );
//        this.mailMessage.setRecipients( Message.RecipientType.CC, emailCc );
//        this.mailMessage.setFrom( new InternetAddress ( emailFrom ) );
//        this.mailMessage.setSubject( subject );
//        this.mailMessage.setContent( emailBody, "text/html" );
//    }
//    
    public MailSessionObject ( InternetAddress[] emailToList, String emailFrom, String subject, String emailBody )
        throws MessagingException {
        Properties mailServerProperties = getEmailProperties();
        this.mailSession = Session.getDefaultInstance( mailServerProperties, null );
        this.mailMessage = new MimeMessage( mailSession );
        this.mailMessage.setRecipients( Message.RecipientType.TO, emailToList );
        this.mailMessage.setFrom( new InternetAddress ( emailFrom ) );
        this.mailMessage.setSubject( subject );
        this.mailMessage.setContent( emailBody, "text/html" );
    }
    
}
