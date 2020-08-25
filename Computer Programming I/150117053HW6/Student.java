//Muhammet Hasan Albayrak 150117053

 public class Student {
	private String name;
	
	private String	surname;
	
	private String major;
	
	private int ID;
	
	private int year;
	
	private RegisterInfo[] registerList;
	
	
	public  Student(String name, String surname, String major, int ID, int year) {
		 this.name = name;
		 this.surname = surname;
		 this.major = major;
		 this.ID = ID;
		 this.year = year;
		 
	 }
	public void addRegisterInfo(RegisterInfo registerInfo) {
		int length = 0;
		if(registerList == null)
			length= 1;
		else
			length = registerList.length;
		
		if(registerList == null) {
			RegisterInfo[] newRegisterList = new RegisterInfo[ 1];
			newRegisterList[0] = registerInfo;
			this.registerList = newRegisterList;
		}
		else {
			RegisterInfo[] newRegisterList = new RegisterInfo[length + 1];
		 for(int i = 0; i < length; i++) {
			 newRegisterList[i] = this.registerList[i];
		 }
		 newRegisterList[length ] = registerInfo;
		 this.registerList = newRegisterList;
		}
		
	}
	public boolean removeRegistorInfo(Course course) {
		int a = 0;
		boolean condition = false;
		int length = registerList.length;
		RegisterInfo[] newRegisterList = new RegisterInfo[length - 1];
		for(int i = 0; i < length; i++) {
			if(this.registerList[i].getCourse() == course) {
			 a = i;
			 condition = true;
			}
		}
		
		for(int i = 0; i < length - 1; i++) {
			if((a == i) && condition)
				i++;
			if((a == i) && condition && (a == length - 1))
			break;
				newRegisterList[i] = registerList[i];
		}
		return !condition;
		
	}
	public void printCourseList() {
		System.out.println("-------------------------------------------------------------------------------------------");
		
		System.out.println("printCourseList METHOD OF STUDENT ->");
		if(registerList == null) {
			System.out.println(name +" " +  surname + "\n No registered course"); 
		}
		else {
		int length = registerList.length;
		System.out.println(name + " " + surname + "   MAJOR " + major);
		for(int i = 0; i < length; i++)
			if(!(i != 0 && registerList[i].getCourse().getName().equals(registerList[i - 1].getCourse().getName())))
			System.out.println("COURSE : " + registerList[i].getCourse().getName() + "\n TOTAL CREDÝTS : " + getTotalCredit());
		}
		System.out.println("-------------------------------------------------------------------------------------------");
	}
	public int getTotalCredit() {
		int credits = 0;
		int length = registerList.length;
		for(int i = 0; i < length; i++) {
			if(!(i != 0  && registerList[i].getCourse().equals(registerList[i - 1].getCourse())))
			credits += registerList[i].getCourse().getCredits();
		}
		return credits;
	}
	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
	}
	public String getMajor() {
		return major;
	}
	public int getID() {
		return ID;
	}
	public int getYear() {
		return year;
	}
	public RegisterInfo[] getRegisterList() {
		return registerList;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public void setID(int ID) {
		this.ID = ID;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public void setRegisterList(RegisterInfo[] registerList) {
		this.registerList = registerList;
	}
	}

 
