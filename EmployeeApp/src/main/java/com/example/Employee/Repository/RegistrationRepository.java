package com.example.Employee.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Employee.Entity.Registration;
public interface RegistrationRepository extends JpaRepository<Registration,Integer> {
	public Registration findByEmail(String email);
}