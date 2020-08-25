/*                  Muhammet Hasan ALBAYRAK 150117053     PROJECT1 CSE 2138 
 * ************************************* DATA CONVERTER**************************************************/

//Converts  floating signed and unsigned into hexa then byte orders
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class CSE2038Pro1 {
  public static int  floatingPointSize;
  public static String byteOrder;
  public static int floatNumber;
  public static String out = "";
  //public static File output = new File("output.txt");
 // public static FileWriter fr = null;
  
  
	public static void main(String[] args) throws IOException {
		//Flag for its type
		char flag = ' ';
		//output.createNewFile();
		File output = new File("output.txt");
		FileWriter fr = null;
		fr = new FileWriter(output);
		Scanner scanner  = new Scanner(System.in);
		System.out.println("Please enter absoulute path of input.");
		String input = scanner.nextLine();
		System.out.println("Byte ordering:");
		byteOrder = scanner.nextLine();
		System.out.println("Floating point size:");
		floatingPointSize = scanner.nextInt();
		//Reading file char by char
		File file = new File(input);
		BufferedReader reader = new BufferedReader(new FileReader(file));  
		String number = "";
		int c;   
		char sign = 'p';
		while ((c = reader.read()) != -1) {
			if(!(c <= 57 && c >= 48)) {
				if((char)c == '-')
					sign = 'n';
				
				if((char)c != '\n' && (char)c != '\r')
				flag = (char)c;
				
			}
				
				
			if((char)c != '\n' && (char)c != '\r') {
				number += (char)c;
			}
				
			//System.out.println(c);
			else {
				converter(number, flag, sign);
				sign = 'p';
				//System.out.println(number);
				number = "";
				flag = ' ';
			}
			 
			
		}
		        
		  
		  fr.write(out);  
		 
		  fr.close();
	}
	//Takes the number flag and it's sign
	public static void converter(String number, char flag, char sign) {
		if(number.length() == 0) {
			return;
		}
			
					
		switch(flag) {
		case '-':
			//Deleting "-" sign
			if(sign == 'n')
			number = number.substring(1, number.length());
			
			decTobinTC(number, sign);
			break;
			
		case '.':
			//Deleting "-" sign
			if(sign == 'n')
				number = number.substring(1, number.length());
			
			decTobinFP(number, sign);
			break;
		case 'u': //Deleting "u"
			number = number.substring(0, number.length() - 1);
			decTobinU(number);
			break;
		case ' ':
			decTobinU(number);
			break;
		}
	}
	//Divides betwwen different bytes
	public static void decTobinFP(String number, char sign) {
		String fpn = "";
		int bin[] = new int[floatingPointSize *  8 ];
		switch(floatingPointSize) {
		case 1:
			fpn = (pointSplitter(number, sign));
			//Turns it into array for hexa converter
			for(int i = 0; i < 8; i++) {
				bin[i] = (char)(fpn.charAt(i)) - 48;
			}
			
			binTohex(bin);
			break;
			
			
		case 2:
			fpn = (pointSplitter(number, sign));
			//Turns it into array for hexa converter
			for(int i = 0; i < 16; i++) {
				bin[i] = (char)(fpn.charAt(i)) - 48;
			}
			
			binTohex(bin);
			break;
			
		case 3:
			fpn = (pointSplitter(number, sign));
			//Turns it into array for hexa converter
			for(int i = 0; i < 24; i++) {
				bin[i] = (char)(fpn.charAt(i)) - 48;
			}
			
			binTohex(bin);
			break;
			
		case 4:
			fpn = (pointSplitter(number, sign));
			//Turns it into array for hexa converter
			for(int i = 0; i < 32; i++) {
				bin[i] = (char)(fpn.charAt(i)) - 48;
			}
			
			binTohex(bin);
			break;
		}
	}
	//Splits FPN between it's part 
	public static String pointSplitter(String number, char sign) {
		int index;
		int i = 0;
		for( i = 0; i < number.length(); i++) {
			if(number.charAt(i) == '.' ) {
				index = i;
				break;
			}
		
		}
		
		String splitted = decToBin(number.substring(0, i)) + mantissa(number.substring(i + 1, number.length()));
		String mantissa = splitted.substring(1, splitted.length());
		splitted = exponent() + mantissa;
		if(sign == 'p')
			splitted = "0" + splitted;
		else
			splitted = "1" + splitted;
		
		return splitted;
	}
	//Calculates exp part
	public static String exponent() {
		String array = "";
		
		switch(floatingPointSize) {
		case 1:
			int[] bin = new int[4];
			int index = 0;
			int dec = 7 + floatNumber;
			while(dec > 0) {
				bin[index++] = dec % 2;
				dec = dec / 2;
			}
			for(int i = 0; i < bin.length; i++) {
				array += bin[i];
			}
			int[] revbin = new int[8];
			int k = 8;
			for(int j = 0; j < bin.length; j++) {
				revbin[k - 1] = bin[j];
				k--;
			}
			return array;
			
			
		case 2:
			
			int[] bin2 = new int[6];
			 index = 0;
			 dec = 31 + floatNumber;
			while(dec > 0) {
				bin2[index++] = dec % 2;
				dec = dec / 2;
			}
			
			int[] revbin2 = new int[8];
			int l = 6;
			for(int j = 0; j < bin2.length; j++) {
				revbin2[l - 1] = bin2[j];
				l--;
			}
			for(int i = 0; i < bin2.length; i++) {
				array += bin2[i];
			}
			return array;
			
			
		case 3:
			
			int[] bin3 = new int[8];
			
			 index = 0;
			 dec = 127 + floatNumber;
			while(dec > 0) {
				bin3[index++] = dec % 2;
				dec = dec / 2;
			}
			
			int[] revbin3 = new int[8];
			int m = 8;
			for(int j = 0; j < bin3.length; j++) {
				revbin3[m - 1] = bin3[j];
				m--;
				
			}
			for(int i = 0; i < bin3.length; i++) {
				array += revbin3[i];
			}
			return array;
			
			
		case 4:
			
			int[] bin4 = new int[8];
			 index = 0;
			 dec = 127 + floatNumber;
			while(dec > 0) {
				bin4[index++] = dec % 2;
				dec = dec / 2;
			}
			
			int[] revbin4 = new int[8];
			//bin4 = reverse(bin4, 8);
			
			int n = 8;
			for(int j = 0; j < bin4.length; j++) {
				revbin4[n - 1] = bin4[j];
				n--;
			}
			for(int i = 0; i < bin4.length; i++) {
				array += revbin4[i];
			}
			return array;
			
		}
		return "";
		
	}
	
	
	
	
	//Turns the part before point into binary
	public static String decToBin(String number) {
		int[] bin = new int[16];
		int[] revbin = new int[16];
		int index = 0;
		int dec = Integer.parseInt(number);
		while(dec > 0) {
			bin[index++] = dec % 2;
			dec = dec / 2;
		}
		floatNumber = index - 1;
		
		//bin = reverse(bin, bin.length);
		int k = 16;
		for(int j = 0; j < bin.length; j++) {
			revbin[k - 1] = bin[j];
			k--;
		}
		String s = "";
		for(int i = 0; i < bin.length; i++) {
			s += bin[i];
		}
	    //System.out.println(s);
	    int d = Integer.parseInt(s.substring(0, s.length() - 8));
	    ///System.out.println(s);
	    //System.out.println(d);
		d /= Math.pow(10, 8 - index) ;
	    
	   // System.out.println(d);
		return Integer.toString(d);
	}
	
	
	//Calculates manttisa
	public static String mantissa(String number) {
		double mantissa = Double.parseDouble("0." + number);
		String mnts = "";
		switch(floatingPointSize) {
		case 1:
			for(int i = 0; i < 3; i++) {
				mantissa *= 2;
				mnts +=  Integer.toString((int)(mantissa));
				
				if(mantissa >= 1)
					mantissa--;
				
			}
			break;
			
		case 2:
			for(int i = 0; i < 9; i++) {
				mantissa *= 2;
				mnts +=  Integer.toString((int)(mantissa));
				
				if(mantissa >= 1)
					mantissa--;
				
			}
			break;
			
		case 3:for(int i = 0; i < 23; i++) {
			mantissa *= 2;
			mnts +=  Integer.toString((int)(mantissa));
			
			if(mantissa >= 1)
				mantissa--;
			
		}
			
			break;
			
		case 4:
			for(int i = 0; i < 23; i++) {
				mantissa *= 2;
				mnts +=  Integer.toString((int)(mantissa));
				
				if(mantissa >= 1)
					mantissa--;
				
			}
			
			break;
		}
		
		return mnts.toString();
		
	}
	
	public static void decTobinTC(String number, char sign) {
		if(sign == 'p') {
			decTobinU(number);
			return;
		}
			
		
		int[] bin = new int[16];
		int index = 0;
		int dec = Integer.parseInt(number);
		while(dec > 0) {
			bin[index++] = dec % 2;
			dec = dec / 2;
		}
		for(int i = 0; i < bin.length; i++)
			bin[i] = (bin[i] + 1) % 2;
		int i = 0;
		while(bin[i] + 1 == 0 ) {
			bin[i] = 0;
			i++;
		}
			bin[i] = 1;
			bin[15] = 1;
		binTohex(bin);
		
	}
	
	public static void decTobinU(String number) {
		int[] bin = new int[16];
		int index = 0;
		int dec = Integer.parseInt(number);
		while(dec > 0) {
			bin[index++] = dec % 2;
			dec = dec / 2;
		}
		binTohex(bin);
		
	}
	//Hexa converteer for bin
	public static void binTohex(int[] bin) {
		String hex = "0x";
		int counter = 0;
		//s
		int numGrp = 0;
		for(int i = bin.length - 1; i >=0; i-- ) {
			
			if(bin[i] != 0)
			numGrp += Math.pow(2, i % 4);
			
			counter++;
			
			if((counter % 4 == 0 && counter > 0)) {
				counter = 0;
				if(numGrp < 10) {
					hex += Integer.toString(numGrp);
					numGrp = 0;
				}
					
				else {
					switch(numGrp % 10) {
					case 0:
						hex += "A";
						break;
					case 1:
						hex += "B";
						break;
					case 2:
						hex += "C";
						break;
					case 3:
						hex += "D";
						break;	
					case 4:
						hex += "E";
						break;
					case 5:
						hex += "F";
						break;
					
					}
					numGrp = 0;
				}
			}
			
			
		}
		try {
			printOrder(hex);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//Orders them according to input
	public static void printOrder(String hex) throws IOException {
		
		String ordered = hex.substring(2, hex.length());
		switch(byteOrder) {
		case "Little Endian":
			for(int i = ordered.length(); i >=  2; i -= 2 ) {
				out += (ordered.substring(i - 2, i ) + " ");
			}
			break;
			
		case "Big Endian":
			for(int i = 0; i <= ordered.length() - 2; i += 2 ) {
				out += (ordered.substring(i, i + 2) + " ");
			}
			break;
		}
		
		
		out += ("\n"
				);
	}
}
