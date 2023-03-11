package com.ettounani.repositories;

import com.ettounani.entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepos extends JpaRepository<Consultation,Long> {
}
