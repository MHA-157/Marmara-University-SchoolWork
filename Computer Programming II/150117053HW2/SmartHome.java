//Muhammet Hasan Albayrak 150117053
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class SmartHome {
	 
	 private ArrayList<SmartObject> smartObjectList;
	 
	 // Constractor
	  public SmartHome() {
		  
	  }
	  //Adds smart object to list and connects it
	  public boolean addSmartObject(SmartObject smartObject) {
		 System.out.println("---------------------------------------------------------------------------");
		 System.out.println("Adding new SmartObject");
		 System.out.println("---------------------------------------------------------------------------");
		  ArrayList<SmartObject> smartObjects = new ArrayList<>();
		  smartObjects.add(smartObject);
		  smartObject.setIP("10.0.0." + 100 + smartObjects.indexOf(smartObject));
		  smartObject.connect(smartObject.getIP());
		  smartObject.testObject();
		  this.smartObjectList = smartObjects;
		  if(smartObjects.contains(smartObject))
			  return true;
		  return false;
		  
	  }
	  //
	  public boolean removeSmartObject(SmartObject smartObject) {
		  smartObjectList.remove(smartObject);
		  
		  if(smartObject.disconnect()) {
			  return true;
			  
		  }
		  return false;
		  
	  }
	  //Sets on order for light
	  public void controlLocation(boolean onCome) {
		  for(SmartObject smartObject: smartObjectList) {
			  if(smartObject instanceof SmartLight) {
				  if(onCome) 
					  ((SmartLight) smartObject).onCome();
				  else
					  ((SmartLight) smartObject).onLeave();
			  }
		  }
	  }
	  // Orders camera to if there is motion
	  public void controlMotion(boolean hasMotion, boolean isDay) {
		  System.out.println("---------------------------------------------------------------------------\r\n" + 
		  		"MotionControl : HasMotion, isDay\r\n" + 
		  		"---------------------------------------------------------------------------");
		  for(SmartObject smartObject: smartObjectList) {
			  if(smartObject instanceof SmartCamera) {
				  ((SmartCamera) smartObject).controlMotion(hasMotion, isDay);
			  }
		  }
	  }
	  //Executes timed orders
	  public void controlProgrammable() {
		  System.out.println("---------------------------------------------------------------------------\r\n" + 
		  		"Programmable : runProgram\r\n" + 
		  		"---------------------------------------------------------------------------");
		  for(SmartObject smartObject: smartObjectList) {
			  if(smartObject instanceof Programmable  ) {
				  ((SmartPlug) smartObject).runProgram();
			  }
			  if( smartObject instanceof Programmable ) {
				  ((SmartLight) smartObject).runProgram();
			  }
		  }
	  }
	  //Sets on timer
	  public void controlTimer(int seconds) {
		  System.out.println("---------------------------------------------------------------------------\r\n" + 
		  		"Programmable : Timer = " + seconds + " seconds\r\n" + 
		  		"---------------------------------------------------------------------------");
		  for(SmartObject smartObject: smartObjectList) {
			  if(smartObject instanceof Programmable ) {
				  if(seconds > 0)
				  ((SmartPlug) smartObject).setTimer(seconds);
				  if(seconds == 0)
					  ((SmartPlug) smartObject).cancelTimer();
			  }
			  if( smartObject instanceof Programmable ) {
				if(seconds > 0)
					  ((SmartPlug) smartObject).setTimer(seconds);
				if(seconds == 0)
						  ((SmartPlug) smartObject).cancelTimer();
				  }
			  }
		  }
	  
	  //Checks timers
	  public void controlTimerRandomly() {
		  System.out.println("---------------------------------------------------------------------------\r\n" + 
		  		"Programmable : Timer = 0, 5 or 10 seconds randomly\r\n" + 
		  		"---------------------------------------------------------------------------");
		  for(SmartObject smartObject: smartObjectList) {
			  if(smartObject instanceof Programmable  ) {
				  if(!(this.getRandom() == 0)) {
					  ((SmartPlug) smartObject).setTimer(getRandom());
				  }
				  else
					  ((SmartPlug) smartObject).cancelTimer();
			  }
			  if( smartObject instanceof Programmable ) {
				  if(!(this.getRandom() == 0)) {
					  ((SmartPlug) smartObject).setTimer(getRandom());
				  }
				  else
					  ((SmartPlug) smartObject).cancelTimer();
			  }
		  }
	  }
	  //Sorts cameras by batterylife and prints them
	  public void sortCameras() {
		  System.out.println("---------------------------------------------------------------------------\r\n" + 
		  		"Sort Smart Cameras\r\n" + 
		  		"---------------------------------------------------------------------------");
		  ArrayList<SmartCamera> smartCameras = new ArrayList<>();
		  for(SmartObject smartObject: smartObjectList) {
			  if(smartObject instanceof Comparable) {
				 smartCameras.add((SmartCamera) smartObject);
			  }
		  }
		  
		  Object[] cameras = smartCameras.toArray();
		  Arrays.sort(cameras);
		  
		  for(Object smartCamera: cameras) {
			  System.out.println(smartCamera.toString());
		  }
		  
	  }

	public ArrayList<SmartObject> getSmartObjectList() {
		return smartObjectList;
	}

	public void setSmartObjectList(ArrayList<SmartObject> smartObjectList) {
		this.smartObjectList = smartObjectList;
	}
	//Generates a random number for random timer
	  public int getRandom() {
		  int random = (int)(Math.random() * 10);
		  if(random < 5)
			  random = 0;
		  if(random > 5)
			  random = 10;
		  if(random == 5);
		  random = 5;
		  
		  return random;
	  }
}

