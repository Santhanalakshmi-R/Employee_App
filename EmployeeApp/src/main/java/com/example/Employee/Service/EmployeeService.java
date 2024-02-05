package com.example.Employee.Service;
import com.example.Employee.Entity.Employee;
public interface EmployeeService {
public String create(Employee emp);
public boolean emailExists(String email);
public Employee get(String email);
public Employee update(Employee emp,String email);
public String delete(String email);
}
