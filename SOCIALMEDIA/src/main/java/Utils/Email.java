package Utils;

import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


import Model.UserModel;

public class Email {

	// hàm code sinh số ngẫu nhiên
	public String getRandom() {
		Random rnd = new Random();
		int number = rnd.nextInt(999999);
		return String.format("%06d", number);
	}

	// send email to the user email

	public boolean sendEmail(UserModel user) {
		boolean test = false;
		String toGmail = user.getGmail();
		String fromGmail = "ta84578@gmail.com";
		String password = "ojja smbu arvf upqo";
		try {
			Properties pr = configEmail(new Properties());
			Session session = Session.getInstance(pr,new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication () {
					return new PasswordAuthentication (fromGmail,password);
				}
			});
			Message mess = new MimeMessage(session);
			mess.setHeader("Content-Type","text/plain; charset=UTF-8");
			mess.setFrom(new InternetAddress(fromGmail));
			mess.setRecipient(Message.RecipientType.TO, new InternetAddress(toGmail));
			mess.setSubject("Confirm code");
			mess.setText("Your is code: "+user.getCode());
			Transport.send(mess);
			test = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return test;
	}
	// send Email to the user email
	public boolean emailSend(UserModel user) {
		boolean test = false;
		String toGmail = user.getGmail();
		String fromGmail = "ta84578@gmail.com";
		String password = "ojja smbu arvf upqo";
		try {
			Properties pr = configEmail(new Properties());
			Session session = Session.getInstance(pr,new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication () {
					return new PasswordAuthentication (fromGmail,password);
				}
			});
			Message mess = new MimeMessage(session);
			mess.setHeader("Content-Type","text/plain; charset=UTF-8");
			mess.setFrom(new InternetAddress(fromGmail));
			mess.setRecipient(Message.RecipientType.TO, new InternetAddress(toGmail));
			mess.setSubject("Reset password:");
			mess.setText("Your password is: "+user.getPassword());
			Transport.send(mess);
			test = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return test;
	}
	
	public Properties configEmail(Properties pr) {
		pr.setProperty("mail.smtp.host", "smtp.gmail.com");
		pr.setProperty("mail.smtp.port", "587");
		pr.setProperty("mail.smtp.auth", "true");
		pr.setProperty("mail.smtp.starttls.enable", "true");
		pr.setProperty("mail.smtp.socketFactory.port", "587");
		pr.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		return pr;
	}

}
