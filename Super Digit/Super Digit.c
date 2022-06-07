//Musa Özkan 150121058
//This program take a number and a factor and prints out the number repeatedly (according to the factor) and sums the repeated numbers digits to a digit and prints it
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int sum = 0, i = 0;
//It 
char *repeat(char *number, int repFactor, char* temp){
	if(repFactor>1){
		strcat(temp, number);
		repFactor--;
		repeat(number, repFactor, temp);
	} else {
		return temp;
	}
}
//The method gets the repeated number as char array and gets its digits. In the end it checks if the sum is more than 9. 
//If it is, the method invokes itself, if it is not it returns the sum.
int superDigit(char *reppedNumber){ 
	sum += ((int)(reppedNumber[i++]))-48;
	if(i<strlen(reppedNumber)){
		superDigit(reppedNumber);
	} else if(sum > 9){
		char str[10];
		itoa(sum,str,10);
		sum = 0,i = 0;
		superDigit(str);	
	} else {
		return sum;
	}
}

int main(int argc, char *argv[]) {
	int repFactor;
	char number[100];
	printf("Please enter a number (n=) :");
	scanf("%s", &number);
	printf("Please enter repetition factor (k=) :");
	scanf("%d", &repFactor);
	//Creates a char array and allocates a memory to it
	char* temp = (char*)malloc(100 * sizeof(char));
	//Copies the number array to the temp array
	strcpy(temp,number);
	printf("Super digit of number %s", repeat(number, repFactor, temp));
	//Resets the allocated memory on the temp array
	memset(temp, 0, 100);
	//And again copies number to temp
	strcpy(temp,number);
	printf(" is %d", superDigit(repeat(number, repFactor, temp)));
	return 0;
}

