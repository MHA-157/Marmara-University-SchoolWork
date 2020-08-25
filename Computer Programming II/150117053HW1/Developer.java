//Muhammet Hasan Albayrak 150117053

import java.util.*;
public class Developer extends RegularEmployee {
	//Class file for Developer
 private ArrayList< Project > projects;
 public static int numberOfDevelopers;
 
 //Constructor
  public Developer(int id, String firstName, String lastName, String gender,
		  Calendar birthDate, String maritalStatus, String hasDriverLicence, double
		  salary, Calendar hireDate, Department department, double pScore,
		  ArrayList<Project> p) throws Exception {
	  super(id,  firstName,  lastName,  gender,
			   birthDate,  maritalStatus,  hasDriverLicence,
			  salary,  hireDate,  department, pScore);
	  numberOfDevelopers++;
  }

 public Developer(RegularEmployee re, ArrayList<Project> p) throws Exception {
	  super(re.getId(), re.getFirstName(), re.getLastName(), re.getGender(),
			   re.getBirthDate(), re.getMaritalStatus(),re.getHasDriverLicense(), 
			   re.getSalary(), re.getHireDate(), re.getDepartmant(), re.getPerformanceScore()
			   );
	  numberOfDevelopers++;
  }
  
  public boolean addProject(Project s) {
	  if(!projects.contains(s)) {
	  projects.add(s);
	  if(projects.contains(s))
		  return true;
	  }
	  
	  return false;
  }
  
  public boolean removeProject(Project s) {
	 if(projects.contains(s)) { 
	  projects.remove(s);
	  return true;
	 }
	 return false;
	 }
  
public ArrayList<Project> getProjects() {
	return projects;
}

public void setProjects(ArrayList<Project> projects) {
	this.projects = projects;
}

@Override
public String toString() {
	return "Developer [projects=" + projects + "]";
}
}
