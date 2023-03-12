package com.ettounani.repositories;

import com.ettounani.entities.Consultation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepos extends JpaRepository<Consultation,Long> {
    Page<Consultation> findAllByPatientNameContainsOrDoctorNameContains(String patient_name, String doctor_name, Pageable pageable);
}
