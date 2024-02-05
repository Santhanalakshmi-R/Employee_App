package com.example.Employee.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Employee.Entity.Registration;
import com.example.Employee.Repository.RegistrationRepository;
@Service
public class RegistrationServiceImplementation  implements RegistrationService{
	@Autowired
RegistrationRepository rrep;
	@Override
	public String register(Registration reg) {
		rrep.save(reg);
		return "Registration data stored successfully";
	}
	@Override
	public boolean emailExits(String email) {
		if(rrep.findByEmail(email)==null) {
			return false;
		}
		else {
			return true;
		}
	}
	@Override
	public boolean validateUser(String email, String password) {
	
		Registration reg_email=rrep.findByEmail(email);
		if(reg_email==null) {
			return false;
		}
		else {
		String db_Password=reg_email.getPassword();
		if(db_Password.equals(password)) {
		return true;
	}
		else {
			return false;
		}
	}
	}
}
