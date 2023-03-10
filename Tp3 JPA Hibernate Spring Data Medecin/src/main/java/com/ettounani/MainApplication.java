package com.ettounani;

import com.ettounani.entities.Patient;
import com.ettounani.repositories.PatienRepos;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(PatienRepos patienRepos){
        return args -> {
            patienRepos.save(new Patient(0,"abderrahmane",new Date(),"0690071837",true));
            patienRepos.save(new Patient(0,"Khadija",new Date(),"06277272",false));
            patienRepos.save(new Patient(0,"Oumaima",new Date(),"0682923",true));
            patienRepos.save(new Patient(0,"Youssef",new Date(),"09287373",true));
            patienRepos.save(new Patient(0,"Ahmed",new Date(),"0982938",false));
            patienRepos.save(new Patient(0,"Boutaina",new Date(),"09387823",false));

            patienRepos.findAll().forEach(p-> System.out.println(p.getName()));
        };
    }

}
