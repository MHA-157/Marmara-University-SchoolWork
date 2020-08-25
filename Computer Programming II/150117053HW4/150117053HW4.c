//Muhammet Hasan Albayrak

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <Math.h>
#define SIZE 10
#define dist(a,b) (b - a) * (b - a) 
//Structlar
struct MetroStation{
	char name[20];
	double x;
	double y; 
};
typedef struct MetroStation MetroStation;

struct MetroLine{
	char name[20]; 
	MetroStation MetroStations[SIZE];
};
typedef struct MetroLine MetroLine;

struct MetroSystem{
	char name[20];
	MetroLine MetroLines[SIZE];
};
typedef struct MetroSystem MetroSystem;
//Checks Yhe names of the metro stations
int equals(MetroStation s1, MetroStation s2){
	if(strcmp(s1.name, s2.name) == 0)
	return 1;
	return 0;
}
//Adds station to end of the line
void addStation(MetroLine * line, MetroStation station){
	int i;
	for( i = 0; i < 10; i++){
		if((line->MetroStations[i].name[0] == 0))
		line->MetroStations[i] = station;
	}
}
//CHecks if the line has the station
int hasStation(MetroLine line, MetroStation station){
	int i;
	for( i = 0; i < 10; i++){
		if(strcmp(line.MetroStations[i].name, station.name) == 0)
		return 1;
		
	}
	return 0;
}

MetroStation getFirstStop(MetroLine line){
	MetroStation st;
	if(line.MetroStations[0].name[0] == 0)
	return st;
	return line.MetroStations[0];
}

MetroStation getPriorStop(MetroLine line, MetroStation station){
int i;
MetroStation st;
	for( i = 0; i < 10; i++){
		if(strcmp(line.MetroStations[i].name, station.name) == 0)
		if(i == 0)
		return st;
		else
		return line.MetroStations[i];
	}
	return st;
}

MetroStation getNextStop(MetroLine line, MetroStation station){
	int i;
MetroStation st;
for(i = 0; i < 10; i++){
	if(strcmp(line.MetroStations[i].name, station.name) == 0)
	if(line.MetroStations[i + 1].name[0] == 0)
	return st;
}
}
void addLine(MetroSystem * system, MetroLine line){
	int i;
	for(i = 0; i < 10; i++){
		if((system->MetroLines[i].MetroStations[i].name[0] == 0))
		system->MetroLines[i] = line;
	}
}
//Prints lines and stations
void printLine(MetroLine line){
	int i;
	puts(line.name);
	for(i = 0; i < 10; i++){
		puts(line.MetroStations[i].name);
	}
	printf("\n");
}
//Prints stations
void printPath(MetroStation stations[] ){
	int i;
		for(i = 0; i < 10; i++){
		puts(stations[i].name);
	}
	printf("\n");
}
//Calculates distance travelled in a metro line
double getDistanceTravelled(MetroStation stations[] ){
	double dist = 0;
	int i;
	for(i = 2; i < 10;i++ ){
		if(!(stations[i].name[0] == 0))
	     dist += sqrt(dist(stations[i].x,stations[i - 1].x) + dist(stations[i].y,stations[i - 1].y));
	}
	return  dist;
}

//Finds nearest station
MetroStation findNearestStation(MetroSystem system, double x, double y){
	int i, j;
	double dist = 0;
	double min = 100000;
	int indexa = 0;
	int indexb = 0;
	
	for(i = 2; i <10; i++){
		if(!(system.MetroLines[i].name[0] == 0))
		for(j = 2; j < 10; j++){
			if(!(system.MetroLines[i].MetroStations[j].name[0] == 0))
		 dist = sqrt(dist(system.MetroLines[i].MetroStations[j].x, x) + dist(system.MetroLines[i].MetroStations[j].y, y));
			if(dist < min){
				indexa = i;
				indexb = j;
				min = dist;
			}
			
		}
	}
	return system.MetroLines[i].MetroStations[j];
}
 
  getNeighboringStations(MetroSystem system, MetroStation station, MetroStation neigboringStations[]){
  	int i, j;
  	int k = 0;
	  for(i = 0; i < 10; i++){
	  	for(j = 0; j < 10;j++){
	  		if(strcmp(system.MetroLines[i].MetroStations[j].name, station.name) == 0){
			  if(!(j == 0)){
			  
			  neigboringStations[k] = system.MetroLines[i].MetroStations[j - 1];
			  k++;
			  }
			  if(())
			  }
	  		
		  }
	  }
  }

int main(){
	
}
