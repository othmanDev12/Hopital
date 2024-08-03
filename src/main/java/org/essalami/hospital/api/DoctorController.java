package org.essalami.hospital.api;

import org.essalami.hospital.entities.Doctor;
import org.essalami.hospital.exceptions.ResourceNotFoundException;
import org.essalami.hospital.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable Long id) {
        Doctor doctor = doctorService.getDoctorById(id);
        if (doctor == null) {
            throw new ResourceNotFoundException("Doctor not found with id: " + id);
        }
        return doctor;
    }

    @PostMapping
    public Doctor createDoctor(@RequestBody Doctor doctor) {
        return doctorService.saveOrUpdateDoctor(doctor);
    }

    @PutMapping("/{id}")
    public Doctor updateDoctor(@PathVariable Long id, @RequestBody Doctor doctorDetails) {
        Doctor doctor = doctorService.getDoctorById(id);
        if (doctor == null) {
            throw new ResourceNotFoundException("Doctor not found with id: " + id);
        }
        doctor.setFirstName(doctorDetails.getFirstName());
        doctor.setLastName(doctorDetails.getLastName());
        doctor.setEmail(doctorDetails.getEmail());
        doctor.setStatu(doctorDetails.getStatu());
        return doctorService.saveOrUpdateDoctor(doctor);
    }

    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable Long id) {
        Doctor doctor = doctorService.getDoctorById(id);
        if (doctor == null) {
            throw new ResourceNotFoundException("Doctor not found with id: " + id);
        }
        doctorService.deleteDoctor(id);
    }
}
