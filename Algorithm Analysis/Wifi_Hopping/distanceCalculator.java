/******************** MUHAMMET HASAN ALBAYRAK 150117053  CSE - 2046 
 ***************************  HWW#1-1   ********************* */
//This program finds fastest distance between two agents
import java.io.*;
import java.util.ArrayList;
public class distanceCalculator {
 public static int hopped  = 0;
 public static String out = "";
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String[] sss = new String[1];
		
		
		File output = new File("output.txt");
		String[] data = new String[3];
		FileWriter fr = null;
		fr = new FileWriter(output);
		File file = new File(args[0]);
		
		BufferedReader reader ;
		System.out.println();
		reader = new BufferedReader(new FileReader(file));
		String c;
		int numberOflaptops = Integer.parseInt(reader.readLine());
		ArrayList<laptop> laptops = new ArrayList<laptop>(numberOflaptops);
		while ((c = reader.readLine()).length() != 0) {
		data = c.split("\\s+");
		laptop laptop = new laptop(Double.parseDouble(data[0]), Double.parseDouble(data[1]), Double.parseDouble(data[2]));
		laptops.add(laptop);
		
		}
		for(int i = 0; i < numberOflaptops; i++) {
			for(int j = 0; j < numberOflaptops; j++) {
				if(laptops.get(i) != laptops.get(j)) {
					dis(laptops.get(i), laptops.get(j));
					
				}
			}
		}
		for(int i = 1; i < numberOflaptops; i++) {
			hop(laptops.get(1), laptops.get(i));
		}
		
		fr.write(out);
		fr.close();
	}
	//dis=Math. sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
	public static void dis(laptop laptop1, laptop laptop2) {
		double dis = Math.sqrt((laptop2.x-laptop1.x)*(laptop2.x-laptop1.x) + (laptop2.y-laptop1.y)*(laptop2.y-laptop1.y));
		System.out.print(dis);
		if(laptop1.range + laptop2.range >= dis) {
			if(!(laptop1.inrange.contains(laptop2)))
				laptop1.inrange.add(laptop2);
			if(!(laptop2.inrange.contains(laptop1)))
				laptop2.inrange.add(laptop1);
		}
	}
	
	public static void hop(laptop laptop1, laptop laptop2) {
		boolean path = false;
		hopped++;
		
		if(laptop1.inrange.contains(laptop2)){ 
			out += hopped;
			out += "\n";
			hopped = 0;
			return;
		}
			
		
		for(int i = 0; i < laptop1.inrange.size(); i++ ) {
			hop(laptop1.inrange.get(i), laptop2);
		}
	}

}
