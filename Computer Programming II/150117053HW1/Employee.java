//Muhammet Hasan Albayrak 150117053

import java.util.*;
public class Employee extends Person{
	//Class file for Employee
	private double salary;
	private java.util.Calendar hireDate;
    private Department departmant;
	public static int numberofEmployees;
    
	//Constructor
    public Employee(int id, String firstName, String lastName, String gender,
    		Calendar birthDate, String maritalStatus, String hasDriverLicence, double
    		salary, Calendar hireDate, Department department) throws Exception {
    	super( id,  firstName,  lastName,  gender, birthDate,  maritalStatus,  hasDriverLicence);
    	
    	setSalary(salary);
    	setHireDate(hireDate);
    	setDepartmant(departmant);
    	numberofEmployees++;
    }
    
    public Employee(Person person, double salary, Calendar hireDate, Department
    department) throws Exception {
    	super(person.getId(), person.getFirstName(), person.getLastName(), person.getGender(),
			   person.getBirthDate(), person.getMaritalStatus(), person.getHasDriverLicense() 
			   );
    }
    
    public double raiseSalary(double percent) throws Exception {
    	if(percent >= 0 && percent <= 1) {
    	this.setSalary(this.salary * (1 + percent));
    	}
    	else
    		throw new Exception("Value must be positive and under 1");
    	return this.salary;
    	
    }
    
    public double raiseSalary(int amount) throws Exception {
    	if(amount > 0) {
    	this.setSalary(this.getSalary() + amount);
    	}
    	else
    		throw new Exception("Value must be positive");
    	return this.salary;
    }
    
	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) throws Exception {
		if(salary >= 0) {
		this.salary = salary;
		}
		
		else
			throw new Exception("Value must be positive");
	}

	public java.util.Calendar getHireDate() {
		return hireDate;
	}

	public void setHireDate(java.util.Calendar hireDate) {
		this.hireDate = hireDate;
	}

	public Department getDepartmant() {
		return departmant;
	}

	public void setDepartmant(Department departmant) {
		this.departmant = departmant;
	}

	@Override
	public String toString() {
		return "Employee [salary=" + salary + ", hireDate=" + hireDate + ", departmant=" + departmant + "]";
	}

	
}
