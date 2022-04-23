package upc.ms.fast.beat;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAdminServer
public class UpcMsFastBeatApplication {

	public static void main(String[] args) {
		SpringApplication.run(UpcMsFastBeatApplication.class, args);
	}

}
