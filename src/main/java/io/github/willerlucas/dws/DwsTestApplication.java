package io.github.willerlucas.dws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DwsTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(DwsTestApplication.class, args);
	}

}
