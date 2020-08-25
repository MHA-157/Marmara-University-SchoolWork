//Muhammet Hasan Albayrak 150117053

import java.util.*;
public class SalesEmployee extends RegularEmployee{
	//Class file for Sales Employee
  private ArrayList<Product> sales;
  public static int numberOfSalesEmployees;
  //Constructor
  public SalesEmployee(int id, String firstName, String lastName, String gender,
		  Calendar birthDate, String maritalStatus, String hasDriverLicence, double
		  salary, Calendar hireDate, Department department, double pScore,
		  ArrayList<Product> s) throws Exception {
	  super( id,  firstName,  lastName,  gender,
			   birthDate,  maritalStatus,  hasDriverLicence,
			  salary,  hireDate,  department, pScore
			  );
	  numberOfSalesEmployees++;
  }
   public SalesEmployee(RegularEmployee re, ArrayList<Product> s) throws Exception{
   
	   super(re.getId(), re.getFirstName(), re.getLastName(), re.getGender(),
			   re.getBirthDate(), re.getMaritalStatus(),re.getHasDriverLicense(), 
			   re.getSalary(), re.getHireDate(), re.getDepartmant(), re.getPerformanceScore()
			   );
	   numberOfSalesEmployees++;
    }
   
   
  
  public boolean addSale(Product s) {
	  if(!sales.contains(s)) {
		  sales.add(s);
		  if(sales.contains(s))
			  return true;
	  }
	  return false;
  }
  public boolean removeSale(Product s) {
	  if(sales.contains(s)) {
		  sales.remove(s);
		  if(!sales.contains(s))
			  return true;
	  }
	  return false;
  }

public ArrayList<Product> getSales() {
	return sales;
}

public void setSales(ArrayList<Product> sales) {
	this.sales = sales;
}

@Override
public String toString() {
	return "SalesEmployee [sales=" + sales + "]";
}
}
