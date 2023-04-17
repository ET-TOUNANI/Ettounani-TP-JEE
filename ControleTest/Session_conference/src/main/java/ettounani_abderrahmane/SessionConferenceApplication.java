package ettounani_abderrahmane;

import ettounani_abderrahmane.DAO.entities.*;
import ettounani_abderrahmane.DAO.entities.enums.Gender;
import ettounani_abderrahmane.DAO.entities.enums.Role;
import ettounani_abderrahmane.DAO.repository.ConferenceRepository;
import ettounani_abderrahmane.DAO.repository.ParticipantRepository;
import ettounani_abderrahmane.DAO.repository.SessionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class SessionConferenceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SessionConferenceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ParticipantRepository participantRepository, SessionRepository sessionRepository, ConferenceRepository conferenceRepository){
        return  args->{
            Stream.of("Ahmed","Youssef").forEach(
                    s->{
                        Moderateur moderateur=new Moderateur();
                        moderateur.setName(s);
                        moderateur.setSpeciality("7aday");
                        moderateur.setEmail(s+"@gmail.com");
                        moderateur.setGender(Gender.MALE);
                        moderateur.setUrlImage("image.png");
                        participantRepository.save(moderateur);
                    }
            );
            Stream.of("Boutaina","Oumaima").forEach(
                    s->{
                        Speaker speaker=new Speaker();
                        speaker.setName(s);
                        speaker.setLinkProfileProf("profileProf");
                        speaker.setEmail(s+"@gmail.com");
                        speaker.setGender(Gender.FEMALE);
                        speaker.setUrlImage("image.png");
                        participantRepository.save(speaker);
                    }
            );
            Stream.of("Abderrahmane","Mestapha").forEach(
                    s->{
                        Invite invite=new Invite();
                        invite.setName(s);
                        invite.setAffiliation("Affiliation__Prof");
                        invite.setEmail(s+"@gmail.com");
                        invite.setGender(Gender.MALE);
                        invite.setUrlImage("image.png");
                        participantRepository.save(invite);
                    }
            );

            for (int i=0;i<5;i++){
                Session session= Session.builder()
                        .name("session")
                        .build();
                sessionRepository.save(session);
            }
            participantRepository.getParticipantByRole(Role.ROLE_CONFERENCIER.toString()).forEach(
                    speaker->{
                        sessionRepository.findAll().forEach(
                                s->{
                                    for (int i=0;i<5;i++){
                                        Conference conference= Conference.builder()
                                                .description("salam cv")
                                                .endHour(Time.valueOf(LocalTime.now()))
                                                .date(new Date())
                                                .speaker((Speaker) speaker)
                                                .title("salam")
                                                .session(s)
                                                .build();
                                        conferenceRepository.save(conference);
                                    }
                                }
                        );
                    }
            );




        };
    }
}
