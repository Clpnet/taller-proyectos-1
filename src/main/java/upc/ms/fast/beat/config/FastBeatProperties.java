package upc.ms.fast.beat.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@ConfigurationProperties(prefix = "fast-beat")
@PropertySource(value = "classpath:fast-beat.yml", factory = YamlPropertySourceFactory.class)
@Component
public class FastBeatProperties {

    private EmailSmtpConfig emailSmtpConfig;
    private TwilioConfig twilioConfig;

    @Data
    public static class EmailSmtpConfig {
        private String host;
        private String user;
        private String clave;
        private Boolean auth;
        private Boolean starttlsEnable;
        private Integer port;
    }

    @Data
    public static class TwilioConfig{
        private String sid;
        private String token;
        private String numberFrom;
    }
}