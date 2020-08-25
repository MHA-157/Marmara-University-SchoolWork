//Muhammet Hasan Albayrak 150117053
import java.util.Scanner;
public class Pro1_150117053 {
    public static void main(String[] args){
      /*This code will find us the equation of the perpendicular 
       * bisector of the line segment between chosen two points
       */
    	//First we take first point with a user friendly way
    	Scanner input = new Scanner(System.in);
    	System.out.print("Enter the first point's coordinates as x and y: ");
    	double x1 = input.nextDouble();
    	double y1 = input.nextDouble();
    	//Taking the second point as the first one
    	System.out.print("Enter the second point's coordinates as the first one: ");
    	double x2 = input.nextDouble();
    	double y2 = input.nextDouble();
    	/*Then we find slope,midpoint, slope of the perpendicular bisector
    	 and constant by using mathematical formulas*/ 
    	double slope = (y2 - y1) / (x2 - x1);
    	double midpointx = (x1 + x2) / 2;
    	double midpointy = (y1 + y2) / 2;
    	double m = 0 - (1 / slope);
    	double constant = midpointy - (m * midpointx);
    	//We express the equation as y= mx + b
    	System.out.println("The equation of the perpendicular bisector of the line segment between "
    			+  "(" + x1 + "," + y1 + ")" + " and " + "(" + x2 + "," + y2 + ")" );
    	System.out.println("y = "+ m + "x + ( " +   constant + ")" );
    
    }
    }
    
