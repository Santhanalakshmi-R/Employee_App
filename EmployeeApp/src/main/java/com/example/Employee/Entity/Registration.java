package com.example.Employee.Entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Registration {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reg_Id")
	@SequenceGenerator(name = "reg_Id", sequenceName = "reg_Id", allocationSize = 1)
	long reg_Id;
    String name;
    String email;
    String password;
	public Registration() {
		
	}
    public Registration(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email= email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Registration [name=" + name + ", mail_Id=" + email + ", password=" + password + "]";
	}
}
