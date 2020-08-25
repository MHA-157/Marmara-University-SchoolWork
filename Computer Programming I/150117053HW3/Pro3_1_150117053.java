import java.util.Scanner;
public class Pro3_1_150117053 {
//Muhammet Hasan Albayrak
	/*Taking a   encrypted string and turning it into an image
	 * "n" for newline, "b" for blank space, "s" for star(*).  */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Scanner input = new  Scanner(System.in);
		System.out.println("Welcome to image printer program.");
		//Taking the string
		System.out.print("Please enter your sequence: ");
		String encriptedImage = input.next();
		//Declearing variables
		int indexCase = 0;
		int n = 49;
		int j = 0;
	
	
		String image = "";
		//Outer loop for execution time
		for (int k = 0; k < encriptedImage.length()  ;k++  ) {
			//Taking every char by one by
		char index = encriptedImage.charAt(k);
	//Classifyng chars
		if (index == 'b')
		 indexCase = 1;
		else if (index == 's')
			indexCase = 2;
		else if(index == 'n')
			indexCase = 3;
	//Ýf the char is number
		  if( 49 <= index && index <= 58) {
			  n = (char)index; 
			  indexCase = 0;
		  }
		  
		// j is 49 because ý could'nt turn n into it's digit value	  
		j = 49;
		/*Cases for each char
		 * Do'nt have a case for digit because every digit is for char after it
		 * So that way n doesnt get itself reset
		 * and resetting n after every char*/
		switch (indexCase) {
		case 1:
			while (j <= n) {
				image += " ";
				j++;
			}n = 49;
			break ;
		case 2:
			while (j <= n) {
				image += "*";
				j++;
			}n = 49;
			break;
		case 3 :
			while (j <= n ) {
				
				image += "\n";	
				j++;
			}n = 49;
			break;
			
		
		}
	
		
		}
		//Printing the the image got decoded
		System.out.println(image);
	}

}
