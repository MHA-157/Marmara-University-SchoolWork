        /*          Muhammet Hasan ALBAYRAK 150117053     HW-2 CSE 2046 
 * ************************************* InsertionSort**************************************************/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
class InsertionSort { 

  public static void main(String args[]) throws IOException { 
	for(int j = 1; j < 10; j++) {
	  File file = new File("input" + j +".txt");
	  String str = "";
	  int n = 10 * j;
	  int arr[] = new int[n];
	  BufferedReader reader ;
	  System.out.println();
	  reader = new BufferedReader(new FileReader(file));
	  int i = 0;
	  while (i < n){
		  str = reader.readLine();
		  arr[i] = Integer.parseInt(str);
		  i++;
	  }
	  System.out.println("Input:");
	  printArray(arr);
	  long time1 = System.nanoTime();
	  sort(arr);
	  long time2 =  System.nanoTime();
	  System.out.println("Sorted:");
	  System.out.println("Median is:"  + arr[n / 2]);
	  System.out.println("Time:" + (time2 - time1));
	  reader.close();
	  
	}
}

    /*Function to sort array using insertion sort*/
   static void sort(int arr[])  { 
        int n = arr.length; 
        for (int i = 1; i < n; ++i) { 
            int key = arr[i]; 
            int j = i - 1; 
  
            /* Move elements of arr[0..i-1], that are 
               greater than key, to one position ahead 
               of their current position */
            while (j >= 0 && arr[j] > key) { 
                arr[j + 1] = arr[j]; 
                j = j - 1; 
            } 
            arr[j + 1] = key; 
        } 
    } 
  
    static void printArray(int arr[]) { 
        int n = arr.length; 
        for (int i = 0; i < n; ++i) 
            System.out.print(arr[i] + " "); 
  
        System.out.println(); 
    } 
  
   
}