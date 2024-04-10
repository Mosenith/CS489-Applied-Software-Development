package edu.miu.cs489.dentalsurgeriesbookingapp.repository;

import edu.miu.cs489.dentalsurgeriesbookingapp.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,String> {
}
