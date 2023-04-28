package sia.tacocloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//*This is a composite annotation which contains the following 3 annotations:
//* @SpringBootConfiguration
//* @EnableAutoConfiguration
//* @ComponentScan
@SpringBootApplication
public class TacoCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(TacoCloudApplication.class, args);
	}

}
