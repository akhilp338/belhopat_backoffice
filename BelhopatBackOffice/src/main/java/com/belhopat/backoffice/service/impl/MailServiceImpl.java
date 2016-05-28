
package com.belhopat.backoffice.service.impl;

import java.util.List;

import javax.mail.MessagingException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import com.belhopat.backoffice.service.MailService;
import com.belhopat.backoffice.service.session.MailMessageObject;
import com.belhopat.backoffice.util.Constants;

/**
 * @author Sreekesh Service for sending and syncing mails
 */
@Async
@Service("mailService")
@PropertySource("classpath:email.properties")
public class MailServiceImpl implements MailService {

	@Value("#{emailConfiguration['mail.smtp.username']}")
	private String MAIL_FROM;

	@Autowired
	JavaMailSender mailSender;

	@Autowired
	ThreadPoolTaskExecutor threadExecutor;

	protected static final Logger LOGGER = Logger.getLogger(MailServiceImpl.class.getName());

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.belhopat.backoffice.service.MailService#sendMail(com.belhopat.
	 * backoffice.service.session.MailMessageObject)
	 * sends mail in a thread
	 */
	@Async
	@Override
	public void sendMail(MailMessageObject mailObj) {

		Runnable runnableWorker = new Runnable() {
			@Override
			public void run() {
				try {
					mailSender.send(mailObj.getMimeMessage());
				} catch (Exception e) {
					LOGGER.error("Exception " + e);
				}
			}
		};
		threadExecutor.execute(runnableWorker);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.belhopat.backoffice.service.MailService#sendPasswordResetMail(java.
	 * lang.String, java.lang.String)
	 * sends reseted password
	 */
	@Override
	public void sendPasswordResetMail(String userEmail, String emailBody) throws MessagingException {

		String emailHtmlBody = "<html>" + "<head></head>" + "<body>" + "<div><p><strong>" + "Belhopat Admin"
				+ "</strong></p><p></p></div>" + "<div> " + emailBody + " </div>" + "</body></html>";
		MailMessageObject mailObject = new MailMessageObject(userEmail, MAIL_FROM, Constants.PASS_RESET_MAIL_SUB,
				emailHtmlBody, mailSender);
		sendMail(mailObject);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.belhopat.backoffice.service.MailService#sendCandidateRegMail(java.
	 * lang.String, java.lang.String)
	 * sends mail on canidate registration success
	 */
	@Override
	public void sendCandidateRegMail(String userEmail, String emailBody) throws MessagingException {

		String emailHtmlBody = "<html>" + "<head></head>" + "<body>" + "<div><p><strong>" + "Belhopat Admin"
				+ "</strong></p><p></p></div>" + "<div> " + emailBody + " </div>" + "</body></html>";
		MailMessageObject mailObject = new MailMessageObject(userEmail, MAIL_FROM, Constants.CAND_REG_SUCC_MAIL_SUB,
				emailHtmlBody, mailSender);
		sendMail(mailObject);

	}

	@Override
	public void sendEventInvitaionMail(List<String> guestEmails, String emailBody) throws MessagingException {
		// TODO Auto-generated method stub
		
	}

}