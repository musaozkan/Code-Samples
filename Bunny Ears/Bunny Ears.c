//Musa Özkan 150121058
//The proram basically gets a number and counts from 0 to that number and prints out a value which gets added by 2 or 3 according to if the counted number odd or even
#include <stdio.h>
#include <stdlib.h>
//This method takes the value and a counter and calculates and prints the outcome
int bunnyEars(int num, int counter, int value){
	if(num>=0 && counter<=num){
			if(counter==0){
				printf("bunnyEars%d(%d) -> %d\n", num , counter++ , value);	
				bunnyEars(num,counter,value);
			} else if(counter%2==1){
				value += 2;
				printf("bunnyEars%d(%d) -> %d\n", num , counter++ , value);	
				bunnyEars(num,counter,value);
			} else if(counter%2==0){
				value += 3;
				printf("bunnyEars%d(%d) -> %d\n", num , counter++ , value);	
				bunnyEars(num,counter,value);
			}
	} else {
		return 0;
	}
}

int main(int argc, char *argv[]) {	
	int numOfLines = 0;
	printf("Please enter the number of lines (n=): ");
	scanf("%d", &numOfLines);
	int counter = 0,value = 0;
	bunnyEars(numOfLines, counter, value);
   return 0;
}


