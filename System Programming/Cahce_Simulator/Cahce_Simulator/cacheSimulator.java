package Cahce_Simulator;/*                  Muhammet Hasan ALBAYRAK 150117053     PROJECT3 CSE 2138
 * ************************************* Cache Simulator **************************************************/
//This code simulates the behaviours of L1I, L1D, L2 caches takes command line inputs for caches gives caches insides as file output at the and
//as "L1D.txt",	"L1I.txt",	"L2.txt"
//**************************************RUN in same file as "ram.txt" and "traces" ****************************************
import java.io.BufferedReader;
import java.io.File;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


/**
 * 
 */

/**-L1s 0 -L1E 2 -L1b 3 -L2s 1 -L2E 2 -L2b 3 -t test1.trace

 * @author Hasan
 *
 */
public class cacheSimulator {
public static ArrayList<String> RAM;
public static cache L1I;
public static cache L1D;
public static cache L2;
public static String out = "";
	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int L1s, L1E, L1b, L2s, L2E, L2b;
		L1s = Integer.parseInt(args[1]);
		L1E = Integer.parseInt(args[3]);
		L1b = Integer.parseInt(args[5]);
		L2s = Integer.parseInt(args[7]);
		L2E = Integer.parseInt(args[9]);
		L2b = Integer.parseInt(args[11]);
		RAM = new ArrayList<>();
		
		String traceFile = "traces/" + args[13]; 
		BufferedReader reader;
		 L1I = new cache(L1s, L1E, L1b);
		 L1D = new cache(L1s, L1E, L1b);
		 L2 = new cache(L2s, L2E, L2b);
		 L1I.name = "L1I";
		 L1D.name = "L1D";
		 L2.name = "L2";
		 
		readRAM((int)Math.pow(2, L1b));
		//Opening trace file
		File trace = new File(traceFile);
		reader = new BufferedReader(new FileReader(trace));
		String c;
		String instructions[];
	    
		//Reading trace file
		while ((c = reader.readLine()) != null) {
			System.out.println(c);
			c = c.replaceAll(",", "");	
			instructions = c.split("\\s+");
			switch(instructions[0]) {
				case "I":
					instructionLoad(instructions[1], Integer.parseInt(instructions[2]));
					break;
				case "L":
					dataLoad(instructions[1],Integer.parseInt(instructions[2]));
					break;
				case "S":
					dataStore(instructions[1],Integer.parseInt(instructions[2]), instructions[3]);
					break;
				case "M":
					dataModify(instructions[1], Integer.parseInt(instructions[2]), instructions[3]);
					break;
				}
		}
		
		//Reading the insides of caches at the end
		File L1Ioutput = new File("L1I.txt");
		File L1Doutput = new File("L1D.txt");
		File L2output = new File("L2.txt");
		FileWriter fr = null;
		
		fr = new FileWriter(L1Ioutput);
		printCache(fr, L1I);
	    fr.close();
		fr = new FileWriter(L1Doutput);
		printCache(fr, L1D);
		fr.close();
		fr = new FileWriter(L2output);
		printCache(fr, L2);
		
		
		fr.close();
		reader.close();
		
		System.out.println("L1I-hits:" + L1I.hits +" L1I-misses:" + L1I.misses + " L1I-evictions:" + L1I.evictions);
		System.out.println("L1D-hits:" + L1D.hits +" L1D-misses:" + L1D.misses + " L1D-evictions:" + L1D.evictions);
		System.out.println("L2-hits:" + L2.hits +" L2-misses:" + L2.misses + " L2-evictions:" + L2.evictions);
	}
	//Writing insides of caches like "set x tag->xxxxxxxxx block->xxxxxxxx"
	public static void printCache(FileWriter fr, cache cache) throws IOException {
		for(int i = 0; i < cache.sets.length; i++) {
			out += "set " + i + ":\n";
			for(int j = 0; j < cache.sets[i].blocks.length; j++) {
				if( cache.sets[i].blocks[j].valid) {
					out += "tag -> " + cache.sets[i].blocks[j].tag  + " block -> ";
					for(int k = 0; k < cache.sets[i].blocks[j].data.length; k++) {
						out +=cache.sets[i].blocks[j].data[k];
					}
					out += "\n";
				}
				else {
					out += "Empty block";
					out += "\n";
				}
					
			}
			out += "\n";
		}
		fr.write(out);
		out = "";
	}
	//Loads data to L1I cache
	public static void instructionLoad(String address, int bytes) {
		//Checks L1 first then L2
		if(L1I.instructionLoad(address, bytes, RAM).equals("miss")) {
			L2.dataLoad(address, bytes, RAM);
			for(int i = 0; i < L2.sets[0].blocks.length; i++)
				L2.sets[0].blocks[i].time++;
		}
		else {
			for(int i = 0; i < L1I.sets[0].blocks.length; i++)
				L1I.sets[0].blocks[i].time++;
		}
		
		
	}
	//Loads data to L1D cache
	public static void dataLoad(String address, int bytes) {
		//Checks L1 first then L2
		if(L1D.dataLoad(address, bytes, RAM).equals("miss")) {
			L2.dataLoad(address, bytes, RAM);
			for(int i = 0; i < L2.sets[0].blocks.length; i++)
				L2.sets[0].blocks[i].time++;
		}
		else {
			for(int i = 0; i < L1D.sets[0].blocks.length; i++)
				L1D.sets[0].blocks[i].time++;
		}
	}
	
	public static void dataStore(String address, int bytes, String data) {
		
		if(L1D.dataStore(address, bytes, data,RAM).equals("miss")) {
			L2.dataStore(address, bytes, data,RAM);
			for(int i = 0; i < L2.sets[0].blocks.length; i++)
				L2.sets[0].blocks[i].time++;
		}
		else {
			for(int i = 0; i < L1D.sets[0].blocks.length; i++)
				L1D.sets[0].blocks[i].time++;
		}
		
	}
	
	public static void dataModify(String address, int bytes, String data) {
		
		dataLoad(address,bytes);
		dataStore(address,bytes,data);
	}
	
	
	//Reads "ram.txt" puts data in an arraylist of 8 bytes
	public static void readRAM(int B) throws IOException {
		BufferedReader reader;
 		File ram = new File("ram.txt");
		reader = new BufferedReader(new FileReader(ram));
		char c;
		int i = 0;
		int k;
		B = 8;
		B = 2*B;
		String s = "";
		while ((k =  reader.read()) != -1) {
			c = (char) k;
			if(c == ' ' || c =='\n') {
				
			}
			else {
				s += c;
				i++;
				if(i / B != 0) {
					RAM.add(s);
					i = 0;
					s = "";  
					
					}
				}
			
			}
		
		
		
		reader.close();
	}

}
		//cache class has a name "L1I"  sets, number of hits,	misses,	and evictions
       class cache{
    	   String name;
    	   set[] sets;
    	   int hits;
    	   int misses;
    	   int evictions;
    	   public cache(int s, int E, int b) {
    		   sets = new set[(int) Math.pow(2, s)];
    		   for(int i = 0; i < sets.length; i++) {
    			   sets[i] = new set(E, 32 - s - b, b);
    		   }
    		   
    	   }
    	   //Takes address as string hexa then turns it into int for RAM and bin for tag,	set,	and block
    	   public  String instructionLoad(String address, int bytes, ArrayList<String> RAM) {
    		int intAddress = Integer.parseInt(address, 16);
    		address = hexToBin(address);
   			String tag = address.substring(0, this.sets[0].tagSize);
   			String set = address.substring(this.sets[0].tagSize, 32 - this.sets[0].blockSize);
   			
   			//if fecth returns "miss" load the the data into the cache that called
    		   if(fetch(address).equals("miss")) {
    			  this.misses++;
       			  this.evictions += this.sets[integerfrmbinary(set)].write(load(RAM, nearestMul(intAddress)), tag, 0, 8);
       			  System.out.println(this.name + " miss"); 
       			  System.out.println("Place in " + this.name + " set " + integerfrmbinary(set));
       			  return "miss";
    		   }
    			   
    		   else {
    			   System.out.println(this.name + " hit");
    			   this.hits++;
    			   return "hit";
    		   }
    		   
    		}
    		
    		public  String dataLoad(String address, int bytes, ArrayList<String> RAM) {
    			int intAddress = Integer.parseInt(address, 16);
        		address = hexToBin(address);
        		
       			String tag = address.substring(0, this.sets[0].tagSize);
       			String set = address.substring(this.sets[0].tagSize, 32 - this.sets[0].blockSize);
       			
       		//if fecth returns "miss" load the the data into the cache that called
        		   if(fetch(address).equals("miss")) {
        			  this.misses++;
           			  this.evictions += this.sets[integerfrmbinary(set)].write(load(RAM, nearestMul(intAddress)), tag, 0, 8);
           			  System.out.println(this.name + " miss"); 
           			  System.out.println("Place in " + this.name + " set " + integerfrmbinary(set));
           			  return "miss";
        		   }
        			   
        		   else {
        			   System.out.println(this.name + " hit");
        			   this.hits++;
        			   return "hit";
        		   }
        		   
    		}
    		
    		public  String dataStore(String address, int bytes, String data, ArrayList<String> RAM) {
    			int intAddress = Integer.parseInt(address, 16);
        		address = hexToBin(address);
        		
       			String tag = address.substring(0, this.sets[0].tagSize);
       			String set = address.substring(this.sets[0].tagSize, 32 - this.sets[0].blockSize);
       			
       		//if fetch returns "miss" writes directly into RAM
       			if(fetch(address).equals("miss")) {
      			  this.misses++;
      			  this.store(RAM, nearestMul(intAddress), data, bytes);
      			  System.out.println(this.name + " miss");
     			  System.out.println("Place in RAM");
     			  return "miss";
      		   }
      			   //Writes in cache that called and RAM
      		   else {
      			 this.store(RAM, nearestMul(intAddress), data, bytes);
      			 this.sets[integerfrmbinary(set)].write(data, tag, 0, bytes);
      			 System.out.println(this.name + " hit");
      			 System.out.println("Place in RAM  " + this.name + " set " + integerfrmbinary(set));
      			 this.hits++;
      			 return "hit";
      		   }
    		}
    		
    		public  void dataModify(String address, int bytes, String data, ArrayList<String> RAM) {
    			this.dataLoad(address, bytes, RAM);
    			this.dataStore(address, bytes, data, RAM);
    		}
    		public String load(ArrayList<String> RAM, int address) {
    			return RAM.get(address);
    		}
    		public void store(ArrayList<String> RAM, int address, String data, int bytes) {
    			RAM.set(address, data + RAM.get(address).substring(bytes));
    		}
    		
    		//finds address that data is in to load cache as a block if RAM is is 8bytes per address returns nearest small 8 mul
    		public  int nearestMul(int address) {
    			int count = 0;
    			while(address != 0) {
    				address /= Math.pow(2, this.sets[0].blockSize);
    				count++;		
    			}
    			return (int) Math.pow(this.sets[0].blockSize, count);
    		}
    		
    		
    		
    		//Searches inside the for data
    		public String fetch(String address){
    			address = hexToBin(address);
    			String tag = address.substring(0, this.sets[0].tagSize);
    			String set = address.substring(this.sets[0].tagSize, 32 - this.sets[0].blockSize);
    			String block = address.substring( tag.length() + set.length(), 32);
    			
    			if(set.equals(""))
    				set = "0";
    			
    			if(this.sets[integerfrmbinary(set)].getBlock(tag, integerfrmbinary(block)).equals("miss")) {
    				return "miss";
    			}
    			else {
    				return this.sets[integerfrmbinary(set)].getBlock(tag, integerfrmbinary(block));
    			}
    		}
    		
    		
    		public static int integerfrmbinary(String str){
    		    double j=0;
    		    for(int i=0;i<str.length();i++){
    		        if(str.charAt(i)== '1'){
    		         j=j+ Math.pow(2,str.length()-1-i);
    		     }

    		    }
    		    return (int) j;
    		}
    		
    		private String hexToBin(String hex){
    			hex = hex.replaceAll("a", "A");
    	        hex = hex.replaceAll("b", "B");
    	        hex = hex.replaceAll("c", "C");
    	        hex = hex.replaceAll("d", "D");
    	        hex = hex.replaceAll("e", "E");
    	        hex = hex.replaceAll("f", "F");
    	        hex = hex.replaceAll("0", "0000");
    	        hex = hex.replaceAll("1", "0001");
    	        hex = hex.replaceAll("2", "0010");
    	        hex = hex.replaceAll("3", "0011");
    	        hex = hex.replaceAll("4", "0100");
    	        hex = hex.replaceAll("5", "0101");
    	        hex = hex.replaceAll("6", "0110");
    	        hex = hex.replaceAll("7", "0111");
    	        hex = hex.replaceAll("8", "1000");
    	        hex = hex.replaceAll("9", "1001");
    	        hex = hex.replaceAll("A", "1010");
    	        hex = hex.replaceAll("B", "1011");
    	        hex = hex.replaceAll("C", "1100");
    	        hex = hex.replaceAll("D", "1101");
    	        hex = hex.replaceAll("E", "1110");
    	        hex = hex.replaceAll("F", "1111");
    	        return hex;
    	    }
       }
       //class for set has blocks,	blocksize and tagsize
       class set{
    	   block[] blocks;
    	   int tagSize;
    	   int blockSize;
    	   public set(int E, int tagSize, int blockSize) {
    		   blocks = new block[E];
    		   this.tagSize = tagSize;
    		   this.blockSize = blockSize;
    		   for(int i = 0; i < E; i++) {
    			   blocks[i] = new block((int)Math.pow(2, blockSize));
    		   }
    	   
    	   }//Checks tag for match
    	   public String getBlock(String tag, int block) {
    		 //  boolean valid = false;
    		   for(int i = 0; i < blocks.length; i++) {
    			   if(!blocks[i].read(block, tag).equals("miss"))
    				   return blocks[i].read(block, tag);
    		   }
    		   return "miss";
    	   }//Finds a place to write data
    	   public int write(String data, String tag, int block, int dataLength) {
    		   for(int i = 0; i < blocks.length; i++) {
    			   if(blocks[i].valid == false) {
    				   blocks[i].valid = true;
    				   blocks[i].tag = tag;
    				   for(int j = block; j < dataLength; j++) {
    					   blocks[i].change(data.substring(2 *j, 2 * j + 2), j);
    				   }
    				   return 0;
    			   }
    				   
    		   }
    		   int max = 0;
    		   for(int i = 0; i <  blocks.length; i++) {
    			   if(blocks[i].time > max)
    				   max = i;
    		   }
    		   blocks[max].tag = tag;
    		   blocks[max].time = 0;
			   for(int j = 0; j < dataLength; j++) {
				   blocks[max].change(data.substring(2 *j, 2 * j + 2), j);
			   }
			   return 1;
    	   }
       }//class for block has an data array 1byte per element "AB" ,	it's time in cache, it's tag and if it's valid or not
       class block{
    	   String[] data;
    	   boolean valid;
    	   int time = 0;
    	   String tag;
    	   public block(int B) {
    		   data = new String[B];
    	   }
    	   
    	   public void change(String data, int index) {
    		   this.data[index] = data;
    	   }
    	   
    	   public String read(int index, String tag){
    		   if(valid == false)
    			   return "miss";
    		   if(!tag.equals(tag))
    			   return "miss";
    		   
    		   return data[index];
    	   }
       }
		   
    	   