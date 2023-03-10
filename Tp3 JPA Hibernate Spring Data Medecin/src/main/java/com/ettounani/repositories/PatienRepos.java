package com.ettounani.repositories;

import com.ettounani.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatienRepos extends JpaRepository<Patient,Long> {

}
