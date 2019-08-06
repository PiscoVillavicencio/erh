package pe.gob.minsa.erh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import pe.gob.minsa.erh.model.dto.UserDto;

@SpringBootApplication
public class ErhApplication {

	public static void main(String[] args) {
		SpringApplication.run(ErhApplication.class, args);
	}

	@Bean
	public UserDto globalUser() {
		return UserDto.builder().build();
	}

}
