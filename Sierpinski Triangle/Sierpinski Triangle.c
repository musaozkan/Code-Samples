#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

char coordinates[81][2] = { {0} };
int counter = 0,constantIteration = 0,column,row,X = 0,Y = 0,row1,column1;

void triangle(char display[32][63],int x, int y, int h) {
    for (row = y; row<=h-1+y; row++) {
        for (column = x; column<=2*(row-y)+x; column++) {
            display[row][column-(row-y)] = '1';
        }
    }
}

void sierpinski(int iteration ,int row, int column, char display[32][63], char coordinates[81][2]){
	coordinates[counter][0] = column/2;
	coordinates[counter++][1] = 0;
	if(iteration > 0){
		//THE PROBLEM IS HERE BUT I COULDN'T FIND A MATHEMATICAL WAY TO FIND THE TOP POINT OF EVERY TRIANGLE, 
		//THERE ARE 3^(iteration) TRIANGLES IN THE SIERPISNKI TRIANGLE SO I HAVE FAILED AT MATH, NOT C.
		coordinates[counter][0] = coordinates[counter-3][0];
		coordinates[counter++][1] = coordinates[counter-3][1];
		coordinates[counter][0] = coordinates[counter-3][0]+pow(2,5-constantIteration)-1;
		coordinates[counter++][1] =coordinates[counter-3][1]+pow(2,5-constantIteration);
		coordinates[counter][0] = coordinates[counter-3][0]+pow(2,5-constantIteration);
		coordinates[counter++][1] = coordinates[counter-3][1]+pow(2,5-constantIteration);
		//THE PROBLEM IS HERE BUT I COULDN'T FIND A MATHEMATICAL WAY TO FIND THE TOP POINT OF EVERY TRIANGLE, 
		//THERE ARE 3^(iteration) TRIANGLES IN THE SIERPISNKI TRIANGLE SO I HAVE FAILED AT MATH, NOT C.
		iteration--;
		sierpinski(iteration,row1,column1,display,coordinates);		
	} else if(iteration == 0) {	
		int i,j;	
		for(i = 0; i<=pow(3,constantIteration)+1; i++){
			if(coordinates[i][0] != 0 || coordinates[i][1] != 0){
				triangle(display, coordinates[i][0], coordinates[i][1] , (32 / (pow(2,constantIteration))));
			} 
		}
	}	
}
int main()
{
	char display[32][63] = { {0} };
	int iteration;
	printf("Please enter the iteration number = ");
	scanf("%d",&iteration);
	constantIteration = iteration;
	sierpinski(iteration, 32, 63, display,coordinates);
	int i,j;
   	for (i = 0 ; i<32 ; i++) {
      	for (j = 0; j<63; j++) {
       	if (display[i][j]=='\0')
     		display[i][j]='_';
       	}
	}
	for (i=0 ; i<32; i++) {
        for (j=0; j<63; j++) {
            printf("%c", display[i][j]);
        }
        printf("\n");
    }
}
