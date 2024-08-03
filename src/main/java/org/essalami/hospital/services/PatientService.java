package org.essalami.hospital.services;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.essalami.hospital.dao.PatientRepository;
import org.essalami.hospital.entities.Patient;
import org.essalami.hospital.specifications.PatientSpecifications;

import java.util.List;

@Service
@AllArgsConstructor
public class PatientService {

    private PatientRepository patientRepository;

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public List<Patient> filterPatientsByScoreRange(int minPrice, int maxPrice) {
        Specification<Patient> spec = PatientSpecifications.scoreBetween(minPrice, maxPrice);
        return patientRepository.findAll(spec);
    }
    public Page<Patient> getPatientByReference(String reference, int page, int size) {
        return this.patientRepository.findByLastNameContainsIgnoreCase(reference, PageRequest.of(page,size));
    }

    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    public Patient saveOrUpdatePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
}