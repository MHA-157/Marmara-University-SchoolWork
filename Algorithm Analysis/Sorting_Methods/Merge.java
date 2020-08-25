
       /*          Muhammet Hasan ALBAYRAK 150117053     HW-2 CSE 2046  
 * ************************************* MergeSort**************************************************/


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Merge {
	// Merges two subarrays of arr[]. 
    // First subarray is arr[l..m] 
    // Second subarray is arr[m+1..r] 
	 public static void main(String args[]) throws NumberFormatException, IOException   { 
		 for(int j = 1; j < 10; j++) {
			 File file = new File("input" + j +".txt");
			 String str = "";
			 int n = 10 * j;
			 int arr[] = new int[n];
			 BufferedReader reader ;
			 reader = new BufferedReader(new FileReader(file));
			 int i = 0;
	 	
			 while (i < n) {
				 str = reader.readLine();
				 arr[i] = Integer.parseInt(str);
				 i++;
			 }
	 
			 System.out.println("input"); 
			 printArray(arr); 
			 long time1 =  System.nanoTime(); 
			 sort(arr, 0, arr.length-1); 
			 long time2 =  System.nanoTime();
			 System.out.println("Sorted: "); 
			 System.out.println("Median is:"  + arr[n / 2]);
			 System.out.println("Time:" + (time2 - time1));
			 reader.close();
	 }
}
	 
   static void merge(int arr[], int l, int m, int r) { 
         
        int n1 = m - l + 1; 
        int n2 = r - m; 
  
        
        int L[] = new int [n1]; 
        int R[] = new int [n2]; 
  
        
        for (int i=0; i<n1; ++i) 
            L[i] = arr[l + i]; 
        for (int j=0; j<n2; ++j) 
            R[j] = arr[m + 1+ j]; 
  
  
        /* Merge the temp arrays */
  
        // Initial indexes of first and second subarrays 
        int i = 0, j = 0; 
  
        // Initial index of merged subarry array 
        int k = l; 
        while (i < n1 && j < n2)   { 
            if (L[i] <= R[j]) 
            { 
                arr[k] = L[i]; 
                i++; 
            } 
            else
            { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
  
        /* Copy remaining elements of L[] if any */
        while (i < n1)   { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
  
        /* Copy remaining elements of R[] if any */
        while (j < n2)  { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
    } 
  
    // Main function that sorts arr[l..r] using 
    // merge() 
   static void sort(int arr[], int l, int r)  { 
        if (l < r){ 
            // Find the middle point 
            int m = (l + r) / 2; 
  
            // Sort first and second halves 
            sort(arr, l, m); 
            sort(arr , m+1, r); 
  
            // Merge the sorted halves 
            merge(arr, l, m, r); 
        } 
    } 
  
    
    static void printArray(int arr[])   { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i] + " "); 
        System.out.println(); 
    } 
  
    
   
}
