//Muhammet Hasan Albayrak 150117053
import java.util.Scanner;
public class Pro2_150117053 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        /*This code will find us value of the account for six months, 
         * the total value saved and the total profit
         */
		
		Scanner input = new Scanner(System.in);
  //Taking first month's salary
    System.out.print("Please enter your mountly salary, for example 1600:");
    float monthlysalary = input.nextFloat();
    //Taking percent of the salary to be saved
    System.out.print("Please enter the percent of your salary to save, for example 10:");
    float savedrate = input.nextFloat();
   //Taking government support on account
    System.out.print("Please enter monthly goverment support:");
    float interestrate = input.nextFloat();
    //Taking interest rate on account
    System.out.print("Please enter the interest rate:");
   float governmentsup = input.nextFloat();
   //Computing account value for six months
   double savedamount = (monthlysalary * savedrate) / 100.0;
   double firstmonth = savedamount * (1 + interestrate / 100.0) * (1 + governmentsup / 100.0);
   double secondmonth = ( firstmonth + (monthlysalary * savedrate / 100.0) * (1 + interestrate / 100.0)) * ( 1 + governmentsup / 100.0);
   double thirdmonth = (secondmonth   + (monthlysalary * savedrate / 100.0) * (1 + interestrate / 100.0)) * (1 + governmentsup / 100.0);
   double fourthmonth = (thirdmonth + (monthlysalary * savedrate / 100.0) * (1 + interestrate / 100.0)) * (1 + governmentsup / 100.0);
   double fifthmonth = (fourthmonth + (monthlysalary * savedrate / 100.0) * (1 + interestrate / 100.0)) * (1 + governmentsup / 100.0);
   double sixthmonth = (fifthmonth + (monthlysalary * savedrate / 100.0) * (1 + interestrate / 100.0)) * (1 + governmentsup / 100.0);
   
   //Expressing account value for six months
   System.out.println("After the first month, the account value is " + (int)(firstmonth * 100) / 100.0);

   System.out.println("After the second month, the account value is " + (int)(secondmonth * 100) / 100.0 );

   System.out.println("After the third month, the account value is " + (int)(thirdmonth * 100) / 100.0);

   System.out.println("After the fourth month, the account value is " + (int)(fourthmonth * 100) / 100.0);

   System.out.println("After the fifth month, the account value is " + (int)(fifthmonth * 100) / 100.0);

   System.out.println("After the sixth month, the account value is " + (int)(sixthmonth * 100) / 100.0);
    
   double totalsaved = monthlysalary * 6 * savedrate / 100.0;
   double totalprofit = sixthmonth - totalsaved;
   System.out.println("In total, you saved " + (int)(totalsaved * 100) / 100.0 + "TLs" + " and your total profit is " + (int)(totalprofit * 100) / 100.0 + "TLs");
       
	}

}
