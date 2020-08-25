

import java.util.Scanner;

//  Muhammet Hasan Albayrak 150117053
public class HW2_150117053 {
   
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     //Welcoming customer
		System.out.println("Welcome Marmara Cars");
     
     System.out.println("---------------------------");
     
     //Showing range of cars
     System.out.println("Compact  (C) \n"
     		+ "Luxury  (L) \n"
     		+ "Midsize  (M) \n"
     		+ "Pickup  (P) \n"
     		+ "SUV    (S)");
     //Taking customers choice of car
     System.out.print("What model of car  do you want (C, L, M, P, S,): ");
     Scanner input = new Scanner(System.in);
     String Chosedcar = input.next();
     char Chosedoption = Chosedcar.charAt(0);
     
     //Creating switch status values
    int status = 1;
    if (Chosedoption == 'C' || Chosedoption == 'c') 
    	 status = 5 - 4;
    
    else if(Chosedoption == 'L' || Chosedoption == 'l') 
    	status = 2;
    	
    else if ( Chosedoption == 'M' || Chosedoption == 'm')
    	status = 3;
    else if (Chosedoption == 'P' || Chosedoption == 'p')
    	status = 4;
    else if (Chosedoption == 'S' || Chosedoption == 's')
    	status = 5;


    
    
    
    
    
    
    //Switch status for choices one case for each car
    switch (status) {
    case 1 :
    	//Creating needed car variables
    	float totalcostC = 0;
    	float compactsprice = 16000;
    	float additionalcostC = 0;
    	float SalesTaxC = 0;
    	
    	//Taking additional choices
    	System.out.print("Do you want protective undercoating for 125$ (Y/N)?");
    	String yesornoC = input.next();
    	char REALyesornoC = yesornoC.charAt(0); 
    	
    	if (REALyesornoC == 'Y' || REALyesornoC == 'y') 
    		additionalcostC += 125;
    	//Taking additional choices
    	System.out.print("Do you want the security package for $800 (Y/N)");
    	String yesornoC1 = input.next();
    	char REALyesornoC1 = yesornoC1.charAt(0);
    	
    	if (REALyesornoC1 == 'Y' || REALyesornoC1 == 'y') 
    		additionalcostC += 800;
    	//Calculating cost without taxes
    	totalcostC = compactsprice + additionalcostC;
    	
    	//Calculating cost with taxes
    		totalcostC += (compactsprice + additionalcostC)  *35 / 100;
    	totalcostC += totalcostC * 18  /100;	
    	//Calculating tax	
    	SalesTaxC = totalcostC - (compactsprice + additionalcostC);
    		//Showing customer what they bought
    	System.out.println("\n");
    	System.out.println("You ordered a compact car with a base price of " + compactsprice  + "$");	
    	System.out.println("Your additional cost is " + additionalcostC + "$");
    	System.out.println("Sales Tax: " + SalesTaxC + "$");
    	System.out.println("Total cost of car & options: " + totalcostC + "$");
    		
    		break;
    	
    case 2 :
    	//Creating needed variables
    	float totalcostL = 0;
    	float luxurysprice = 39000 ;
    	float additionalcostL = 0;
    	float SalesTaxL = 0;
    	
    	//Taking additional choices
    	System.out.print("Do you want protective undercoating for 125$ (Y/N)? ");
    	String yesornoL = input.next();
    	char REALyesornoL = yesornoL.charAt(0);
    	
    	
    	if (REALyesornoL == 'Y' || REALyesornoL == 'y' )
    		additionalcostL += 125;
    	
    	//Taking additional choices
    	System.out.print("Do you want the multimedia package for 1250$ (Y/N)? ");
    	String yesornoL1 = input.next();
    	char REALyesornoL1 = yesornoL1.charAt(0);
    	
    	if(REALyesornoL1 == 'Y' || REALyesornoL1 == 'y')
    		additionalcostL += 1250;
    	
    	//Checking if customer can get the 5% off
    	if ((REALyesornoL == 'Y' || REALyesornoL == 'y') && (REALyesornoL1 == 'Y' || REALyesornoL1 == 'y') )
    		additionalcostL -= additionalcostL * 5 / 100;
    	//Calculating cost without tax
    	totalcostL = luxurysprice + additionalcostL;
    	//Calculating tax
    	totalcostL += (luxurysprice + additionalcostL) * 40 / 100;
    	totalcostL += totalcostL * 18 / 100;
    	
    	SalesTaxL = totalcostL - (luxurysprice + additionalcostL);
    	
    	System.out.println("\n");
    	
    	//Showing customer what bought
    	System.out.println("You ordered a luxury car with a base price of " + luxurysprice + "$");
        System.out.println("Your additional cost is " + additionalcostL + "$");
    	System.out.println("Sales Tax: " + SalesTaxL + "$");
    	System.out.println("Total cost of car & options: " + totalcostL + "$");
    	break;
    	
    case 3 :
    	//Creating needed variables
    	float totalcostM = 0;
    	float midsizesprice = 26000 ;
    	float additionalcostM = 0;
    	float SalesTaxM = 0;
    	//Taking additional choices
    	System.out.print("Do you want protective undercoating for 125$ (Y/N) ");
    	String yesornoM = input.next();
    	char REALyesornoM = yesornoM.charAt(0);
    	   
    	
    	if (REALyesornoM == 'Y' || REALyesornoM == 'y')
    		additionalcostM += 125;
    	 
    	//Taking additional choices
    	System.out.print("Do you like to replace the normal transmission by an automatic transmission\r\n" + 
    			"for 2000$ (Y/N) ");
    	String yesornoM1 = input.next();
    	char REALyesornoM1 = yesornoM1.charAt(0);
    	   
    	
    	if (REALyesornoM1 == 'Y' || REALyesornoM1 == 'y')
    		additionalcostM += 2000;
    	
    	//Taking additional choices
    	System.out.print("Do you want sunroof for 1500$ (Y/N) ");
    	String yesornoM2 = input.next();
    	char REALyesornoM2 = yesornoM2.charAt(0);
    	   
    	
    	if (REALyesornoM2 == 'Y' || REALyesornoM2 == 'y')
    		additionalcostM += 1500;
    	
    	//Taking additional choices
    	System.out.print("Do you want the multimedia package for 750$ (Y/N) ");
    	String yesornoM3 = input.next();
    	char REALyesornoM3 = yesornoM3.charAt(0);
    	   
    	
    	if (REALyesornoM3 == 'Y' || REALyesornoM3 == 'y')
    		additionalcostM += 750;
    	
    	//Taking additional choices
    	System.out.print("Do you want the security package for 1000$ (Y/N) ");
    	String yesornoM4 = input.next();
    	char REALyesornoM4 = yesornoM4.charAt(0);
    	   
    	
    	if (REALyesornoM4 == 'Y' || REALyesornoM4 == 'y')
    		additionalcostM += 1000;
    	//Taking additional choices
    	System.out.print("Do you want the sports package for an increased 5.0% This will increase your " + 
    			"cost by " + (midsizesprice * 5 / 100) + " (Y/N) ");
    	String yesornoM5 = input.next();
    	char REALyesornoM5 = yesornoM5.charAt(0);
    	   
    	//Adding 5% sports choice
    	if (REALyesornoM5 == 'Y' || REALyesornoM5 == 'y')
    		additionalcostM += (midsizesprice * 5 / 100);
    	
    	//Checking if customer gets a 250 off if selected sunroof and multimedia package
    	if ((REALyesornoM2 == 'Y' || REALyesornoM2 == 'y') && (REALyesornoM3 == 'Y' || REALyesornoM3 == 'y') )
    		additionalcostM -= 250;
    	
    	//Checking if customer gets a 10%off in transmission and security packages
    	if ((REALyesornoM1 == 'Y' || REALyesornoM1 == 'y') && (REALyesornoM4 == 'Y' || REALyesornoM4 == 'y') )
    		additionalcostM -= 300;
    	//Checking what percentage tax will be added
    	totalcostM = midsizesprice + additionalcostM;
    	if (totalcostM < 35000) {
    		//Exercising 35% tax
    		totalcostM += (midsizesprice + additionalcostM)  *35 / 100;
    	totalcostM += totalcostM * 18  /100;	
    		//Calculating tax
    	SalesTaxM = totalcostM - (midsizesprice + additionalcostM);
    	//Showing customer what they bought
    	System.out.println("\n");
    	System.out.println("You ordered a midsize car with a base price of " + midsizesprice + "$");
        System.out.println("Your additional cost is " + additionalcostM + "$");
    	System.out.println("Sales Tax: " + SalesTaxM + "$");
    	System.out.println("Total cost of car & options: " + totalcostM + "$");
    	
    	}
    	else {
    		//Exercising 40% tax
    		totalcostM += (midsizesprice + additionalcostM)  * 40 / 100;
    	totalcostM += totalcostM * 18  / 100;	
    	//Calculating tax
    	SalesTaxM = totalcostM - (midsizesprice + additionalcostM);
    	
    	//Showing customer what they bought
    	System.out.println("You ordered a midsize car with a base price of 26000$");
        System.out.println("Your additional cost is " + additionalcostM + "$");
    	System.out.println("Sales Tax: " + SalesTaxM + "$");
    	System.out.println("Total cost of car & options: " + totalcostM + "$");
    	}
    	
    	break;
    	
    case 4:
    	//Creating needed variables
    	float totalcostP = 0;
    	float pickupsprice = 19500 ;
    	float additionalcostP = 0;
    	float SalesTaxP = 0;
    	//Taking additional choices
    	System.out.print("Do you want protective undercoating for 150$ (Y/N) ");
    	String yesornoP = input.next();
    	char REALyesornoP = yesornoP.charAt(0);
    	 
    	
    	if (REALyesornoP == 'Y' || REALyesornoP == 'y')
    		additionalcostP += 150;
    	
    	//Exercising 35% tax
    	System.out.print("Do you want the multimedia package for 750$ (Y/N) ");
    	String yesornoP1 = input.next();
    	char REALyesornoP1 = yesornoP1.charAt(0);
    	 
    	
    	if (REALyesornoP1 == 'Y' || REALyesornoP1 == 'y')
    		additionalcostP += 750;
    	
    	//Calculating total cost
         totalcostP = pickupsprice + additionalcostP;
    	//Calculating total cost
    	totalcostP += (pickupsprice + additionalcostP) * 35 / 100;
    	totalcostP += totalcostP * 18 / 100;
    	//Calculating tax
    	SalesTaxP = totalcostP - (pickupsprice + additionalcostP);
    	
    	//Showing what customer bought
    	System.out.println("\n");
    	System.out.println("You ordered a pickup with a base price of " + pickupsprice + "$");
        System.out.println("Your additional cost is " + additionalcostP + "$");
    	System.out.println("Sales Tax: " + SalesTaxP + "$");
    	System.out.println("Total cost of car & options: " + totalcostP + "$");
    	
    	break;
    	
    case 5 :
    	//Creating needed variables
    	float totalcostS = 0;
    	float suvsprice = 29000 ;
    	float additionalcostS = 0;
    	float SalesTaxS = 0;
    	//Taking additional choices
    	System.out.print("Do you want protective undercoating for 200$ (Y/N) ");
    	String yesornoS = input.next();
    	char REALyesornoS = yesornoS.charAt(0);
    	
    	
    	if (REALyesornoS == 'Y' || REALyesornoS == 'y')
    		additionalcostS += 200;
    	
    	//Taking additional choices
    	System.out.print("Do you like to replace the normal transmission by an automatic transmission\r\n" + 
    			"for 2500$ (Y/N) ");
    	String yesornoS1 = input.next();
    	char REALyesornoS1 = yesornoS1.charAt(0);
    	
    	
    	if (REALyesornoS1 == 'Y' || REALyesornoS1 == 'y')
    		additionalcostS += 2500;
    	
    	//Taking additional choices
    	System.out.print("Do you want sunroof for 2300$ (Y/N) ");
    	String yesornoS2 = input.next();
    	char REALyesornoS2 = yesornoS2.charAt(0);
    	
    	
    	if (REALyesornoS2 == 'Y' || REALyesornoS2 == 'y')
    		additionalcostS += 2300;
    	
    	//Taking additional choices
    	System.out.print("Do you want the multimedia package for 1000$ (Y/N) ");
    	String yesornoS3 = input.next();
    	char REALyesornoS3 = yesornoS3.charAt(0);
    	
    	
    	if (REALyesornoS3 == 'Y' || REALyesornoS3 == 'y')
    		additionalcostS += 1000;
    	
    	//Taking additional choices
    	System.out.print("Do you want the security package for 1350$ (Y/N) ");
    	String yesornoS4 = input.next();
    	char REALyesornoS4 = yesornoS4.charAt(0);
    	
    	
    	if (REALyesornoS4 == 'Y' || REALyesornoS4 == 'y')
    		additionalcostS += 1350;
    	
    	//Taking additional choices
    	System.out.print("Do you want the sports package for an increased 5.0% This will increase your" + 
    			"cost by $1450.0 (Y/N)? ");
    	String yesornoS5 = input.next();
    	char REALyesornoS5 = yesornoS5.charAt(0);
    	
    	//Checking if customer bought sports choice
    	if (REALyesornoS5 == 'Y' || REALyesornoS5 == 'y')
    		additionalcostS += 1450;
    	//Checking if customer gets fee undercoating and if he gets and amount already added to cost cutting it
    	if ( (REALyesornoS1 == 'Y' || REALyesornoS1 == 'y') && (REALyesornoS2 == 'Y' || REALyesornoS2 == 'y') && (REALyesornoS3 == 'Y' || REALyesornoS3 == 'y')
    		&&	(REALyesornoS4 == 'Y' || REALyesornoS4 == 'y')) {
    		if (REALyesornoS == 'Y' || REALyesornoS == 'y')
    		additionalcostS -= 200;
    		
    		System.out.println("You won protective undercoating for free!");
    	}
    	
    	//Calculating total cost
    	totalcostS = suvsprice + additionalcostS;
    	//Checking what tax will be exercised
    	if (totalcostS < 35000) {
    		//Exercising tax 35%
    		totalcostS += (suvsprice + additionalcostS)  * 35 / 100;
    	totalcostS += totalcostS * 18  /100;	
    		//Calculating tax
    	SalesTaxS = totalcostS - (suvsprice + additionalcostS);
    	//Showing customer what he bought
    	System.out.println("You ordered a SUV with a base price of " + suvsprice + "$");
        System.out.println("Your additional cost is " + additionalcostS + "$");
    	System.out.println("Sales Tax: " + SalesTaxS + "$");
    	System.out.println("Total cost of car & options: " + totalcostS + "$");
    	
    	}
    	else {
    		//Exercising 40% tax
    		totalcostS += (suvsprice + additionalcostS)  * 40 / 100;
    	totalcostS += totalcostS * 18  / 100;	
    		//Calculating tax
    	SalesTaxS = totalcostS - (suvsprice + additionalcostS);
    	//Showing customer what he bought
    	System.out.println("\n");
    	System.out.println("You ordered a SUV with a base price of 29000$");
        System.out.println("Your additional cost is " + additionalcostS + "$");
    	System.out.println("Sales Tax: " + SalesTaxS + "$");
    	System.out.println("Total cost of car & options: " + totalcostS + "$");
    	
    	break;
    	}
    	 		
    }
    System.out.println("Program ends ...");
	}

}
