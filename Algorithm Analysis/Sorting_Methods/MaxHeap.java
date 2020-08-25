
       /*          Muhammet Hasan ALBAYRAK 150117053     HW-2 CSE 2046  
 * ************************************* Max Heap **************************************************/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MaxHeap {
	private int[] Heap; 

	
	private int size; 
	private int maxsize; 
	
	
	
	public static void main(String[] arg) throws NumberFormatException, IOException  { 
	     for(int j = 1; j < 10; j++) {
	    	 int n = 10 * j;	
	    	 File file = new File("input" + j +".txt");
	    	 String str = "";
	    	 BufferedReader reader ;
	    	 System.out.println("The Max Heap is "); 
	    	 MaxHeap maxHeap = new MaxHeap(n * 3 / 2 ); 
	    	 reader = new BufferedReader(new FileReader(file));
	    	 int i = 0;
	    	 while (i < n) {
	    		 str = reader.readLine();
	    		 maxHeap.insert(Integer.parseInt(str)); 
	    		 i++;
	    	 }
	    	 maxHeap.print();
	    	 long time1 = System.nanoTime(); 
	    	 for(i = 0; i < n / 2 - 1; i++)
	    		 maxHeap.extractMax();
	    	 System.out.println("The median val is " + maxHeap.extractMax());
	    	 long time2 = System.nanoTime();
	    	 System.out.println("Time:" + (time2 - time1));
	    	 reader.close();
	     } 
	}
	   
	    public MaxHeap(int maxsize){ 
	        this.maxsize = maxsize; 
	        this.size = 0; 
	        Heap = new int[this.maxsize + 1]; 
	        Heap[0] = Integer.MAX_VALUE; 
	    } 
	  
	   
	    private int parent(int pos)  { 
	        return pos / 2; 
	    } 
	  
	    
	    private int leftChild(int pos){ 
	        return (2 * pos); 
	    } 
	    private int rightChild(int pos) { 
	        return (2 * pos) + 1; 
	    } 
	  
	  
	    private boolean isLeaf(int pos)   { 
	        if (pos >= (size / 2) && pos <= size) { 
	            return true; 
	        } 
	        return false; 
	    } 
	  
	    private void swap(int fpos, int spos)  { 
	        int tmp; 
	        tmp = Heap[fpos]; 
	        Heap[fpos] = Heap[spos]; 
	        Heap[spos] = tmp; 
	    } 
	  
	     
	    
	    private void maxHeapify(int pos) { 
	        if (isLeaf(pos)) 
	            return; 
	  
	        if (Heap[pos] < Heap[leftChild(pos)] ||  
	            Heap[pos] < Heap[rightChild(pos)]) { 
	  
	            if (Heap[leftChild(pos)] > Heap[rightChild(pos)]) { 
	                swap(pos, leftChild(pos)); 
	                maxHeapify(leftChild(pos)); 
	            } 
	            else { 
	                swap(pos, rightChild(pos)); 
	                maxHeapify(rightChild(pos)); 
	            } 
	        } 
	    } 
	  
	    // Inserts a new element to max heap 
	    public void insert(int element) { 
	        Heap[++size] = element; 
	  
	        // Traverse up and fix violated property 
	        int current = size; 
	        while (Heap[current] > Heap[parent(current)]) { 
	            swap(current, parent(current)); 
	            current = parent(current); 
	        } 
	    } 
	  
	    public void print()  { 
	        for (int i = 1; i <= size / 2; i++) { 
	            System.out.print(" PARENT : " + Heap[i] + " LEFT CHILD : " + 
	                      Heap[2 * i] + " RIGHT CHILD :" + Heap[2 * i + 1]); 
	            System.out.println(); 
	        } 
	    } 
	  
	    // Remove an element from max heap 
	    public int extractMax()   { 
	        int popped = Heap[1]; 
	        Heap[1] = Heap[size--]; 
	        maxHeapify(1); 
	        return popped; 
	    } 
	  
	   
}
