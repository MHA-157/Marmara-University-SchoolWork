import java.util.Scanner;
public class Pro4_150117053 {
//Muhammet Hasan Albayrak 150117053
	/*This program's purpose is implementing 6 different thing on a string
	 * first one finds the there are how many of given char int the given string
	 * second one prints every word in a string in a new line
	 * third one deletes given substring in a given string 
	 * fourth one replaces substring with another substring
	 * fifth one sorts characters in ascýý values and by their kind
	 * sixth one gives its hash code   */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         //There are four scanner because I need another scanner for strings with whitespace
		Scanner input = new Scanner(System.in);
         Scanner scan = new Scanner(System.in);
         Scanner scn = new Scanner(System.in);
         Scanner dltdSbstr = new Scanner(System.in);
       //Variable for main method loop
         boolean continuity = true;
        //Variable for switch cases
         int option = 0;
        do {
        	option = 0;
       //Showing options
        	System.out.println("Welcome to our String Analyzer Program.\r\n" + 
				"1. Count number of chars\r\n" + 
				"2. Print the words in a sentence\r\n" + 
				"3. Delete substring\r\n" + 
				"4. Replace substring\r\n" + 
				"5. Sort characters\r\n" + 
				"6. Hash code of a string");
		//Taking choice
		System.out.print("Please enter your menu choice: ");
		String choice = input.next();
		//If one choses to exit
		if(choice.equals("exit") || choice.equals("quit"))
			 continuity = false;
		else {
			 option = choice.charAt(0);
		    //I still don't know how to turn it into character
			 option -= 48;
		}
		switch(option) {
		//Counts number char in a string
		case 1:
			//Taking a string and a char 
			System.out.print("Enter an input string: ");
		String countChars = input.next();
		System.out.print("Enter an input char: ");
		String countChar = input.next();
		char c = countChar.charAt(0);
	   //Printing number of char
		System.out.println("The number of " + countChar + " in " + countChars +
	    		" is " + numOfChars( countChars,  c) + ".");
		break;
		//Printing words i a new line
		case 2:
		   System.out.print("Enter an input string: ");
		   String sntnc = scan.nextLine();
		   
		   
		   printWords( sntnc);
		   break;
		//Deleting a substring in a string
		case 3:
		  //Taking string
			System.out.print("Enter an input string: ");
		   String oldStr = scn.nextLine();
		   //Taking which substring is going to deleted
		   System.out.print("Enter a substring: ");
		   String delStr = dltdSbstr.nextLine();
		   System.out.print("Enter a type: ");
		   int type = input.nextInt();
		//Print new string
		System.out.println(delete( oldStr,  delStr,  type));
		
		break;
		//Replacing substring with another substring
		case 4:
			//Taking string
			System.out.print("Enter an input string: ");
			String replaceStr = scn.nextLine();
			//Taking which substring gonna replaced
			System.out.print("Enter the first substring: ");
			String replaceSubstr = scn.nextLine();
			//Which subtring gonna replace 
			System.out.print("Enter the second substring: ");
			String replaceSubStr2 = input.next();
			//Printing new string
			System.out.println(replace( replaceStr,  replaceSubstr,  replaceSubStr2));
		break;
		case 5:
			System.out.print("Enter an input string: ");
			String sort = scn.nextLine();
			System.out.print("Enter a type: ");
			int sorttype = input.nextInt();			
			System.out.println(sortChars( sort,  sorttype));
			
			break;
		//Finding hascode
		case 6:
		//Taking strig
			System.out.print("Enter an input string: ");
		String hash = scn.nextLine();
		//Taking value b
		System.out.print("Enter a value for b: ");
		int valueb = input.nextInt();
		//Printing hashcode
		System.out.println("The hash code for " + hash + " is " + hashCode( hash,  valueb) + "." );
			
			break;
		}
		}//Condition checker for loop
        while(continuity);
		//If one decides to exit
        System.out.print("Program ends. Bye :)");
		
		
	}
	//For case 1
	public static int numOfChars(String str, char ch) {
		int count = 0;
		/*Reads every char then
		 * Counts how many given char there are */
		for (int i = 0; i < str.length();i++) {
			if (str.charAt(i) == ch )
				count++;
		}
		//Returning count
		return count ;
	}
     //For case 2
	public static void printWords(String str) {
		//Incase of putting unnecesary spaces 
		str.trim();
		/*It checks every char and prints them or don't prints them or creates new line but
		 *  it doesn't work if there are word after banned characters */
		for(int i = 0; i < str.length(); i++) {
			char index = str.charAt(i);
			if(index == ',' || index == '.' || index == '!' || index == '(' || index == ')'
					|| index == '_' || index == '-' || index == '?' ) {
				i++;
			    i--;
			   if(index == '-' || index == '_') 
				   System.out.println();
			}
			else if (index == ' '  )
				System.out.println();
			else 
				System.out.print(index);
		
		}
		System.out.println();
		
	}
	//For case 3 
	public static String delete(String str, String subStr, int type) {
	//Type 0
		if(type == 0) {
			//Takes the substring till index
			String s1 = str.substring(0, str.indexOf(subStr));
			//Takes the substring after index
			String s2 = str.substring(str.indexOf(subStr) + subStr.length());
			 //Attach them
			str = s1 + s2;
		}
		//Same with type one but the delete all of them I added a loop
		else do {
			
			String s1 = str.substring(0, str.indexOf(subStr));
			String s2 = str.substring(str.indexOf(subStr) + subStr.length());
			 str = s1 + s2;
		
		}while(str.contains(subStr));
		
		return str;
	}
	
	//For case 4 technically does the same thing with case 3 just adds a string
	public static String replace(String str, String subStr1, String subStr2) {
		do {
			String s1 = str.substring(0, str.indexOf(subStr1));
			//Adding string
			s1 += subStr2;
			String s2 = str.substring(str.indexOf(subStr1)  + subStr1.length());
			str = s1 + s2;
		}while(str.contains(subStr1));
		
		return str;
		
	}
	//For case 5
	public static String sortChars(String str, int type) {
		//Declaering variable
		String sorted = "";
		//Array for type 0
		int[] chars = new int[str.length()];
		
		if(type == 0) {
			//Adding every char to array
			for(int i = 0; i < str.length();i++) {
				chars[i] = str.charAt(i);
			}
			//This loop is for taking an element and comparing it with every other elements in the array
			for(int i = 0; i < str.length() - 1; i++) {
				for(int j = 0; j < str.length() - 1 - i;j++) {
					//If elemnt is bigger swaps them
					if(chars[j] > chars[j + 1]) {
						int temp = chars[j];
						chars[j] = chars[j + 1];
						chars[j + 1] = temp;
					}
				}
			}
			for(int i = 0; i < str.length(); i++) {
				sorted += (char) chars[i];
			}
		}
		//Add chars in order
		else {
			for(int i = 0; i < str.length();i++) {
				chars[i] = str.charAt(i);
			}
			//This loop is for taking an element and comparing it with every other elements in the array
			for(int i = 0; i < str.length() - 1; i++) {
				for(int j = 0; j < str.length() - 1 - i;j++) {
					//If element is bigger swaps them
					if(chars[j] > chars[j + 1]) {
						int temp = chars[j];
						chars[j] = chars[j + 1];
						chars[j + 1] = temp;
					}
				}
			}
			//Checks for lower case
			for (int i = 0; i < str.length(); i++) {
				char index = (char)chars[i];
				if(index <= 'z' && index >= 'a' )
					sorted += index;
			}//Checks for capital
			for (int i = 0; i < str.length(); i++) {
				char index =  (char)chars[i];
				if(index <= 'Z' && index >= 'A' )
					sorted += index;	
			}//Checks for numbers
			for (int i = 0; i < str.length(); i++) {
				char index =  (char)chars[i];
				if(index <= '9' && index >= '0' )
					sorted += index;	
			}//Others
			for (int i = 0; i < str.length(); i++) {
				char index = (char)chars[i];
				if(!(index <= 'Z' && index >= 'A') && !(index <= '9' && index >= '0') && !(index <= 'Z' && index >= 'A')
						&& !(index <= 'z' && index >= 'a'))
					sorted += index;	
			}
		}
		
			
		return sorted;
	}
	//For case 6
	public static int hashCode(String str, int b) {
		//Declearing variable
		int hashCode = 0;
		for(int i = 0; i < str.length(); i++) {
			//Calculating hashcode
			hashCode += str.charAt(i) *(int) Math.pow(b, str.length() - (i + 1));
			
		}
		return hashCode;
	}
}
