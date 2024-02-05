package com.example.Employee.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import com.example.Employee.Entity.Registration;
import com.example.Employee.Service.RegistrationService;
@RestController
@RequestMapping("Register")
@CrossOrigin
public class RegistrationController {
	@Autowired
	RegistrationService rser;
	@PostMapping("post")
	public ResponseEntity<Object> register(@RequestBody Registration reg) {
		boolean userstatus=rser.emailExits(reg.getEmail());
		if(userstatus==false) {
			rser.register(reg);
			 return ResponseEntity.ok().body("{\"message\": \"User data registered successfully.\"}");
        } 
         else {
        	 return ResponseEntity.status(HttpStatus.CONFLICT).body("{\"error\": \"User data already exists.\"}");
        }
	}
	@PostMapping("login")
	public String valudateUser(@ModelAttribute Registration reg)
	{
		 if (reg == null || reg.getEmail() == null) {
		        return "loginfail";
		    }
		
		   String email=reg.getEmail();
		
			String password=reg.getPassword();
		boolean loginsts=rser.validateUser(email, password);
		if(loginsts==true) {
			return "You logged in successfully.";}
	
		else {
			return "email id of password is incorrect";
		}
	}
	
	  }


