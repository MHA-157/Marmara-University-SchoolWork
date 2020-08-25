//Muhammet Hasan Albayrak 150117053

import java.util.*;
public class Project {
	//Class file for Project
 private String projectName;
 private java.util.Calendar startDate;
 private boolean state;
 
 public  Project(String pName, Calendar startDate, String state) {
	 this.projectName = pName;
	 this.startDate = startDate;
	 if(state.equals("Open"))
		 this.state = true;
	 else
		 this.state = false;
 }
 
 public void setState(String state) {
	 if(state.equals("Open"))
		 this.state = true;
	 else
		 this.state = false;
 }
 
 public String getState() {
	 if(this.state)
		 return "Open";
	 return "Close";
 }
 public void close() {
	if(this.state)
	 this.setState("Close");
 }

public String getProjectName() {
	return projectName;
}

public void setProjectName(String projectName) {
	this.projectName = projectName;
}

public java.util.Calendar getStartDate() {
	return startDate;
}

public void setStartDate(java.util.Calendar startDate) {
	this.startDate = startDate;
}

public void setState(boolean state) {
	this.state = state;
}

@Override
public String toString() {
	return "Project [projectName=" + projectName + ", startDate=" + startDate + ", state=" + state + "]";
}
}
