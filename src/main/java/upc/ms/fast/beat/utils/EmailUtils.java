package upc.ms.fast.beat.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import upc.ms.fast.beat.config.FastBeatProperties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Set;

@Component
@Slf4j
public class EmailUtils {

    @Autowired
    private FastBeatProperties fastBeatProperties;

    @Async
    public void sendEmailWhitGmail(Set<String> emailTo, String subject, String htmlBody){
        Properties props = System.getProperties();
        props.put("mail.smtp.host", fastBeatProperties.getEmailSmtpConfig().getHost());
        props.put("mail.smtp.user", fastBeatProperties.getEmailSmtpConfig().getUser());
        props.put("mail.smtp.clave", fastBeatProperties.getEmailSmtpConfig().getClave());
        props.put("mail.smtp.auth", String.valueOf(fastBeatProperties.getEmailSmtpConfig().getAuth()));
        props.put("mail.smtp.starttls.enable", String.valueOf(fastBeatProperties.getEmailSmtpConfig().getStarttlsEnable()));
        props.put("mail.smtp.port", String.valueOf(fastBeatProperties.getEmailSmtpConfig().getPort()));
        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(fastBeatProperties.getEmailSmtpConfig().getUser()));
            for (String email : emailTo){
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
            }
            message.setSubject(subject);
            message.setContent(htmlBody, "text/html; charset=utf-8");

            Transport transport = session.getTransport("smtp");
            transport.connect(fastBeatProperties.getEmailSmtpConfig().getHost(),
                    fastBeatProperties.getEmailSmtpConfig().getUser(),
                    fastBeatProperties.getEmailSmtpConfig().getClave());
            log.info("***********************************");
            log.info("Sending email to:");
            emailTo.forEach(log::info);
            log.info("Body: " + htmlBody);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            log.info("Successfully sent");
        }catch (Exception e){
            e.printStackTrace();
        }
        log.info("***********************************");
    }

}
