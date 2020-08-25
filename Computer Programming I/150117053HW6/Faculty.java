//Muhammet Hasan Albayrak 150117053
public class Faculty {
	private int ID;
	private String name;
	private String surname;
	private String departmentName;
	private AssignInfo[] assignInfoList;
	
	public Faculty(int id, String name, String surname, String departmentName) {
		this.ID = id;
		this.name = name;
		this.surname = surname;
		this.departmentName = departmentName;
		
	}
	
	public boolean withdrawAssignInfo(Course course) {
		int a = 0;
		boolean condition = false;
		int length = assignInfoList.length;
		AssignInfo[] newAssignInfoList = new AssignInfo[length - 1];
		for(int i = 0; i < length; i++) {
			if(this.assignInfoList[i].getCourse() == course) {
			 a = i;
			 condition = true;
			}
		}
		
		for(int i = 0; i < length - 1; i++) {
			if((a == i) && condition)
				i++;
			if((a == i) && condition && (a == length - 1))
			break;
				newAssignInfoList[i] = assignInfoList[i];
		}
		return !condition;
	}
	
	public void addAssignInfo(AssignInfo assignInfo) {
		int length = 0;
		if(!(assignInfoList ==  null))
		 length = assignInfoList.length;
		else
			length = 0;
		if((assignInfoList ==  null)) {
			AssignInfo[] newAssignInfoList = new AssignInfo[length + 1];
			newAssignInfoList[length] = assignInfo;
			this.assignInfoList = newAssignInfoList;
		}
		else {
			AssignInfo[] newAssignInfoList = new AssignInfo[length + 1];
		 for(int i = 0; i < length; i++) {
			 newAssignInfoList[i] = this.assignInfoList[i];
		 }
		 newAssignInfoList[length + 1] = assignInfo;
		 this.assignInfoList = newAssignInfoList;
		}
	}
	
	public void printCourseList() {
		System.out.println("-------------------------------------------------------------------------------------------");
		System.out.println("printCourseList METHOD OF INSTRUCTOR ->");
		System.out.println("Instructor " + name + surname + " Department " + departmentName);
		for(int i = 0; i < assignInfoList.length; i++)
			System.out.println("COURSE : " + assignInfoList[i].getCourse().getName());
		System.out.println("-------------------------------------------------------------------------------------------");
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public AssignInfo[] getAssignInfoList() {
		return assignInfoList;
	}
	public void setAssignInfoList(AssignInfo[] assignInfoList) {
		this.assignInfoList = assignInfoList;
	}
	
	

}
