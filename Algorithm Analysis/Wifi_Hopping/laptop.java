import java.util.ArrayList;
 
public class laptop {
public double x;
public double y;
public double range;
public ArrayList<laptop> inrange;
public int hop;
 public laptop(double d, double e, double f){
	 this.x = d;
	 this.y = e;
	 this.range = f;
	 inrange = new ArrayList<laptop>();
 }
  public void addInRange(laptop loptap) {
	  inrange.add(loptap);
  }
 
  
}
