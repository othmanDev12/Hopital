package org.essalami.hospital.api;

import lombok.AllArgsConstructor;
import org.essalami.hospital.entities.Patient;
import org.essalami.hospital.exceptions.ResourceNotFoundException;
import org.essalami.hospital.services.PatientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
@AllArgsConstructor
public class PatientController {

     PatientService patientService;

    @GetMapping
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable Long id) {
        Patient patient = patientService.getPatientById(id);
        if (patient == null) {
            throw new ResourceNotFoundException("Patient not found with id: " + id);
        }
        return patient;
    }
    @GetMapping("/filter")
    public List<Patient> filterProducts(@RequestParam(name = "min",defaultValue = "0") int minPrice, @RequestParam(name = "max",defaultValue = "0") int maxPrice) {
        return patientService.filterPatientsByScoreRange(minPrice, maxPrice);
    }
    @PostMapping
    public Patient createPatient(@RequestBody Patient patient) {
        return patientService.saveOrUpdatePatient(patient);
    }

    @PutMapping("/{id}")
    public Patient updatePatient(@PathVariable Long id, @RequestBody Patient patientDetails) {
        Patient patient = patientService.getPatientById(id);
        if (patient == null) {
            throw new ResourceNotFoundException("Patient not found with id: " + id);
        }
        patient.setFirstName(patientDetails.getFirstName());
        patient.setLastName(patientDetails.getLastName());
        patient.setScore(patientDetails.getScore());
        patient.setDate_naissance(patientDetails.getDate_naissance());
        return patientService.saveOrUpdatePatient(patient);
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable Long id) {
        Patient patient = patientService.getPatientById(id);
        if (patient == null) {
            throw new ResourceNotFoundException("Patient not found with id: " + id);
        }
        patientService.deletePatient(id);
    }
}
