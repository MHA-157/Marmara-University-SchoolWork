
 
public class Test {

	public static void main(String[] args) {

		// The following part creates several student objects in order of first name, last name, major, student ID, year,
		Student ayse = new Student ("Ayse", "Caliskan", "Computer Engineering", 150180001, 4);
		Student mehmet = new Student ("Mehmet", "Yilmaz", "Computer Engineering", 150180088, 3);
		Student ali = new Student ("Ali", "Ozdemir", "English", 450181112, 1);
		Student elif = new Student ("Elif", "Ozturk", "English", 450181145, 2);
        Student hasan = new Student("hasan", "albayrak", "History", 474401151, 2);

		// The following part creates several faculty objects in order of instructor ID, first name, last name, department, office
		Faculty sanem = new Faculty (111, "Sanem", "Arslan Yilmaz", "Computer Engineering");
		Faculty fatma = new Faculty (222, "Fatma", "Corut Ergin", "Computer Engineering");


		// The following part creates several course objects in order of department, title, course credits, prereq year, max enrollment, current reserved seats
		Course cse1141 = new Course ("Computer Engineering", "CSE1141", 15, 1, 10, 9);
		Course eng4000 = new Course ("English", "ENG4000", 12, 2, 5, 0);

		// Add students to courses
		RegisterInfo reg1 = cse1141.registerCourse(ayse);
		System.out.println("Test -> Course : " + reg1.getCourse().getName() + "\tResult : " + reg1.getResult() + "\tMessage : " + reg1.getRegisterMessage());

		reg1 = cse1141.registerCourse(mehmet);
		System.out.println("Test -> Course : " + reg1.getCourse().getName() + "\tResult : " + reg1.getResult() + "\tMessage : " + reg1.getRegisterMessage());

		reg1 = eng4000.registerCourse(ali);
		System.out.println("Test -> Course : " + reg1.getCourse().getName() + "\tResult : " + reg1.getResult() + "\tMessage : " + reg1.getRegisterMessage());

		reg1 = eng4000.registerCourse(ayse);
		System.out.println("Test -> Course : " + reg1.getCourse().getName() + "\tResult : " + reg1.getResult() + "\tMessage : " + reg1.getRegisterMessage());

		reg1 = eng4000.registerCourse(elif);
		System.out.println("Test -> Course : " + reg1.getCourse().getName() + "\tResult : " + reg1.getResult() + "\tMessage : " + reg1.getRegisterMessage());
         
		reg1 = eng4000.registerCourse(hasan);
		System.out.println("Test -> Course : " + reg1.getCourse().getName() + "\tResult : " + reg1.getResult() + "\tMessage : " + reg1.getRegisterMessage());
		System.out.println("-------------------------------------------------------------------------------------------");

		//Print the course lists of the students
		ayse.printCourseList();
		mehmet.printCourseList();
		ali.printCourseList();
		elif.printCourseList();
       hasan.printCourseList();

		//Register students in replacement list to the courses
		cse1141.RegisterReplacementList();

		//Assign instructors to the courses
		AssignInfo ass1 = cse1141.AssignInstructor(sanem, false); //Assign sanem to cse1141 without forcing
		System.out.println("Test -> Course : " + ass1.getCourse().getName() + " Result : " + ass1.getAssignResult() + " Message : " + ass1.getAssignMessage());

		System.out.println();

		ass1 = cse1141.AssignInstructor(fatma, true); //Assign fatma to cse1141 by force
		System.out.println("Test -> Course : " + ass1.getCourse().getName() + " Result : " + ass1.getAssignResult() + " Message : " + ass1.getAssignMessage());

		//Print the course lists of the instructors
		sanem.printCourseList();
		fatma.printCourseList();

		//Register students in replacement list to the course with instructor's decisions
		cse1141.RegisterReplacementList();

		//Print the course lists of the students
		mehmet.printCourseList();
		cse1141.printStudentList();


	}

}

