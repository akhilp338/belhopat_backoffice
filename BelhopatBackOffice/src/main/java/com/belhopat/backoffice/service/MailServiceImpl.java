
package com.belhopat.backoffice.service;

import javax.mail.MessagingException;
import javax.mail.Transport;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import com.belhopat.backoffice.service.session.MailSessionObject;

@Async
@Service( "mailService" )
@PropertySource("classpath:email.properties")
public class MailServiceImpl implements MailService {
	
	@Value( "${smtp.user}" )
	private String MAIL_FROM;
	
	@Value( "${smtp.password}" )
	private String MAIL_PASSWORD;

    @Autowired
    ThreadPoolTaskExecutor threadExecutor;

    protected static final Logger LOGGER = Logger.getLogger( MailServiceImpl.class.getName() );
    
    @Async
    @Override
    public void sendMail( MailSessionObject mailSessionObject )
        throws MessagingException {

        Runnable runnableWorker = new Runnable() {
            @Override
            public void run() {
                try {
                    Transport transport;
                    transport = mailSessionObject.getMailSession().getTransport( "smtp" );
                    transport.connect( "smtp.gmail.com", MAIL_FROM,
                        MAIL_PASSWORD );
                    transport.sendMessage( mailSessionObject.getMailMessage(),
                        mailSessionObject.getMailMessage().getAllRecipients() );
                    transport.close();
                }
                catch ( MessagingException e ) {
                    LOGGER.error( "Messaging Exception" + e );
                }
            }
        };
        threadExecutor.execute( runnableWorker );
    }

	@Override
	public void sendPasswordResetMail( String userEmail, String emailBody ) throws MessagingException {
		
		MailSessionObject mailSessionObject =
                new MailSessionObject( userEmail, MAIL_FROM, "Password Reset Mail", emailBody );
		sendMail( mailSessionObject );
		
	}
}