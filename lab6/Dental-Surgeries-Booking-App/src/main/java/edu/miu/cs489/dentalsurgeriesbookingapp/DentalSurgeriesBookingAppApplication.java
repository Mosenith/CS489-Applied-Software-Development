package edu.miu.cs489.dentalsurgeriesbookingapp;

import edu.miu.cs489.dentalsurgeriesbookingapp.domain.Patient;
import edu.miu.cs489.dentalsurgeriesbookingapp.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DentalSurgeriesBookingAppApplication implements CommandLineRunner {

	@Autowired
	private PatientRepository patientRepository;

	public static void main(String[] args) {
		SpringApplication.run(DentalSurgeriesBookingAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Patient> patients = new ArrayList<>();
		Patient p1 = new Patient("P100", "Gillian", "White", "1990-05-15",
				"456-789-0123", "gillian.white@example.com", "123 Main St");
		Patient p2 = new Patient("P105", "Jill", "Bell", "1985-08-20",
				"567-890-1234", "jill.bell@example.com", "456 Elm St");
		Patient p3 = new Patient("P108", "Ian", "MacKay", "1978-03-10",
				"678-901-2345", "ian.mackay@example.com", "789 Oak St");
		Patient p4 = new Patient("P110", "John", "Walker", "1965-11-25",
				"789-012-3456", "john.walker@example.com", "987 Pine St");

		patientRepository.saveAndFlush(p1);
		patientRepository.saveAndFlush(p2);
		patientRepository.saveAndFlush(p3);
		patientRepository.saveAndFlush(p4);


		for(Patient patient : patientRepository.findAll()) {
			System.out.println(patient.toString());
		}
	}
}
