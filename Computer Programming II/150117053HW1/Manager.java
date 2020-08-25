//Muhammet Hasan Albayrak 150117053

import java.util.*;
public class Manager extends Employee{
	//Class file for Manager
   private ArrayList<RegularEmployee> regularEmployees;
   private double bonusBudget;
   
     //Constructor
   public Manager(int id, String firstName, String lastName, String gender,
		   Calendar birthDate, String maritalStatus, String hasDriverLicence, double
		   salary, Calendar hireDate, Department department,double bonusBudget) throws Exception {
	   
	   super( id,  firstName,  lastName,  gender,
	    		 birthDate,  maritalStatus,  hasDriverLicence, 
	    		salary,  hireDate,  department);
	   
	   setBonusBudget(bonusBudget);
   }
   
   public Manager(Employee employee, double bonusBudget) throws Exception {
	   super(employee.getId(), employee.getFirstName(), employee.getLastName(),employee.getGender(),
			   employee.getBirthDate(), employee.getMaritalStatus(), employee.getHasDriverLicense(), 
			   employee.getSalary(), employee.getHireDate(), employee.getDepartmant());
	   setBonusBudget(bonusBudget);
   }
   
   public void addEmployee( RegularEmployee e)  {
	   regularEmployees.add(e);
   }
   
   public void removeEmployee( RegularEmployee e) {
	   regularEmployees.remove(e);
   }
   
   public void distributeBonusBudget() throws Exception {
	   double  totalSalary = 0;
	   for( int i = 0; i < this.regularEmployees.size(); i++) {
		   totalSalary += this.regularEmployees.get(i).getPerformanceScore() * 
				   this.regularEmployees.get(i).getSalary();
	   }
	   double unit = this.bonusBudget / totalSalary;
	   
	   for( int i = 0; i < this.regularEmployees.size(); i++) {
		   this.regularEmployees.get(i).setBonus(unit * this.regularEmployees.get(i).getPerformanceScore() * 
				   this.regularEmployees.get(i).getSalary());
	   }
	   
   }
   
   public ArrayList<RegularEmployee> getRegularEmployees() {
	return regularEmployees;
}
public void setRegularEmployees(ArrayList<RegularEmployee> regularEmployees) {
	this.regularEmployees = regularEmployees;
}
public double getBonusBudget() {
	return bonusBudget;
}
public void setBonusBudget(double bonusBudget) {
	this.bonusBudget = bonusBudget;
}

@Override
public String toString() {
	return "Manager [regularEmployees=" + regularEmployees + ", bonusBudget=" + bonusBudget + "]";
}
   
   
}
