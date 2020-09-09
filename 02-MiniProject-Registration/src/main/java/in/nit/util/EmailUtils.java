package in.nit.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import in.nit.dto.User;

@Component
public class EmailUtils {
	
	@Autowired
	private JavaMailSender mailSender;
	
	public boolean UserUnlockAccount01(User user) {
		boolean isSent=false;
		try {
			SimpleMailMessage msg=new SimpleMailMessage();
			msg.setTo(user.getUserEmail());
			msg.setSubject("Registration Email");
			msg.setText(getUnlockAccountEmailBody(user));
			mailSender.send(msg);
			isSent=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSent;	
	}
	
	
	public boolean sendUserAccUnlockEmail(User user) {
		boolean isSent=false;
		try {
			MimeMessage mimMsg=mailSender.createMimeMessage();
			MimeMessageHelper helper=new MimeMessageHelper(mimMsg);
			helper.setTo(user.getUserEmail());
			helper.setSubject("Unlock Your Account");
			helper.setText(getUnlockAccountEmailBody(user),true);
			mailSender.send(mimMsg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSent;
	}
	
	
	
	
	private String getUnlockAccountEmailBody(User user)throws IOException{
		StringBuffer sb=new StringBuffer();
		FileReader fr=new FileReader("UNLOCK-ACC-EMAIL-BODY-TEMPLATE.txt");
		BufferedReader  br=new BufferedReader(fr);
		String line=br.readLine();
		
		while(line !=null) {
			sb.append(line);
			line=br.readLine();
		}
		br.close();
		
		/*format mail body*/
		
		String mailBody=sb.toString();
		mailBody=mailBody.replace("{FNAME}", user.getFirstName());
		mailBody=mailBody.replace("{LNAME}",user.getLastName());
		mailBody=mailBody.replace("{TEMP_PWD}",user.getUserPwd());
		mailBody=mailBody.replace("{EMAIL}",user.getUserEmail());
		return mailBody;
		
	}

}
