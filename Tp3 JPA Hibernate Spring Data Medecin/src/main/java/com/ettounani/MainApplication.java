package com.ettounani;

import com.ettounani.entities.Appointment;
import com.ettounani.entities.Consultation;
import com.ettounani.entities.Doctor;
import com.ettounani.entities.Patient;
import com.ettounani.repositories.AppointmentRepos;
import com.ettounani.repositories.ConsultationRepos;
import com.ettounani.repositories.DoctorRepos;
import com.ettounani.repositories.PatienRepos;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Time;
import java.util.Date;

@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(PatienRepos patienRepos, DoctorRepos doctorRepos, ConsultationRepos consultationRepos, AppointmentRepos appointmentRepos){
        return args -> {
            Patient p1=new Patient(0,"abderrahmane",new Date(),"0690071837",true,12);
            patienRepos.save(p1);
            patienRepos.save(new Patient(0,"Khadija",new Date(),"06277272",false,20));
            patienRepos.save(new Patient(0,"Oumaima",new Date(),"0682923",true,22));
            Doctor d1=new Doctor(0,"Youssef","Cardiologie","09287373",new Date(),true);
            doctorRepos.save(d1);
            doctorRepos.save(new Doctor(0,"Ahmed","General","0982938",new Date(),false));
            Consultation c1=new Consultation(0,new Date(),new Time(21,20,2),new Time(22,30,0),p1,d1,"darebo lbared");
            consultationRepos.save(c1);
            consultationRepos.save(new Consultation(0,new Date(),new Time(11,20,2),new Time(12,30,0),p1,d1,"mhares"));
            appointmentRepos.save(new Appointment(0,new Date(),new Time(21,20,2),new Time(22,30,0),c1));

            patienRepos.findAll().forEach(p-> System.out.println(p.getName()));
        };
    }

}
