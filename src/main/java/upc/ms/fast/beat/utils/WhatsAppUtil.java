package upc.ms.fast.beat.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import upc.ms.fast.beat.config.FastBeatProperties;

@Component
public class WhatsAppUtil {

    @Autowired
    private FastBeatProperties fastBeatProperties;

    public void sendWhatsApp(String numberTo, String body){
        Twilio.init(fastBeatProperties.getTwilioConfig().getSid(),
                fastBeatProperties.getTwilioConfig().getToken());
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("whatsapp:" + numberTo),
                new com.twilio.type.PhoneNumber("whatsapp:" + fastBeatProperties.getTwilioConfig().getNumberFrom()),
                body)
                .create();

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        try {
            System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(message));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
