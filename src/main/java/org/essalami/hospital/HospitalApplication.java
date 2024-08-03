package org.essalami.hospital;

import org.essalami.hospital.dao.AppointmentRepository;
import org.essalami.hospital.dao.DoctorRepository;
import org.essalami.hospital.dao.PatientRepository;
import org.essalami.hospital.entities.Appointment;
import org.essalami.hospital.entities.Doctor;
import org.essalami.hospital.entities.Patient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class HospitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalApplication.class, args);
	}

	@Bean
	public CommandLineRunner start(
			PatientRepository patientRepository,
			DoctorRepository doctorRepository,
			AppointmentRepository appointmentRepository
	){
		return args -> {

			for (int i = 0; i < 5; i++) {
				Date d= new Date();
				Patient patient1 = new Patient();
				patient1.setFirstName("John");
				patient1.setLastName("Doe");
				patient1.setDate_naissance(d);
				patient1.setScore(50);
				patientRepository.save(patient1);

				Patient patient2 = new Patient();
				patient2.setFirstName("Alice");
				patient2.setLastName("Smith");
				patient2.setDate_naissance(d);
				patient2.setScore(60);
				patientRepository.save(patient2);

				Patient patient3 = new Patient();
				patient3.setFirstName("Emily");
				patient3.setLastName("Johnson");
				patient3.setDate_naissance(d);
				patient3.setScore(90);
				patientRepository.save(patient3);
				Patient patient4 = new Patient();
				patient4.setFirstName("Emily");
				patient4.setLastName("Johnson");
				patient4.setDate_naissance(d);
				patient4.setScore(90);
				patientRepository.save(patient4);


			Doctor doctor1 = new Doctor();
			doctor1.setFirstName("Michael");
			doctor1.setLastName("Brown");
			doctor1.setEmail("Michael@gmail.com");
			doctor1.setStatu("Active");
			doctorRepository.save(doctor1);

			Doctor doctor2 = new Doctor();
			doctor2.setFirstName("Sarah");
			doctor2.setLastName("Lee");
			doctor2.setEmail("Sarah@gmail.com");
			doctor2.setStatu("Active");
			doctorRepository.save(doctor2);

			doctor1.setEmail("Sarah@gmail.com");
			doctor1.setStatu("Active");
			Doctor doctor3 = new Doctor();
			doctor3.setFirstName("David");
			doctor3.setLastName("Garcia");
			doctor3.setEmail("David@gmail.com");
			doctor3.setStatu("Active");
			doctorRepository.save(doctor3);

				Doctor doctor4 = new Doctor();
				doctor4.setFirstName("Michael");
				doctor4.setLastName("Brown");
				doctor4.setEmail("Michael@gmail.com");
				doctor4.setStatu("Active");
				doctorRepository.save(doctor4);

			// Insert sample appointments
			Appointment appointment1 = new Appointment();
			appointment1.setDoctor(doctor1);
			appointment1.setPatient(patient1);
			appointment1.setStartTime(new Date());
			appointment1.setEndTime(new Date());
			appointmentRepository.save(appointment1);

			Appointment appointment2 = new Appointment();
			appointment2.setDoctor(doctor2);
			appointment2.setPatient(patient2);
			appointment2.setStartTime(new Date());
			appointment2.setEndTime(new Date());
			appointmentRepository.save(appointment2);

			Appointment appointment3 = new Appointment();
			appointment3.setDoctor(doctor3);
			appointment3.setPatient(patient3);
			appointment3.setStartTime(new Date());
			appointment3.setEndTime(new Date());
			appointmentRepository.save(appointment3);
			}

		};
	}

}
