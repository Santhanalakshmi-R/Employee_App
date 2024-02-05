package com.example.Employee.Service;
import org.springframework.stereotype.Service;

import com.example.Employee.Entity.Employee;
import com.example.Employee.Repository.EmployeeRepository;

@Service
public class EmployeeServiceImplementation implements EmployeeService{
EmployeeRepository emrep;

public EmployeeServiceImplementation(EmployeeRepository emrep) {
	super();
	this.emrep = emrep;
}
@Override
public String create(Employee emp) {
	emrep.save(emp);
	return "Employe details are  stored";
}
@Override
public Employee get(String email) {
	Employee emp=emrep.findByEmail(email);
	return emp;
}
@Override
public Employee update(Employee emp,String email) {
	Employee existingEmployee = emrep.findByEmail(email);
    if (existingEmployee != null) {
        existingEmployee.setName(emp.getName());
        existingEmployee.setEmail(emp.getEmail());
        existingEmployee.setPhoneNo(emp.getPhone_No());
        existingEmployee.setdob(emp.getdob());
        existingEmployee.setGender(emp.getGender());
        existingEmployee.setAge(emp.getAge());
        existingEmployee.setPosition(emp.getPosition());
        existingEmployee.setExperience(emp.getExperience());
        existingEmployee.setAddress(emp.getAddress());
        
        return emrep.save(existingEmployee);
    } else {
        return null;
    }
}

@Override
public String delete(String email) {
	emrep.deleteByEmail(email);
	return "Employee details are deleted";
}

@Override
public boolean emailExists(String email) {
	if(emrep.findByEmail(email)==null) {
		return false;
	}
	else {
		return true;
	}
}
}
