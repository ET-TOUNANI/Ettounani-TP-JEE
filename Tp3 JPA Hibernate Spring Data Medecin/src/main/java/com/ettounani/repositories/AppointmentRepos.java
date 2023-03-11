package com.ettounani.repositories;

import com.ettounani.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepos extends JpaRepository<Appointment,Long> {
}
