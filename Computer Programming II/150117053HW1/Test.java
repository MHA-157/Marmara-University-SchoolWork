//Muhammet Hasan Albayrak 150117053
import java.io.File;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
public class Test {
//Test program for the classes
	public static void main(String[] args) throws Exception  {
		// TODO Auto-generated method stub
		 //ArrayLists for objects
		ArrayList<Person> people = new ArrayList<>();
	       ArrayList<Department> departments = new ArrayList<>();
	       ArrayList<Project> projects = new ArrayList<>();
	       ArrayList<Product> products = new ArrayList<>();
	       ArrayList<Manager> managers = new ArrayList<>();
	       ArrayList<Employee> employees = new ArrayList<>();
	       ArrayList<RegularEmployee> regularEmployees = new ArrayList<>();
	       ArrayList<Developer> developers = new ArrayList<>();
	       ArrayList<SalesEmployee> salesEmployees = new ArrayList<>();
	       ArrayList<Customer> customers = new ArrayList<>();
	       
	       
		 //Taking input file
       
		Scanner consoleInput = new Scanner(System.in);
		
       System.out.print("Enter file name ");
      String filename = consoleInput.nextLine();
      
      
       File filenames = new File(filename);
       //Reading input file
       try(Scanner input = new Scanner( (filenames))){
    	   while(input.hasNext()) {
    		   String s = input.nextLine();
    		  
    		   String[] line = s.split("[ \\t\\n\\r /]");
    		  int index = 0;
    		 //Creating switch for each object
    		  switch(line[0]) {
    		 //Creating person and adding to list
    		  case "Person":
    			 
    			 Calendar calendarpe = new GregorianCalendar(Integer.parseInt(line[7]), Integer.parseInt(line[6]), Integer.parseInt(line[5]));
    			 Person person = new Person(Integer.parseInt(line[3]), line[1],line[2] , line[4], calendarpe, line[8], line[9]);
    			 people.add(person);
    			 break;
    		
    			 //Creating customer adding to list
    		  case "Customer":
    			 
    			 ArrayList<Product> customerProducts = new ArrayList<>();
    			
    			 for(int i = 0; i < people.size(); i++) {
    				if(people.get(i).getId() == Integer.parseInt(line[1]))
    					index = i;
    			}
    			 for(int i = 0; i < products.size(); i++) {
    				 for(int j = 2; j < line.length; j++ )
    				 if(products.get(i).getProductName().equals(line[j]))
    					 customerProducts.add(products.get(i));
    			 }
    		    Customer customer = new Customer(people.get(index), customerProducts );
    		    people.set(index, customer);
    		    customers.add(customer);
    			 
    		 break;
    		 
    		 //Creating employee adding to the lists 
    		 case "Employee":
    			 
    			 int a = 0;
    			 
    			 for(int i = 0; i < people.size(); i++) {
    				if(people.get(i).getId() == Integer.parseInt(line[1]))
    					index = i;
    				
    			}
    			 Calendar calendarem = new GregorianCalendar(Integer.parseInt(line[5]), Integer.parseInt(line[4]), Integer.parseInt(line[3]));
    			 for(int i = 0; i < departments.size(); i++) {
    				 if(departments.get(i).getDepartmentName().equals(line[6]))
    					a = i;
    					
    			 }
    			 Employee employee = new Employee(people.get(index), Integer.parseInt(line[2]), calendarem, departments.get(a));
    			 people.set(index, employee);
    			 employees.add(employee);
    			 break;
    			 
    			 //Creating department adding to list
    		 case "Department":
    			 
    			 Department department = new Department(Integer.parseInt(line[1]), line[2]);
    			 departments.add(department);
    			
    			 break;
    		
    		 //Creating project adding to list
    		 case "Project":
    			 
    			 Calendar calendarp = new GregorianCalendar(Integer.parseInt(line[4]), Integer.parseInt(line[3]), Integer.parseInt(line[2]));
    			 Project project = new Project(line[1], calendarp, line[5]);
    			 projects.add(project);
    			 
    			 
    			 break;
    		
    		 //Creating developer adding to lists
    		 case "Developer":
    			 
    			 ArrayList<Project> developerProjects = new ArrayList<>();
    			 
    			 for(int i = 0; i < people.size(); i++) {
     				if(people.get(i).getId() == Integer.parseInt(line[1]))
     					index = i;
     				
     			}
    			 
    			 for(int i = 0; i < projects.size(); i++) {
    				 for(int j = 2; j < line.length; j++)
    				 if(projects.get(i).getProjectName().equals(line[j]))
    					 developerProjects.add(projects.get(i));
    			 }
    			 
    			 Developer dev = new Developer((RegularEmployee)people.get(index), developerProjects);
    			 people.set(index, dev);
    			 
    			 for(int i = 0; i < regularEmployees.size(); i++) {
        				if(regularEmployees.get(i).getId() == Integer.parseInt(line[1]))
        					index = i;
        				
        			}
    			 regularEmployees.set(index, dev);
     			 
     			 for(int i = 0; i < employees.size(); i++) {
         				if(employees.get(i).getId() == Integer.parseInt(line[1]))
         					index = i;
         				
         			}
     			 
    			 employees.set(index, dev);
    			 
    			 developers.add(dev);
    			 
    			 break;
    			 
    			 //Creating regular employee adding to lists
    		 case "RegularEmployee":
    			 
    			 
    			 for(int i = 0; i < people.size(); i++) {
    				if(people.get(i).getId() == Integer.parseInt(line[1]))
    					index = i;
    				
    			}
    			 RegularEmployee re = new RegularEmployee((Employee)people.get(index), Double.parseDouble(line[2]));
    			 people.set(index, re);
    			 
    			 for(int i = 0; i < managers.size(); i++) {
    				 if(managers.get(i).getDepartmant().getDepartmentName().equals(re.getDepartmant().getDepartmentName())) {
    					 managers.get(i).addEmployee(re);
    					 
    				 }
    			 }
    			 regularEmployees.add(re);
    			 
    			 for(int i = 0; i < employees.size(); i++) {
      				if(employees.get(i).getId() == Integer.parseInt(line[1]))
      					index = i;
      				
      			}
    			 employees.set(index, re);
    			 break;
    			 
    			 //Creating product adding to lists
    		 case "Product":
    			 
    			 
    			 Calendar calendarpr = new GregorianCalendar(Integer.parseInt(line[4]), Integer.parseInt(line[3]), Integer.parseInt(line[2]));
    			 Product product = new Product(line[1], calendarpr, Integer.parseInt(line[5]));
    			 products.add(product);
    			 
    			 
    			 break;
    			 
    			 //Creating manager adding to lists
    		 case "Manager":
    			 
    			 for(int i = 0; i < people.size(); i++) {
     				if(people.get(i).getId() == Integer.parseInt(line[1]))
     					index = i;
     				
     			}
    			 Manager man = new Manager((Employee)people.get(index), Double.parseDouble(line[2]));
    			 
    			 people.set(index, man);
    			 managers.add(man);
    			 employees.set(index, man);
    			 break;
    			 
    			 //Creating sales Employee adding lists
    		 case "SalesEmployee":
    			 ArrayList<Product> saleProducts = new ArrayList<>();
    			 for(int i = 0; i < people.size(); i++) {
      				if(people.get(i).getId() == Integer.parseInt(line[1]))
      					index = i;
      				
      			}
    			 for(int i = 0; i < projects.size(); i++) {
    				 for(int j = 2; j < line.length; j++)
    				 if(products.get(i).getProductName().equals(line[j]))
    					 saleProducts.add(products.get(i));
    			 }
    			 SalesEmployee saleEmp = new SalesEmployee((RegularEmployee)people.get(index), saleProducts);
    			 people.set(index, saleEmp);
    			
    			 for(int i = 0; i < regularEmployees.size(); i++) {
       				if(regularEmployees.get(i).getId() == Integer.parseInt(line[1]))
       					index = i;
       				
       			}
    			 regularEmployees.set(index, saleEmp);
    			 
    			 for(int i = 0; i < employees.size(); i++) {
        				if(employees.get(i).getId() == Integer.parseInt(line[1]))
        					index = i;
        				
        			}
    			 employees.set(index, saleEmp);
    			 
    			 salesEmployees.add(saleEmp);
    			 break;
    		 }
    	   }
       }
       
       catch( Exception e){
    	   System.out.println("File can not found");
       }
       
       //Commencing actions
       for(int i = 0; i < managers.size(); i++) {
    	   managers.get(i).distributeBonusBudget();
    	   
       }
       //Raises
       for(int i = 0; i < employees.size(); i++) {
    	   if(employees.get(i) instanceof Manager)
    		   employees.get(i).raiseSalary(0.2);
    	   if(employees.get(i) instanceof RegularEmployee)
    		   employees.get(i).raiseSalary(0.3);
    	   if(employees.get(i) instanceof Developer)
    		   employees.get(i).raiseSalary(0.23);
    	   if(employees.get(i) instanceof SalesEmployee)
    		   employees.get(i).raiseSalary(0.18);       
    	   }
       int maxSales = 0;
       int index = 0;
       //Raise for sale employee
       for(int i = 0; i < salesEmployees.size(); i++) {
    	   if(salesEmployees.get(i).getSales().size() > maxSales)
    		   index = i;
       }
       for(int i = 0; i < employees.size(); i++) {
    	   if(salesEmployees.get(index).getId() == employees.get(i).getId())
    		   employees.get(i).raiseSalary(1000);
       }
        
		File output = new File("output"); 
        PrintWriter printWriter = new PrintWriter(output);
        for(int i = 0; i < departments.size(); i++) {
        	printWriter.print(departments.get(i).toString());
        	System.out.println();
        	for(int j = 0; i < managers.size(); i++) {
        		printWriter.println(managers.get(j).toString());
        		for(int k = 0; k < managers.get(j).getRegularEmployees().size(); k++)
        			printWriter.print( managers.get(j).getRegularEmployees().get(k).toString());
        	}
        	
        }
        
	}

}
