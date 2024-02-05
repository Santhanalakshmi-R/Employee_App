package com.example.Employee.Service;
import com.example.Employee.Entity.Registration;
public interface RegistrationService {
	public String register(Registration reg);
   public boolean emailExits(String email);
   public boolean validateUser(String email, String password);
}
