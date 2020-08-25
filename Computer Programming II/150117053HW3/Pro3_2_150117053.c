//Muhammet Hasan Albayrak

#include<stdio.h>
//Global variables
int number;
int factor;
int total;
//Function for finding the to find super digit
int actualNumber(n, k){
	int digitCount = 0;
	int a = n;
	//finding digit count
	while(a > 0){
		a /= 10;
		digitCount++;
	}
	int i = 1;
	//Creating number to find super digit
    while ( i < (k - 1 ) * digitCount + 1){
		number *= 10; 
		
			if(i % digitCount == 0)
		number += n;
		 i++;
	}
	printf("%d", number);
	superDigit(number);
}
//Function for findg super digit
int superDigit(n){
	//Sum of numbers digit
	if(n != 0){
		total += n % 10;
		return superDigit(n / 10);
	}
	//Till finding one digit sum repeat
	if(total / 10 != 0 ){
		int a = total;
		total = 0;
		return superDigit(a);
		
	}
	else{
		printf("\n Super digit of number %d is %d.", number, total);
	}
}

int main(){
	printf("Please enter a number (n=) : ");
	scanf("%d", &number);
	printf("Please enter repetition factor (k=): ");
	scanf("%d", &factor);
	actualNumber(number, factor);
}
