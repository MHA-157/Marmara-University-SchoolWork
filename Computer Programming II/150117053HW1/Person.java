//Muhammet Hasan Albayrak 150117053

import java.util.*;
public class Person {
	//Class file for person
private int id;
private String firstName;
private String lastName;
private byte gender;
private java.util.Calendar birthDate;
private byte maritalStatus;
private boolean hasDriverLicense;

 //Constructor
   public Person(int id, String firstName, String lastName, String gender, Calendar birthDate, String maritalStatus, String hasDriverLicense) throws Exception {
	   this.setId(id);
	   this.setFirstName(firstName);
	   this.setLastName(lastName);
	  
	   this.setGender(gender);
	   this.birthDate = birthDate;
	   this.setMaritalStatus(maritalStatus);
	   this.setHasDriverLicense(hasDriverLicense);
	   
   
   }

public int getId() {
	
	return id;
	
}


public void setId(int id) throws Exception {
	if(id > 0)
	this.id = id;
	else
		throw new Exception("Invalid enter a positive value ");
}


public String getFirstName() {
	
	return firstName;
}


public void setFirstName(String firstName) throws Exception {
	if(!(firstName.length() < 3))
	this.firstName = firstName;
	else
		throw new Exception("At least 3 characters");
}


public String getLastName() {
	return lastName;
}


public void setLastName(String lastName) throws Exception {
	if(lastName.length() >= 3)
	this.lastName = lastName;
	else 
		throw new Exception("At least 3 characteres");
}


public String getGender() {
	if(this.gender == 1)
		return "Man";
	return "Woman";
}


public void setGender(String gender) {
	if(gender.equals("Man"))
		this.gender = 1;
	else
	this.gender = 2;
}


public java.util.Calendar getBirthDate() {
	return birthDate;
}


public void setBirthDate(java.util.Calendar birthDate) {
	this.birthDate = birthDate;
}


public String getMaritalStatus() {
	if(this.maritalStatus == 1)
		return "Single";
	return "Married";
}


public void setMaritalStatus(String maritalStatus) {
	if(maritalStatus.equals("Single"))
		this.maritalStatus = 1;
	else
	this.maritalStatus = 2;
}


public String getHasDriverLicense() {
	if(this.hasDriverLicense)
		return "Yes";
	return "No";
}


public void setHasDriverLicense(String hasDriverLicense) {
	if(hasDriverLicense.equals("Yes"))
		this.hasDriverLicense = true;
	else
	this.hasDriverLicense = false;
}
 @Override
public String toString() {
	return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
			+ ", birthDate=" + birthDate + ", maritalStatus=" + maritalStatus + ", hasDriverLicense=" + hasDriverLicense
			+ "]";
}
}
