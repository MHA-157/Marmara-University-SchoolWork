//Muhammet Hasan Albayrak 150117053

import java.util.*;
public class Department {
	//Class file for department
  private int depatmentId;
  private String departmentName;
  
  //Constructor
  public Department(int departmentId, String departmentName) {
	  this.departmentName = departmentName;
	  this.depatmentId = departmentId;
  }

public int getDepatmentId() {
	return depatmentId;
}

public void setDepatmentId(int depatmentId) {
	this.depatmentId = depatmentId;
}

public String getDepartmentName() {
	return departmentName;
}

public void setDepartmentName(String departmentName) {
	this.departmentName = departmentName;
}

@Override
public String toString() {
	return "Department [depatmentId=" + depatmentId + ", departmentName=" + departmentName + "]";
}
}
