//Muhammet Hasan Albayrak 150117053
/*This program takes a set of numbers seperated by dashes puts them in 2D array and then arranges them
 * according rule and how many steps user entered
 * o If a cell contains the value of ‘1’ in the first array, there are three rules to update its
value in the second array:
 If a cell has fewer than two ‘1’ neighbor cells, it is converted to ‘0’.
 If a cell has more than three ‘1’ neighbor cells, it is converted to ‘0’.
 If a cell has exactly two or three ‘1’ neighbor cells, it remains as ‘1’.
 If a cell contains the value of ‘0’ in the first array, the following rule applies to update
its value in the second array:
 If a cell has exactly three ‘1’ neighbor cells, it is converted to ‘1’.
 Otherwise, it remains as ‘0’.  */

import java.util.Scanner;
public class Pro5_2_150117053 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Creating scanner I made one for steps and one string
		Scanner string = new Scanner(System.in);
		Scanner step = new Scanner(System.in);
       System.out.println("Welcome to our program.");
       System.out.print("Enter a string: ");
       String numbers = string.next();
       System.out.print("Enter a number of steps: ");
       int steps = step.nextInt();
       //Variables for row size and column size
       int rowSize = 1;
       int columnSize = 1;
       //Variable for checking wrong input
       int maxNumber = 0;
       
       for(int i = 0; i < numbers.length(); i++) {
    	   if(numbers.charAt(i) == '-')
    		   rowSize++;
       }
       columnSize = rowSize;
       //Array for numbers in the string
       
       int[] numberArray = new int[rowSize];
       //Couln't get the last number so ý made this and line 54
       int j = 0;
       //Takes numbers in the string puts them in to  string
       while(numbers.contains("-")) {
    	String s1 = numbers.substring(0, numbers.indexOf('-'));
    	String s2 = numbers.substring(numbers.indexOf('-') + 1);
    	int number = Integer.parseInt(s1);
    	
    	numberArray[j] = number;
    	s1 = s2;
    	numbers = s2;
    	j++;
    }
       numberArray[j] = Integer.parseInt(numbers);
       
       //Finds the max number so can check for the error
       for(int i = 0; i < numberArray.length; i++) {
    	   if(numberArray[i] > maxNumber)
    		   maxNumber = numberArray[i];
    	   }
       //Checks if the input is wrong
       boolean check = true;
       if(maxNumber > Math.pow(2, rowSize) || maxNumber == Math.pow(2, rowSize) )
    	   check = false;
       //Loop for taking right input if the user enters wrong one does the same thing above
       while(!check) {
    	   System.out.println("The number " + maxNumber + " cannot be represented with " + 
       rowSize +"x" + columnSize + " array!");
    	   System.out.print("Enter a string: ");
            numbers = string.next();
           System.out.print("Enter a number of steps: ");
            steps = step.nextInt();
            rowSize = 1;
            columnSize = 1;
            maxNumber = 0;
           for(int i = 0; i < numbers.length(); i++) {
        	   if(numbers.charAt(i) == '-')
        		   rowSize++;
           }
           columnSize = rowSize;
            numberArray = new int[rowSize];
            j = 0;
           while(numbers.contains("-")) {
        	String s1 = numbers.substring(0, numbers.indexOf('-'));
        	String s2 = numbers.substring(numbers.indexOf('-') + 1);
        	int number = Integer.parseInt(s1);
        	
        	numberArray[j] = number;
        	s1 = s2;
        	numbers = s2;
        	j++;
        }
           numberArray[j] = Integer.parseInt(numbers);
           for(int i = 0; i < numberArray.length; i++) {
        	   if(numberArray[i] > maxNumber)
        		   maxNumber = numberArray[i];
        	   
           }
           if(maxNumber > Math.pow(2, rowSize))
        	   check = false;
      }
       //Creating first 2D array and turning numbers binary then putting them in array
       int[][] grid = new int[rowSize][columnSize];
       for(int i = 0; i < rowSize; i++) {
    	   for(int k = 0; k < columnSize; k++) {
    		 int  number = numberArray[i];
    		   grid[i][k] = convertDectoB(number,columnSize)[k];
    		   
    	   }
       }
       //Printing first array
       printGrid( grid,  rowSize,  columnSize);
       //Creating second 2D array
       int[][] secondGrid = new int[rowSize][columnSize];
       //Checks every cell and Fills second array according to rule
       int count1 = 0;
      for(int c = 0; c < steps; c++) {
    	 //Copying second array to first array
    	  if(!(c == 0)) {
    		  for(int h = 0; h < rowSize; h++) {
    			  for (int m = 0; m < columnSize; m++) {
    				  grid[h][m] = secondGrid[h][m];
    			  }
    		  }
    	  }
       for( int i = 0; i < rowSize; i++) {
    	   for(int s = 0; s < columnSize; s++) {
    		   //Counter for neighbors
    		   count1 = 0;
    		  //First taking corners since they have 3 neighbors and there are four of them
    		   if((i == 0 && s == 0)  ) {
    			  if( grid[i][s + 1] == 1)
    				  count1++;
    				
    					
    			  if(grid[i + 1][s + 1] == 1)
    				  count1++;
    			  
    				  
    			  if(grid[i + 1][s] == 1)
    				  count1++;
    			 //Changes cell 
    			  secondGrid[i][s] = change(grid[i][s], count1);
    				  
    		   }
    		   else if( (i == rowSize - 1 && s == 0)) {
    			   if( grid[i][s + 1] == 1)
     				  count1++;
     				
     					
     			  if(grid[i - 1][s + 1] == 1)
     				  count1++;
     			  
     				  
     			  if(grid[i - 1][s] == 1)
     				  count1++;
     			
     			 secondGrid[i][s] = change(grid[i][s], count1);
    		   }
    		   else if( i == 0 && s == columnSize -1){
    			   if( grid[i ][s - 1] == 1)
     				  count1++;
     				
     					
     			  if(grid[i + 1][s - 1] == 1)
     				  count1++;
     			  
     				  
     			  if(grid[i + 1][s ] == 1)
     				  count1++;
     			 secondGrid[i][s] = change(grid[i][s], count1);
    		   }
    		   else if( (i == rowSize - 1 && s == columnSize -1)) {
    			  
    			   if( grid[i - 1][s ] == 1)
      				  count1++;
      				
      					
      			  if(grid[i - 1][s - 1] == 1)
      				  count1++;
      			  
      				  
      			  if(grid[i ][s - 1] == 1)
      				  count1++;
      			secondGrid[i][s] = change(grid[i][s], count1);
    		   }
    		   //Then taking sides they have 5 neighbors there are four of them
    		   else if(i == 0) {
    			   if(grid[i][s - 1] == 1)
    				   count1++;
    			   
    			   if(grid[i + 1][s - 1] == 1)
    				   count1++;
    			   
    			   if(grid[i + 1][s] == 1)
    				   count1++;
    			   
    			   if(grid[i + 1][s + 1] == 1)
    				   count1++;
    			   
    			   if(grid[i][s + 1] == 1)
    				   count1++;
    			   
    			   secondGrid[i][s] = change(grid[i][s], count1);
    		   }
    		   else if(s == rowSize - 1) {
    			   if(grid[i - 1][s ] == 1)
    				   count1++;
    			   
    			   if(grid[i - 1][s - 1] == 1)
    				   count1++;
    			   
    			   if(grid[i ][s - 1] == 1)
    				   count1++;
    			   
    			   if(grid[i + 1][s - 1] == 1)
    				   count1++;
    			   
    			   if(grid[i + 1][s ] == 1)
    				   count1++;
    			  
    			   secondGrid[i][s] = change(grid[i][s], count1);
    		   }
    		   else if(i == rowSize - 1) {
    			   if(grid[i ][s + 1 ] == 1)
    				   count1++;
    			   
    			   if(grid[i - 1][s + 1] == 1)
    				   count1++;
    			   
    			   if(grid[i - 1][s ] == 1)
    				   count1++;
    			   
    			   if(grid[i - 1][s - 1] == 1)
    				   count1++;
    			   
    			   if(grid[i ][s - 1] == 1)
    				   count1++;
    			  
    			   secondGrid[i][s] = change(grid[i][s], count1);
    		   }
    		   else if(s == 0) {
    			   if(grid[i + 1][s  ] == 1)
    				   count1++;
    			   
    			   if(grid[i + 1][s + 1] == 1)
    				   count1++;
    			   
    			   if(grid[i ][s + 1] == 1)
    				   count1++;
    			   
    			   if(grid[i - 1][s + 1] == 1)
    				   count1++;
    			   
    			   if(grid[i - 1 ][s ] == 1)
    				   count1++;
    			  
    			   secondGrid[i][s] = change(grid[i][s], count1);
    		   }
    		   //Rest of the cells have 8 neighbors
    		   else {
    			   if(grid[i + 1][s] == 1)
    				   count1++;
    			   
    			   if(grid[i + 1][s + 1] == 1)
    				   count1++;
    			   
    			   if(grid[i ][s + 1] == 1)
    				   count1++;
    			   
    			   if(grid[i - 1][s + 1] == 1)
    				   count1++;
    			   
    			   if(grid[i - 1 ][s ] == 1)
    				   count1++;
    			   
    			   if(grid[i  - 1][s - 1] == 1)
    				   count1++;
    			   
    			   if(grid[i ][s - 1] == 1)
    				   count1++;
    			   
    			   if(grid[i + 1 ][s - 1 ] == 1)
    				   count1++;
    			   
    			   secondGrid[i][s] = change(grid[i][s], count1);
    			   
    		   }
    	   }
       }
       System.out.println();
     //Printing table after every step
       System.out.println("It is converted to the following table after " + (c + 1) + " step");
     
     printGrid( secondGrid,  rowSize,  columnSize);
      System.out.println();
      
	}
      //Printing decimal values of the last table
      System.out.print("The decimal value for the second table after " + steps + " steps: ");
      //Variable for evaluating every row
      int number = 0;
      //Turns table into decimal
    	for(int i = 0; i < numberArray.length; i++) {
    		number = 0;
    		
    		for( j = 0; j < columnSize; j++) {
    		
    			 if(secondGrid[i][j] == 1)
    			number += (int) Math.pow(2, columnSize - 1 - j  );
    			
    		}
    		numberArray[i] = number;
    	}
    	//Printing decimal numbers
    	for(int i = 0; i < numberArray.length; i++) {
    		System.out.print(numberArray[i]);
    		if(!(i == numberArray.length - 1))
    			System.out.print("-");
    	}
    	 
	}
	//Method for changing binary to decimal puts binary forms into 1D array
	public static int[] convertDectoB(int number, int size) {
		int binaryForm[] = new int[size];
		int returnForm[] = new int[size];
		int zeroOne = 0;
		while(number > 0){
	       binaryForm[zeroOne++ ] = number % 2;
	       number = number / 2;
	
		}
	   for(int i = 0; i < size; i++) {
		   returnForm[size - i - 1] = binaryForm[i];
		   
	   }
	   
	     
	   return returnForm;
}
	//For printing tables
    public static void printGrid(int[][] grid, int rows, int columns) {
    	for(int i = 1; i <= rows ; i++) {
    		for(int k = 0; k < columns * 4 + 1; k++) {
    			System.out.print("-");
    		}
    		System.out.println();
    		for(int j = 1; j <= columns ; j++) {
    			System.out.print(j != columns ? "| " + grid[i - 1][j - 1] + " " :
    				"| " + grid[i - 1][j - 1] + " |" );
    		}
    		System.out.println();
    	}
    	for(int k = 0; k < columns * 4 + 1; k++) {
			System.out.print("-");
		}
    	
    }
    //Takes cell value then sends the new cell value
    public static int change(int cell,  int one) {
    	//If cell is 1
    	if(cell == 1) {
    		if(one < 2)
    			cell = 0;
    		else if(one > 3)
    			cell = 0;
    		else if(2 == one && one == 3)
    			cell = 1;
    			
    			
    	}
    	//If cell is 0
    	else {
    		if(one == 3)
    			cell = 1;
    	}
    	
    	return cell;
    }
   
}
