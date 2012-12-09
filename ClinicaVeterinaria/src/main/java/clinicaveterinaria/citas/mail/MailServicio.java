package clinicaveterinaria.citas.mail;

import java.io.File;

public interface MailServicio {

	public void send(String to, String subject, String text);  
    
    public void send(String to, String subject, String text, File... attachments);
	
}
