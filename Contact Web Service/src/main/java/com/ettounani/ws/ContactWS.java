package com.ettounani.ws;

import com.ettounani.ws.entities.Contact;
import com.ettounani.ws.repository.IContactRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ContactWS {

    public static void main(String[] args) {
        SpringApplication.run(ContactWS.class, args);
    }
    @Bean
    CommandLineRunner initDatabase(IContactRepo contactRepo) {

        return args -> {
            contactRepo.save(new Contact(
                    0,
                    "Abderrahmane",
                    "ETTOUNANI",
                    "tounani@gmail.com",
                    "01111111"
            ));
            contactRepo.save(new Contact(
                    0,
                    "khadija",
                    "khayer eddine",
                    "tounani4@gmail.com",
                    "04444444"
            ));
            contactRepo.save(new Contact(
                    0,
                    "youssef",
                    "ETTOUNANI",
                    "tounani3@gmail.com",
                    "03333333"
            ));
            contactRepo.save(new Contact(
                    0,
                    "oumaima",
                    "ETTOUNANI",
                    "tounani2@gmail.com",
                    "02222222"
            ));
            contactRepo.save(new Contact(
                    0,
                    "ahmed",
                    "ETTOUNANI",
                    "tounani6@gmail.com",
                    "0555555"
            ));
            contactRepo.save(new Contact(
                    0,
                    "Boutaina",
                    "Oubella",
                    "boutaina2@gmail.com",
                    "0888888"
            ));
        };
    }

}
