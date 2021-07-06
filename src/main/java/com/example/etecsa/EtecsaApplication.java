package com.example.etecsa;

import com.example.etecsa.entities.Usuario;
import com.example.etecsa.services.IUsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class EtecsaApplication implements CommandLineRunner {

	@Autowired
	private IUsuarioService usuarioService;

	public static void main(String[] args) {
		SpringApplication.run(EtecsaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// usuarioService.salvar(new Usuario("admin1", "admin1", "ADMINISTRADOR",
		// true));
		// usuarioService.salvar(new Usuario("vendedor1", "vendedor1", "VENDEDOR",
		// true));
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
