//Muhammet Hasan Albayrak 150117053
import java.util.Scanner;
public class Pro5_1_150117053 {
//Takes a number (N) from user, and rolls 10 fair six-sided dice.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Creating scanner
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to dice simulator program.");
		//Taking roll number
		System.out.print("Enter a value: ");
		int rolls = input.nextInt();
		//Creating array which we will keep our data
		int[] histogram = new int[61];
		//Rolling dices
		for(int i = 1; i <= rolls; i++) {
		int dice1 =	 (int)(Math.random() * 6 + 1);
		int dice2 =	 (int)(Math.random() * 6 + 1);
		int dice3 =	 (int)(Math.random() * 6 + 1);
		int dice4 =	 (int)(Math.random() * 6 + 1);
		int dice5 =	 (int)(Math.random() * 6 + 1);
		int dice6 =	 (int)(Math.random() * 6 + 1);
		int dice7 =	 (int)(Math.random() * 6 + 1);
		int dice8 =	 (int)(Math.random() * 6 + 1);
		int dice9 =	 (int)(Math.random() * 6 + 1);
		int dice10 = (int)(Math.random() * 6 + 1);
		//Storing data 
		histogram[dice1 + dice2 + dice3 + dice4 + dice5 + dice6 + dice7 + dice8 + dice9 + dice10 ]++;
		
		}
		//Printing histogram
     for(int i = 10; i <= 60; i++ ) {
    	 System.out.print(i + ":");
    	 for(int j = 0; j < histogram[i]; j++) {
    		 System.out.print("*");
    	 }
    	 System.out.println();
    	 
     }
	}

}
