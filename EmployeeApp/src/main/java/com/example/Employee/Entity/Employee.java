package com.example.Employee.Entity;
import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
@Entity
public class Employee {
String name;
@Id 
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emp_Id")
@SequenceGenerator(name = "emp_Id", sequenceName = "emp_Id", allocationSize = 1)
long emp_Id;
String email;
Date dob;
String phoneNo;
String gender;
int age;
String position;
int experience;
String address;
public Employee() {
	super();
	// TODO Auto-generated constructor stub
}
public Employee(int emp_Id, String name, Date dob,String email, String gender, int age, String phoneNo, String position,
		int experience, String address) {
	super();
	this.emp_Id = emp_Id;
	this.name = name;
	this.dob=dob;
	this.email = email;
	this.gender = gender;
	this.age = age;
	this.phoneNo = phoneNo;
	this.position = position;
	this.experience = experience;
	this.address = address;
}
public long getEmp_Id() {
	return emp_Id;
}
public void setEmp_Id(long emp_Id) {
	this.emp_Id = emp_Id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Date getdob() {
	return dob;
}
public void setdob(Date dob) {
	this.dob= dob;
}

public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getPhone_No() {
	return phoneNo;
}
public void setPhoneNo(String phoneNo) {
	this.phoneNo = phoneNo;
}
public String getPosition() {
	return position;
}
public void setPosition(String position) {
	this.position = position;
}
public int getExperience() {
	return experience;
}
public void setExperience(int experience) {
	this.experience = experience;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
@Override
public String toString() {
	return "Employee [emp_Id=" + emp_Id + ", name=" + name + ",dob="+dob+", mail_id=" + email + ", gender=" + gender + ", age="
			+ age + ", phone_No=" + phoneNo + ", position=" + position + ", experience=" + experience + ", address="
			+ address + "]";
}


}
