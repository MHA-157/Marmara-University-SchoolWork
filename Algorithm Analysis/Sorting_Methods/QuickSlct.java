
       /*          Muhammet Hasan ALBAYRAK 150117053     HW-2 CSE 2046  
 * ************************************* QuickSlct **************************************************/


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class QuickSlct {
	
	public static void main(String[] args) throws NumberFormatException, IOException { 
		for(int j = 1; j < 10; j++) {
			File file = new File("input" + j +".txt");
			String str = "";
			int n = 10 * j;
			BufferedReader reader;
			reader = new BufferedReader(new FileReader(file));
			int i = 0;
			int[] arr = new int[n];
			int[] arrcopy = new int[n];
        
			while (i < n) {
				str = reader.readLine();
				arr[i] = Integer.parseInt(str);
				arrcopy[i] = Integer.parseInt(str);
				i++;
			}
			int kPosition = n / 2; 
			int length = arr.length; 
          
			
            // find kth smallest value
				long time1 =  System.nanoTime(); 
				System.out.println("Median  element in array : " +   median(arrcopy, 0, length - 1, kPosition - 1));
				long time2 =  System.nanoTime(); 
				System.out.println("Time:" + (time2 - time1));
         
        
        reader.close();
    } 
}
    public static int partition (int[] arr, int low, int high) { 
        int pivot = arr[high], pivotloc = low; 
        for (int i = low; i <= high; i++)  { 
          
            if(arr[i] < pivot)  { 
                int temp = arr[i]; 
                arr[i] = arr[pivotloc]; 
                arr[pivotloc] = temp; 
                pivotloc++; 
            } 
        } 
        
        int temp = arr[high]; 
        arr[high] = arr[pivotloc]; 
        arr[pivotloc] = temp; 
          
        return pivotloc; 
    } 
      
    
    
    public static int median(int[] arr, int low,  int high, int k) { 
        // find the partition  
        int partition = partition(arr,low,high); 
  
        
        if(partition == k) 
            return arr[partition];     
              
        
        else if(partition < k ) 
            return median(arr, partition + 1, high, k ); 
              
        
        else
            return median(arr, low, partition-1, k );          
    } 
      
    
    
}
