package com.ettounani.repositories;

import com.ettounani.entities.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepos extends JpaRepository<Doctor,Long> {
    public Page<Doctor> findAllByNameContains(String name, Pageable pageable);
}
