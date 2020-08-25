/******************** MUHAMMET HASAN ALBAYRAK 150117053  CSE - 2046 ********************************
 ***************************  HWW#3   ********************* */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TravelinSalesmanProblem {
public static String out = "";
public final static int INFINITE = 99999999;
public static ArrayList<city> Cities;
public static int[] Way;
public static int TravelLength = 99999999;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Input File:");
		String text = input.nextLine();
		File file = new File(text);
		
		ArrayList<city> cities = new ArrayList<>();
		
		File output = new File("output.txt");
		
		FileWriter fr = null;
		fr = new FileWriter(output);
		
		
	
		BufferedReader reader;
		System.out.println();
		reader = new BufferedReader(new FileReader(file));
		String[] data = new String[3];
		String c;
		String[] data2;
		//reads line by line and splits them 
		while ((c = reader.readLine()) != null) {
			int k = 0;
			// c = c.replace(' ', ',');
			if(!c.equals("")) {
				if(c.length() != 0) {
					data2 = c.split("[\\s+, ]");
					for(int i = 0; i < data2.length; i++) {
						if(!data2[i].equals("")) {
							data[k] = data2[i];
							k++;
						}
							
					}//calls constructor city(id, x, y) 
					city city = new city(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]));
					cities.add(city);
				
				}
			}
		
		}
		
		Cities = cities;
		
		int length = cities.size();
		Way = new int[length];
		//declering 2D matrix and filling it
		int[][] matrix = new int[length][length];
		createMatrix(matrix, cities);
		//declaring tour and then using nearest neighbour to find the shortest tour with calling function for every city as starting point
		int[] way = new int[matrix.length];
		//nearestNeighbour(matrix, way, 1);
		for(int j = 0; j < length; j++) {
			nearestNeighbour(matrix, way, j);
			reset();
		}
		
	
		out += TravelLength;
		out += "\n";
		
		for(int i = 0; i < length; i++) {
			out += Way[i];
			out += "\n";
		}
			
		fr.write(out);
		fr.close();
		reader.close();
		input.close();
	}
	//resets visited city for next call
	public static void reset() {
		for(int i = 0; i < Cities.size(); i++)
			Cities.get(i).visited = false;
	}
	//finds the closest city in the row then calls for it again using column as the next row so in the city 0 the closest is 1 so the next row becomes 1 and calls for it againg
	public static int nearestNeighbour(int[][] matrix, int[] way, int row) {
		int travelLength = 0;
		int startCity = row;
		int temp = 0;
		int length = way.length;
		Cities.get(row).visited = true;
		for(int i = 0; i < length; i++) {
			way[i] = row;
			temp = row;
			row = findNearest(matrix[row], startCity);
			travelLength += matrix[temp][row];
		}
		//updates the path if the new one is shorter
		if(travelLength < TravelLength) {
			copyArray(way, Way);
			TravelLength = travelLength;
		}
		
		
		return travelLength;
	}
	//takes a row array and finds the smallest distance then returns it
	public static int findNearest(int[] arr, int SC) {
		int shortestWay = INFINITE;
		int city = INFINITE;
		int allVisited = 0;
		
		//if all cities visited returns the starting city and the tour ends
		for(int j = 0; j < arr.length; j++) {
			if(!Cities.get(j).visited)
				allVisited++;
		}
		if(allVisited == 0) {
			return SC;
		}
			
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] != 0 && !(Cities.get(i).visited)) {
				if(arr[i] < shortestWay) {
					shortestWay = arr[i];
					city = i;
				}
					
			}
		}
		//System.out.println(city);
		Cities.get(city).visited = true;
		return city;
	}
	
	public static void createMatrix(int[][] matrix, ArrayList<city> cities) {
		int length = cities.size();
		for(int i = 0; i < length; i++ ) {
			for(int j = 0; j < length; j++) {
				matrix[i][j] = dis(cities.get(i).x, cities.get(i).y, cities.get(j).x, cities.get(j).y);
			}
		}
	}
	//calculates distance
	public static int dis(int x1, int y1, int x2, int y2) {
		int dis = (int) Math.round(Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1)));
		return dis;
		
	}
	
	public static void copyArray(int[] arr1, int[] arr2) {
		int length = arr1.length;
		for(int i = 0; i < length; i++) {
			arr2[i] = arr1[i];
		}
	}
	
	

}
    class city{
	int ID;
	int x;
	int y;
	boolean visited = false;
	public city(int ýd, int x, int y) {
		ID = ýd;
		this.x = x;
		this.y = y;
	}
}
