//Muhammet Hasan Albayrak 150117053

import java.util.*;
public class RegularEmployee extends Employee{
  private double performanceScore;
  private double bonus;
//Constructor
  RegularEmployee(int id, String firstName, String lastName, String gender,
		  Calendar birthDate, String maritalStatus, String hasDriverLicence, double
		  salary, Calendar hireDate, Department department, double
		  performanceScore) throws Exception{
	  
	  super(id,  firstName,  lastName,  gender,
	    		 birthDate,  maritalStatus,  hasDriverLicence, 
	    		salary,  hireDate,  department);
	  
	  setPerformanceScore(performanceScore);
	  
  }
  
  RegularEmployee(Employee employee, double perfScore) throws Exception{
	  super(employee.getId(), employee.getFirstName(), employee.getLastName(),employee.getGender(),
			   employee.getBirthDate(), employee.getMaritalStatus(), employee.getHasDriverLicense(), 
			   employee.getSalary(), employee.getHireDate(), employee.getDepartmant());
	  setPerformanceScore(perfScore);
  }
  
  
  public double getPerformanceScore() {
	return performanceScore;
}
public void setPerformanceScore(double performanceScore) throws Exception {
	if(performanceScore > 0)
	this.performanceScore = performanceScore;
	
	else
		throw new Exception("Value must be positive");
}
public double getBonus() {
	return bonus;
}
public void setBonus(double bonus) throws Exception {
	if(bonus > 0)
	this.bonus = bonus;
	
	else 
		throw new Exception("Value must be positive");
}
@Override
public String toString() {
	return "RegularEmployee [performanceScore=" + performanceScore + ", bonus=" + bonus + "]";
}
  
  
}
