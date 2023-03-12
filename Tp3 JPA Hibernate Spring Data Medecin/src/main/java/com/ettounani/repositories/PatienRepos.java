package com.ettounani.repositories;

import com.ettounani.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatienRepos extends JpaRepository<Patient,Long> {
    public Page<Patient> findAllByNameContains(String name, Pageable pageable);
}
