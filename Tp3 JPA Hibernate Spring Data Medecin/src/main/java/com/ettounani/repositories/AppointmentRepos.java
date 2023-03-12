package com.ettounani.repositories;

import com.ettounani.entities.Appointment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AppointmentRepos extends JpaRepository<Appointment,Long> {
    Page<Appointment> findAllByConsultation_PatientName(String name, Pageable pageable);

}
