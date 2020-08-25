import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
class InsertionSort { 

  public static void main(String args[]) throws IOException { 
	File file = new File("input.txt");
	String str = "";
	int arr[] = new int[10];
	BufferedReader reader ;
	System.out.println();
	reader = new BufferedReader(new FileReader(file));
	int i = 0;
	while ((str = reader.readLine()).length() != 0) {
	arr[i] = Integer.parseInt(str);
	i++;
	}
	System.out.println("Input:");
	long time1 = System.currentTimeMillis();
    sort(arr);
    long time2 = System.currentTimeMillis();
    System.out.println("Sorted:");
    printArray(arr);
    System.out.println("Time:" + (time2 - time1));
    reader.close();
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