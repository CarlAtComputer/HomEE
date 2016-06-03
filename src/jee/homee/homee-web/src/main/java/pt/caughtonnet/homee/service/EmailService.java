/**
 * 
 */
package pt.caughtonnet.homee.service;

import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import pt.caughtonnet.homee.entity.User;

@Local
@Stateless(name = "emailService")
public class EmailService {

	@Resource(mappedName = "java:/mail/homee")
	private Session emailSession;

	public boolean sendConfirmationEmail(User userToRegister, String protocol, String appUrl) {
		try {
			Message message = new MimeMessage(emailSession);
			message.setFrom(new InternetAddress("registray@damon.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(userToRegister.getEmail()));
			message.setSubject("Confirm you email");
			String content = "Confirm you email <a href=\""+ protocol + "://" + appUrl +"/faces/front/confirmed.xhtml?ch="+userToRegister.getConfirmationHash()+"\">here</a>";
			message.setText(content);
			Transport.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
