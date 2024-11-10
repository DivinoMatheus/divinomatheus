package br.edu.infnet.divinomatheus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DivinoMatheusApplication {

	public static void main(String[] args) {
		SpringApplication.run(DivinoMatheusApplication.class, args);
	}

}
