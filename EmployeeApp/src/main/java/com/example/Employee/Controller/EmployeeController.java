package com.example.Employee.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Employee.Entity.Employee;
import com.example.Employee.Service.EmployeeService;

@RestController
@RequestMapping("Employee")
@CrossOrigin()
public class EmployeeController {
	@Autowired
EmployeeService emser;

@PostMapping
public ResponseEntity<Object> create(@RequestBody Employee emp) {
	boolean userstatus=emser.emailExists(emp.getEmail());
	if(userstatus==false) {
		emser.create(emp);
		 return ResponseEntity.ok().body("{\"message\": \"User data registered successfully.\"}");
    } 
     else {
    	 return ResponseEntity.status(HttpStatus.CONFLICT).body("{\"error\": \"User data already exists for this mail id.\"}");
    }
}
@GetMapping(value="{email}")
public ResponseEntity<?> get(@PathVariable String email) {
    boolean userStatus = emser.emailExists(email);
    if (userStatus) {
        Employee emp = emser.get(email);
        return ResponseEntity.ok(emp);
    } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Email not found");
    }
}

@PutMapping(value="{email}")
	 public ResponseEntity<?> update(@PathVariable String email, @RequestBody Employee emp) {
	       Employee updatedEmployee = emser.update(emp, email);
	        if (updatedEmployee != null) {
	        	 return ResponseEntity.ok().body(updatedEmployee);
	        } 
	        else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \"Employee with email " + email + " not found.\"}");
	        }
	    }
@DeleteMapping(value="{email}")
public String delete(@PathVariable String email) {
	String msg=emser.delete(email);
	return msg;
}
}