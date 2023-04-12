package com.ettounani.micro_service;

import com.ettounani.micro_service.entities.Compte;
import com.ettounani.micro_service.enums.TypeCompte;
import com.ettounani.micro_service.repository.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class SpringMicroServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMicroServiceApplication.class, args);

    }

    @Bean
    CommandLineRunner start(CompteRepository compteRepository) {
        return args -> {
            for (int i = 0; i < 10; i++) {
                Compte compte = Compte.builder()
                        .id(UUID.randomUUID().toString())
                        .type(Math.random() > 0.5 ? TypeCompte.CURRENT_ACCOUNT : TypeCompte.SAVING_ACCOUNT)
                        .balance(1000 + Math.random() * 20000)
                        .createDate(new Date())
                        .currency("MAD")
                        .build();
                compteRepository.save(compte);
            }
        };
    }

}
