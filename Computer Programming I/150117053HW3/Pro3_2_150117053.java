import java.util.Scanner;
public class Pro3_2_150117053 {
//Muhammet Hasan Albayrak
	/*This code is for printing letters of "W", "X", "Z" and "Y" withs stars   */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println("Welcome to letter printer program.");
//Declearing needed variables
int size;
int condition = 0;
char repeat1 = 'Y';
	 Scanner input = new Scanner(System.in);
	//Variable for letter checking
	 int a;
	 // Outer Loop for doing printing again
	 do {
	//Taking print size
		 System.out.print("Enter the size: ");
	  size = input.nextInt();
	  //Checking print size
	  if(size < 5 || size % 2 == 0 || size < 0)
		  do { 
		  System.out.print("Invalid size. Enter the size again: ");
		  size = input.nextInt();
	}while(size < 5 || size % 2 == 0 || size < 0);
		//Taking the letter
	  System.out.print("Enter the letter: ");
	  String letter = input.next();
	char letterChar = letter.charAt(0);
	//Taking letters for each case then declearing them and checking them
	if (letterChar == 'X' ) {
		letterChar = 'X';
		condition = 1;}
	else if (letterChar == 'Y') {
		letterChar = 'Y';
		condition = 2;}
	else if (letterChar == 'W') {
		letterChar = 'W';
		condition= 3;}
	else if (letterChar == 'Z') {
		letterChar = 'Z';
		condition = 4;}
	else {
	  //Loop for taking the rigth letter
		do { a = 0;
		System.out.print("Invalid letter: Enter the letter again: ");
		letter = input.next();
		 letterChar = letter.charAt(0);
		if (letterChar == 'X' ) {
			letterChar = 'X';
			condition = 1;
			}
		else if (letterChar == 'Y') {
			letterChar = 'Y';
			condition = 2;}
		else if (letterChar == 'W') {
			letterChar = 'W';
			condition = 3;}
		else if (letterChar == 'Z') {
			letterChar = 'Z';
			condition = 4;}
		//Look line 14
		else a = 5;
	}while(a == 5);
	}
	 //Cases for each letter
	 switch (condition) {
	 case 1:
		 //Loops for upper part of "X" used patterns of this week's lab 11/16
		/*Outer loop for new lines I am halfing the size because it's 
		 only upper part basically printsan V*/
		 for(int i = 0; i <= size / 2; i++) {
			//inner loop printing stars (left aligned)
			 for(int j = 0; j <= size / 2; j++) 
				 System.out.print(i == j ?    "*" :  " ");
				/*Second inner loop for printing stars(right aligned) 
				 * minus one otherwise prints two stars in 
			 middle*/
			 for(int j = (size / 2) - 1; j >= 0; j--)
	    			System.out.print(j == i ?   "*" : " ");
			 System.out.println();
			 
			   
		 //Loops for lower part of "X" prints upside down V with out top so i and j are 1
			 /*Outer loop for new lines  */
	 } for(int i = 1; i <= size / 2;i++) {
 		//Ýnner loop for printing stars (right aligned)
		 for(int j = size / 2; j >= 0;j--)
			System.out.print(j == i ? "*"  : " ");
 		
		 /*Second inner loop for printing stars(left aligned) 
			 */
		for(int j = 1; j <= (size / 2) ; j++) 
			 System.out.print(i == j ?  "*" : " ");
		System.out.println();
	 }break;
	 
	 case 2:
		 //Loop for printing an V without bottom same as "X"
		 for(int i = 0; i <= size / 2; i++) {
			 for(int j = 0; j <= size / 2; j++) 
				 System.out.print(i == j ?    "*" :  " ");
				
			 for(int j = (size / 2) - 1 ; j >= 0; j--)
	    			System.out.print(j == i ?   "*" : " ");
			 System.out.println();
			
		 }//Loop for it's tail
		 for(int i = ( size / 2)  ; i <= size - 2  ;i++  ) {
			 for(int j = 0; j <= (size - 1 )  ; j++)
				 System.out.print(size / 2 == j ? "*" : " ");
			 System.out.println();
			 
		 }
		 
		 break;
	 case 3:
		 for(int i = 0; i <= size ; i++) {
			 for(int j = 0; j <= size ; j++) 
				 System.out.print(i == j ?    "*" :  " ");
			 for(int j = size - 1  ; j >= 0; j--)
	    			System.out.print(j == i ?   "*" : " ");
			
		
			 System.out.println();
			 
		 
		 
			 
		 }
		 
				
				/*for(int j = 1; j <= size - 1   ; j++) 
					 System.out.print(i == j  ?  "*" : " ");
				System.out.println();*/
			 break;
	 case 4://Loop for "Z" first a block of stars
		 for(int i = 1; i<= 1; i++) {
	    	  for(int j = 1; j <= size;j++ )
	    		  System.out.print( "*");
	    	  
	      }//Loop for it's middle
		 for(int i = 1; i <= size ; i++) {
			 //Loop for to make its right aligned
			 for(int j = size ; j >=0  ; j--) 
				//Because it's middle part trimming first and the last star
				 if(!(i == size))
				 System.out.print(i == j && i != 1 ?  "*" :  " ");
			//Because lower part must be right under the middle part
			 if(!(i == size))
			 System.out.println();
		 }//Loop for lower block of stars
		 for(int i = 1; i<= 1; i++) {
	    	  for(int j = 1; j <= size;j++ )
	    		  System.out.print( "*");
	    	  System.out.println();
		 }break;
	 }//Asking for a redo
	 System.out.print("Would you like to continue? (Y or N): ");
	 String repeat = input.next();
	  repeat1 = repeat.charAt(0);
	 }//While part of first do
	 while(repeat1 == 'Y');

}
	}
