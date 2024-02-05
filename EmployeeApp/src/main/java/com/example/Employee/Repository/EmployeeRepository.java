package com.example.Employee.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Employee.Entity.Employee;
import org.springframework.transaction.annotation.Transactional;

public interface EmployeeRepository  extends JpaRepository<Employee,Integer>{
	public Employee findByEmail(String email);
	@Transactional
	public void deleteByEmail(String email);
}