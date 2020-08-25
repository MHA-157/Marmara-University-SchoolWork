
//Muhammet Hasan Albayrak 150117053
//This program calculates total number bunny ears with given number

#include<stdio.h>
//Global variable for ears
int ears = 0;
//Function for recursive calling
int bunnies(int n){
	
	if(n > 0){
		
	if(n % 2 == 0){
	
	//Calling function again till comes back
	return  bunnies(n - 1),ears += 3 , printf("bunnyEars2(%d) = %d \n", n, ears );

}
else{
	

	return  bunnies(n - 1), ears += 2,  printf("bunnyEars2(%d) = %d \n", n, ears );
}

}
	else
	
	return printf("bunnyEars2(%d) = %d \n", n, ears );
}


int main(){
	
	int lines = 0;
	//Taking lines
	printf("Please enter the number of lines (n=): ");
	scanf("%d", &lines);
	//Starting function calling
    bunnies(lines);
}
