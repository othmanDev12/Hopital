package org.essalami.hospital.dao;

import org.essalami.hospital.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Long> , JpaSpecificationExecutor<Patient> {
    Page<Patient> findByLastNameContainsIgnoreCase(String name, Pageable pageable);
    List<Patient> findByScoreBetween( int minScore,  int maxScore);
}
