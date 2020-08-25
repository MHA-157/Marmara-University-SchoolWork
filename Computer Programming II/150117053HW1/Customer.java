//Muhammet Hasan Albayrak 150117053

import java.util.ArrayList;
import java.util.List;
import java.util.*;
public class Customer extends Person{
	//Class file for Customer object
  private ArrayList<Product> products;
  
  //Constructor
   public Customer(int id, String firstName, String lastName, String gender,
		   Calendar birthDate, String maritalStatus,String hasDriverLicence,
		   ArrayList<Product> products) throws Exception {
	   super( id,  firstName, lastName,  gender,  birthDate,  maritalStatus,  hasDriverLicence);
	   
	   setProducts(products);
   }
   public Customer(Person person, ArrayList<Product> products) throws Exception {
	   super(person.getId(), person.getFirstName(), person.getLastName(), person.getGender(),
			   person.getBirthDate(), person.getMaritalStatus(), person.getHasDriverLicense() 
			   );
	   setProducts(products);
   }
   
   @Override
public String toString() {
	return "Customer [products=" + products + "]";
}

public ArrayList<Product> getProducts() {
	return products;
}

public void setProducts(ArrayList<Product> products) {
	this.products = products;
}
}

