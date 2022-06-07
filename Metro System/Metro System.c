#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>
#define SIZE 10

//Defining 3 related structs to perform the task properly
   typedef struct MetroStation
   {
       char name[20];
       int x,y;
   } MetroStation;
  
   typedef struct MetroLine
   {
       char color[20];
       MetroStation MetroStations[SIZE];
   } MetroLine;
  
   typedef struct MetroSystem
   {
       char name[20];
       MetroLine MetroLines[SIZE];
   } MetroSystem;
  
//Declaring a MetroSystem struct with the name of istanbul and an empty content.
MetroSystem istanbul = {"istanbul", '\0'};

int equals (MetroStation st1, MetroStation st2)
{ //this function checks if the given metro stations same or not.
  
   if (!strcmp(st1.name, st2.name))
       return 1;
  
   return 0;
}

void addStation (MetroLine *ln, MetroStation stat)
{ //this function adds given station to given line.
   int i = 0;
   while (ln->MetroStations[i].name[0] != '\0')
   {
       i++;
   }
   ln->MetroStations[i] = stat;
}

int hasStation (MetroLine ln, MetroStation stat)
{ //this function checks if given line contains the given station or not.
   int i;
   for (i = 0; strlen(ln.MetroStations[i].name) != 0; i++)
   {
       if (strcmp(ln.MetroStations[i].name, stat.name))
           return 1;
   }
   return 0;
}

MetroStation getFirstStop (MetroLine ln)
{ //this function returns the first stop of given line
       return ln.MetroStations[0];
}

MetroStation getPriorStop (MetroLine ln, MetroStation stat)
{ //this function returns the station just before the given station on given line.
   MetroStation ms;
   int i = 0;
  
   while (!strcmp(ln.MetroStations[i].name, stat.name))   i++;
  
   if (i != 0)
   {
       ms = ln.MetroStations[i-1];
       return ms;
   }
  
   return ms;  
}

MetroStation getNextStop (MetroLine ln, MetroStation stat)
{ //this function returns the station just after the given station on given line.
   MetroStation ms;
   int i = 0;
  
   while (!strcmp(ln.MetroStations[i].name, stat.name))   i++;
  
   if (i != SIZE - 1)
   {
       ms = ln.MetroStations[i+1];
       return ms;
   }
  
   return ms;
}

void addLine (MetroSystem *sys, MetroLine ln)
{ //this function adds new line to given metro system.
   int i = 0;
   while (strlen(sys->MetroLines[i].color) != 0)   i++;
   sys->MetroLines[i] = ln;
}

void printLine (MetroLine ln)
{ //this function prints out the stations of given line.
   int i;
   printf("Metroline %s: ", ln.color);
   for (i = 0; i < 10; i++)
   {
       if (ln.MetroStations[i].name[0] != '\0')
       {
           printf("%s ", ln.MetroStations[i].name);
       }
       else
           continue;
   }
   puts("");
}

void printPath (MetroStation *stats)
{ //this function prints the stations on given path.
   int i;
   for (i = 0; strlen(stats[i].name) != 0; i++)
   {
           printf("%d. %s\n", i+1, stats[i].name);
   }
}

double getDistanceTravelled (MetroStation *path)
{ //this function returns the total distance between each stations on given path.
   double tot = 0;
   int i, x, y;
  
   x = path[0].x;
   y = path[0].y;
  
   for (i = 1; i < sizeof(path); i++)
   {
       if (path[i].name == NULL)
       {
           if (i == 1)
               return 0;
           else
               break;
       }
       else
       {
           tot += sqrt(pow(path[i].x - x, 2) + pow(path[i].y - y, 2));
           x = path[i].x;
           y = path[i].y;
       }
   }
  
   return tot;
}

MetroStation findNearestStation (MetroSystem sys, double x, double y)
{ //this function finds and returns the closest metro station base on given x and y values.
   double dist, temp, nx, ny, pow1, pow2;
   int i, j;
   MetroStation next, nearest;
  
   nearest = getFirstStop(sys.MetroLines[0]);
   dist = sqrt(pow(getFirstStop(sys.MetroLines[0]).x - x, 2) + pow(getFirstStop(sys.MetroLines[0]).y - y, 2));
   for (i = 0; i < SIZE; i++)
   {
       for (j = 0; j < SIZE; j++)
       {
           next = sys.MetroLines[i].MetroStations[j];
           nx = next.x; nx -= x;
           ny = next.y; ny -= y;
           pow1 = nx * nx;
           pow2 = ny * ny;
           temp = pow1 + pow2;
           temp = sqrt(temp);
           if (next.name != NULL)
           {
               if (temp < dist)
               { //if current distance smaller than previous one, update previous one to new distance.
                   dist = temp;
                   nearest = next;
               }
           }
           else
               break;
       }
   }
   return nearest;
}

void getNeighboringStations (MetroSystem sys, MetroStation stat, MetroStation *neighbouringStations)
{ //this function updates the neighboringStations with the stations which are the previous or next stations of given station on each line.
   int i, j, index = 0;
  
   for (i = 0; strlen(sys.MetroLines[i].color) != 0; i++)
   {
       for (j = 0; strlen(sys.MetroLines[i].MetroStations[j].name) != 0; j++)
       {
           if (!strcmp(stat.name, sys.MetroLines[i].MetroStations[j].name))
           {
               if (!contains(neighbouringStations, sys.MetroLines[i].MetroStations[j-1].name) && !contains(neighbouringStations, sys.MetroLines[i].MetroStations[j+1].name)) {
                   if (j > 0)
                   {
                       neighbouringStations[index++] = sys.MetroLines[i].MetroStations[j - 1];
                       neighbouringStations[index++] = sys.MetroLines[i].MetroStations[j + 1];
                   }
                   else
                   {
                       neighbouringStations[index++] = sys.MetroLines[i].MetroStations[j + 1];
                   }
                      
               }
           }
       }
   }
}

int contains (MetroStation *stats, MetroStation st)
{ //this function finds the path with the help of recursiveFindPath function.
   MetroStation partialPath[SIZE] = {'\0'};
  
  
   recursiveFindPath(start, finish, path, partialPath);
}

int main()
{
   int i;
   double X=9, Y=4;
   double goalX=48, goalY=22;
  
   // defining 3 metro lines, 9 metro stations, and an empty Path
   MetroLine red={'\0'}, blue={'\0'}, green={'\0'};
   MetroStation s1, s2, s3, s4, s5, s6, s7, s8, s9;
   MetroStation Path[SIZE]={'\0'};
   
   strcpy(red.color, "red");
   strcpy(blue.color, "blue");
   strcpy(green.color, "green");

  
   strcpy(s1.name, "Haydarpasa");        s1.x=0;    s1.y=0;
   strcpy(s2.name, "Sogutlucesme");    s2.x=10;    s2.y=5;
   strcpy(s3.name, "Goztepe");        s3.x=20;    s3.y=10;
   strcpy(s4.name, "Kozyatagi");        s4.x=30;    s4.y=35;
   strcpy(s5.name, "Bostanci");        s5.x=45;    s5.y=20;
   strcpy(s6.name, "Kartal");            s6.x=55;    s6.y=20;
   strcpy(s7.name, "Samandira");        s7.x=60;    s7.y=40;
   strcpy(s8.name, "Icmeler");        s8.x=70;    s8.y=15;
  
   //Adding several metro stations to the defined metro lines.
   addStation(&red, s1); addStation(&red, s2); addStation(&red, s3); addStation(&red, s4); addStation(&red, s5); addStation(&red, s8);
  
   addStation(&blue, s2); addStation(&blue, s3); addStation(&blue, s4); addStation(&blue, s6); addStation(&blue, s7);
  
   addStation(&green, s2); addStation(&green, s3); addStation(&green, s5); addStation(&green, s6); addStation(&green, s8);
  
   //Adding red, blue, green metro lines to the istanbul metro system.
   addLine(&istanbul, red);
   addLine(&istanbul, blue);
   addLine(&istanbul, green);
  
   //Printing the content of the red, blue, green metro lines
   printLine(red);
   printLine(blue);
   printLine(green);
      
      
   //Finding the nearest stations to the current and target locations
   MetroStation nearStart = findNearestStation(istanbul, X, Y);
   MetroStation nearFinish = findNearestStation(istanbul, goalX, goalY);
  
   printf("\n");
  
   printf("The best path from %s to %s is:\n", nearStart.name, nearFinish.name);
  
   //If the nearest current and target stations are the same, then print a message and exit.
   if(equals(nearStart, nearFinish)){
       printf("It is better to walk!\n");
       return 0;
   }
  
   //Calculating and printing the Path with the minimum distance traveled from start to target stations.
   findPath(nearStart, nearFinish, Path);
  
   if(strlen(Path[0].name) == 0)
       printf("There is no path on the metro!\n");
   else{
       printPath(Path);
   }
  
   return 0;

}

