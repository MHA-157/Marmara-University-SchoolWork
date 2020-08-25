//Muhammet Hasan Albayrak 150117053
public class Course {
	private String department;
	private String name;
	private int credits;
	private int prereqYear;
	private int maxEnrollentment;
	private int reservedSeats;
	private Student[] studentLists;
	private Student[] replacementList;
	private Faculty instructor;
	
	public Course(String department, String name, int credits, int prereqYear,
			int maxEnrollentment, int reservedSeats) {
		this.department = department;
		this.name = name;
		this.credits = credits;
		this.prereqYear = prereqYear;
		this.maxEnrollentment = maxEnrollentment;
		this.reservedSeats = reservedSeats;
		
	}
	
	public RegisterInfo registerCourse(Student std) {
		RegisterInfo registerInfo = new RegisterInfo();
		
		
		String result = "REJECTED";
		String message = "REQUEST REJECTED – PREREQUISITE";
		int major = 0;
		int ID = 0;
		registerInfo.setCourse(this);
		if(std.getMajor().equals(department))
			major = 1;
		switch(major) {
		
		case 1:
		if(std.getYear() >= getPrereqYear()) {
			int a = 0;
			if(this.studentLists == null)
				a = 0;
			else 
				a = this.studentLists.length;
			if(a != maxEnrollentment) {
				
				if( a  < maxEnrollentment - reservedSeats) {
					message = "REQUEST APPROVED";
					result = "APRROVED";
					
					
					if(this.getStudentLists() == null) {
						Student[] newStudentList = new Student[1];
						newStudentList[0 ] = std;
						this.studentLists = newStudentList;
						registerInfo.setRegisterMessage(message);
						registerInfo.setResult(result);
						registerInfo.setRegisterID(a);
						std.addRegisterInfo(registerInfo);
					}
					else {
						Student[] newStudentList = new Student[a + 1];
					 for(int i = 0; i < a; i++) {
						 message = "REQUEST APPROVED";
							result = "APRROVED";
						 newStudentList[i] = this.studentLists[i];
					 }
					 newStudentList[a ] = std;
					 this.studentLists = newStudentList;
					 registerInfo.setRegisterMessage(message);
						registerInfo.setResult(result);
						registerInfo.setRegisterID(a);
						std.addRegisterInfo(registerInfo);
					}
				}
				else {
					message = "WAITING - REPLACEMENT LIST";
					result = "WAITING";
					int length = 0;
					if(this.getReplacementList() == null)
						length = 0;
					else
						length = replacementList.length;
					
					if(this.getReplacementList() == null) {
						Student[] newreplacementList = new Student[ 1];
						newreplacementList[0 ] = std;
						this.replacementList = newreplacementList;
						registerInfo.setRegisterMessage(message);
						registerInfo.setResult(result);
					}
					else {
						Student[] newreplacementList = new Student[length + 1];
					 for(int i = 0; i < length; i++) {
						 newreplacementList[i] = this.replacementList[i];
					 }
					 newreplacementList[length ] = std;
					 this.replacementList = newreplacementList;
					 registerInfo.setRegisterMessage(message);
						registerInfo.setResult(result);
					}
				}
			}
			
			else {
				message = "REQUEST REJECTED – QUATO";
				result = "REJECTED";
				registerInfo.setRegisterMessage(message);
				registerInfo.setResult(result);
			}
		}
			
		else {
			message = "REQUEST REJECTED – PREREQUISITE";
			result = "REJECTED";
			registerInfo.setRegisterMessage(message);
			registerInfo.setResult(result);
		}
		break;
		case 0:
			if(std.getYear() >= getPrereqYear()) {
				int a = 0;
				if(this.studentLists == null)
					a = 1;
				else 
					a = this.studentLists.length;
			if(a < maxEnrollentment * 70 / 100) {
				message = "REQUEST APPROVED";
				result = "APRROVED";

				if(this.studentLists == null) {
					Student[] newStudentList = new Student[1];
					newStudentList[0] = std;
					this.studentLists = newStudentList;
					registerInfo.setRegisterMessage(message);
					registerInfo.setResult(result);
					registerInfo.setRegisterID(1);
					std.addRegisterInfo(registerInfo);
				}
				else {
					Student[] newStudentList = new Student[this.studentLists.length + 1];
				 for(int i = 0; i < this.studentLists.length; i++) {
					 newStudentList[i] = this.studentLists[i];
				 }
				 newStudentList[this.studentLists.length ] = std;
				 this.studentLists = newStudentList;
				 registerInfo.setRegisterMessage(message);
					registerInfo.setResult(result);
					registerInfo.setRegisterID(this.studentLists.length);
					std.addRegisterInfo(registerInfo);
				}
				
			}
               else if(reservedSeats != 0) {
            	   message = "WAITING - REPLACEMENT LIST";
					result = "WAITING";
					
					
					if(replacementList == null) {
						Student[] newreplacementList = new Student[ 1];
						newreplacementList[0] = std;
						this.replacementList = newreplacementList;
					}
					else {
						Student[] newreplacementList = new Student[replacementList.length + 1];
					 for(int i = 0; i < replacementList.length ; i++) {
						 newreplacementList[i] = this.replacementList[i];
					 }
					 newreplacementList[replacementList.length] = std;
					 this.replacementList = newreplacementList;
					}
			}
			
			else {
				message = "REQUEST REJECTED – QUATO";
				result = "REJECTED";
				registerInfo.setRegisterMessage(message);
				registerInfo.setResult(result);
				
			}
		}
		else {
			message = "REQUEST REJECTED – PREREQUISITE";
			result = "REJECTED";
			registerInfo.setRegisterMessage(message);
			registerInfo.setResult(result);
				
			}
		}
		
	  
		return registerInfo;
	}
    
	public AssignInfo  AssignInstructor(Faculty instructor, boolean force) {
		AssignInfo assignInfo = new AssignInfo();
		assignInfo.setCourse(this);
		String result = "";
		String message = "";
		if(instructor.getDepartmentName().equals(department)) {
		if(force) {
			if(!(this.instructor.getName().length() > 0) ) {
				this.instructor = instructor;
				result = "APPROVED";
				message = "INSTRUCTOR" + instructor.getName() + instructor.getSurname() +
						"ASSIGNED";
				assignInfo.setAssignMessage(message);
				assignInfo.setAssignResult(result);
				instructor.addAssignInfo(assignInfo);
			}
			else {
				this.instructor.withdrawAssignInfo(this);
				this.instructor = instructor;
				result = "APPROVED";
				message = "INSTRUCTOR" + instructor.getName() + instructor.getSurname() +
						"ASSIGNED";
				assignInfo.setAssignMessage(message);
				assignInfo.setAssignResult(result);
				instructor.addAssignInfo(assignInfo);
			}
			
		}
		else {
			
			if(this.instructor == null) {
				this.instructor = instructor;
				result = "APPROVED";
				message = "INSTRUCTOR" + instructor.getName() + instructor.getSurname() +
						"ASSIGNED";
				assignInfo.setAssignMessage(message);
				assignInfo.setAssignResult(result);
				instructor.addAssignInfo(assignInfo);
				
			
			}
			else {
				result = "REJECTED";
				message = "ANOTHER INSTRUCTOR HAS ALREADY ASSIGNED";
			}
		}
		
	}
		else {
			result = "REJECTED";
			message = "DEPARTMENT MISMATCH";
			assignInfo.setAssignMessage(message);
			assignInfo.setAssignResult(result);
		}
		
		return assignInfo;
	}
	
	public void RegisterReplacementList() {
		System.out.println("RegisterReplacementList METHOD ->");
		if(replacementList == null) {
			System.out.println("No Student in list");
			}
		else {
		int emptySpace = reservedSeats;
		 int	length = 0;
		RegisterInfo registerInfo = new RegisterInfo();
	    registerInfo.setCourse(this);
	    registerInfo.setRegisterMessage("REQUEST APPROVED");
	    registerInfo.setResult("APPROVED");
	    if(instructor == null)
	   	length = 0;
	    else
	    	length = 1;
	    
	    	
		if(length > 0 ) {
				for(int i = 0; i < replacementList.length; i++) {
						if(replacementList[i] != null)
					if(replacementList[i].getMajor().equals(department)) {
						registerInfo.setRegisterID(studentLists.length + 1);
						registerCourse(replacementList[i]);
						replacementList[i].addRegisterInfo(registerInfo);
						System.out.println("Student " + replacementList[i].getName() + " " + replacementList[i].getSurname()
								+ " assigned to " + name + " from replacement list.");
						reservedSeats--;
						
						replacementList[i] = null;
					 }
				}
				for(int j = 0; j < replacementList.length; j++) {
					if(replacementList[j] != null)
						if(!(replacementList[j].getMajor().equals(null))) {
							registerInfo.setRegisterID(studentLists.length + 1);
							registerCourse(replacementList[j]);
							replacementList[j].addRegisterInfo(registerInfo);
							replacementList[j] = null;
						}
					
				}
			
		}
		else {
			System.out.println("COURSE DOES NOT HAVE INSTRUCTOR!!");
		}
		}
		System.out.println("-------------------------------------------------------------------------------------------");
	}
	
	public void printStudentList() {
		System.out.println("-------------------------------------------------------------------------------------------");
		System.out.println("printStudentList METHOD OF COURSE->");
		System.out.println("COURSE : " + name + "   DEPARTMENT : " + department);
		System.out.println("Registered Student List");
		for(int i = 0; i < studentLists.length; i++) {
			System.out.println( "Student ID" + studentLists[i].getID() + " Name" +  studentLists[i].getName() + " " + studentLists[i].getSurname());
		}
		if(replacementList == null)
			System.out.println("No Student in Replacement List");
		else {
			for(int i = 0; i < replacementList.length; i++) {
				if(replacementList[i] != null)
				System.out.println( "Student ID" + replacementList[i].getID() + " Name" +  replacementList[i].getName() + " " + replacementList[i].getSurname());
		}
		}
		System.out.println("-------------------------------------------------------------------------------------------");
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public int getPrereqYear() {
		return prereqYear;
	}

	public void setPrereqYear(int prereqYear) {
		this.prereqYear = prereqYear;
	}

	public int getMaxEnrollentment() {
		return maxEnrollentment;
	}

	public void setMaxEnrollentment(int maxEnrollentment) {
		this.maxEnrollentment = maxEnrollentment;
	}

	public int getReservedSeats() {
		return reservedSeats;
	}

	public void setReservedSeats(int reservedSeats) {
		this.reservedSeats = reservedSeats;
	}

	public Student[] getStudentLists() {
		return studentLists;
	}

	public void setStudentLists(Student[] studentLists) {
		this.studentLists = studentLists;
	}

	public Student[] getReplacementList() {
		return replacementList;
	}

	public void setReplacementList(Student[] replacementList) {
		this.replacementList = replacementList;
	}

	public Faculty getInstructor() {
		return instructor;
	}

	public void setInstructor(Faculty instructor) {
		this.instructor = instructor;
	}
}
