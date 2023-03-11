package com.ettounani.repositories;

import com.ettounani.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepos extends JpaRepository<Doctor,Long> {
}
