package ettounani_abderrahmane;

import ettounani_abderrahmane.DAO.entities.Abonnement;
import ettounani_abderrahmane.DAO.entities.Client;
import ettounani_abderrahmane.DAO.entities.Type;
import ettounani_abderrahmane.DAO.repository.AbonnementRepository;
import ettounani_abderrahmane.DAO.repository.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;
import java.util.Random;
import java.util.random.RandomGenerator;
import java.util.stream.Stream;

@SpringBootApplication
public class ControleAbonnementApplication {

    public static void main(String[] args) {
        SpringApplication.run(ControleAbonnementApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(AbonnementRepository abonnementRepository, ClientRepository clientRepository) {
        return args -> {
            Stream.of("Ahmed", "Youssef","Abderrahmane","Youssef","Boutaina","Amin","Samir","Karima","Khadija","Fatima","Said","ELfasi","Ettounani","Mehdi","Oumaima","Hassna","Saida").forEach(
                    s -> {
                        Client client = Client.builder()
                                .name(s)
                                .email(s + "@gmail.com")
                                .username(s)
                                .build();
                        clientRepository.save(client);
                    }
            );
            clientRepository.findAll().forEach(
                    client -> {
                        for (int i = 0; i < 2; i++) {
                            Abonnement abonnement = Abonnement.builder()
                                    .solde(1020.9* Math.random()+100)
                                    .client(client)
                                    .date(new Date())
                                    .montantMensuel(10220.9*Math.random()+23)
                                    .type(Math.random() > 0.5 ? Type.GSM : Type.TELEPHONE_FIXE)
                                    .build();
                            abonnementRepository.save(abonnement);
                        }
                    }
            );


        };
    }
}
