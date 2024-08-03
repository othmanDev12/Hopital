package org.essalami.hospital.dao;

import org.essalami.hospital.entities.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
    Page<Doctor> findByLastNameContainsIgnoreCase(String name, Pageable pageable);
}
