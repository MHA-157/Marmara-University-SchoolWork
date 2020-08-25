//Muhammet Hasan Albayrak 150117053
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class SmartLight extends SmartObject 
     implements LocationControl, Programmable {
       
	 private boolean hasLightTurned;
	 private Calendar programTime;
	 private boolean programAction;
	 
	 //Constractor
	 public SmartLight(String alias, String macId) {
		 super.setAlias(alias);
		 super.setMacId(macId);
		 
	 }
	 //Turns on light
	 public void turnOnLight() {
		 Calendar calendar = Calendar.getInstance();
		 if(this.isConnectionStatus()) {
		 if(!this.isHasLightTurned()) {
			 this.setHasLightTurned(true);
			 System.out.println("Smart Light "+ this.getAlias() + " is turned on now "
				 		+ "(Current time: " + calendar.get(Calendar.HOUR_OF_DAY) + ":"
				 		+ calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND) 
				 		+ " )"
				 );
		 }
		 else
			 System.out.println("Smart Light - "+ this.getAlias() + "  has been already turned on");
		 }
		 else
			 System.out.println("No connection");
	 }
	 
	 //Turns off light
	 public void turnOffLight() {
		 Calendar calendar = Calendar.getInstance();
		 
		 if(this.isConnectionStatus()) {
			 if(this.isHasLightTurned()) {
				 this.setHasLightTurned(false);
				 System.out.println("Smart Light - "+ this.getAlias() +" is turned off now (Current time: " + 
						 calendar.get(Calendar.HOUR_OF_DAY) + ":"
					 		+ calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND) 
					
					 		+ " )" );
			 }
			 else
				 System.out.println("Smart Light - " + this.getAlias() + " has been already turned off");
		 }
		 else
			 System.out.println("No connection");
	 }
	 //Checks the objects properties
	 public boolean testObject() {
		 if(this.isConnectionStatus()) {
			 this.SmartObjectToString();
			 this.turnOnLight();
			 this.turnOffLight();
			 System.out.println("Test completed for SmartLight");
			 return true;
		 }
		 else 
			 return false;
	 }
	 //Terminates object
	 public boolean shutDownObject() {
		 if(this.isConnectionStatus()) {
			 this.SmartObjectToString();
			 if(this.isHasLightTurned())
				 this.turnOffLight();
			 return true;
			 
		 }
		 else
			 return false;
	 }
	 
	 public void onLeave() {
		 if(this.isConnectionStatus()) {
			 
			 System.out.println("On Leave -> Smart Light - " + this.getAlias()); 
			 this.turnOffLight();
					 
		 }
		
	 }
	 
	 public void onCome() {
		 if(this.isConnectionStatus()) {
			 System.out.println("On Come -> Smart Light - " + this.getAlias());
			 this.turnOnLight();
		 }
		
	 }
	 
	 //Sets timer for ligths to open or close
	 public void setTimer(int seconds) {
		 if(this.isConnectionStatus()) {
			 Calendar calendar = Calendar.getInstance();
			 
			 this.setProgramTime(calendar);
			 programTime.add(seconds, seconds);
			
			 if(this.isHasLightTurned()) {
				 System.out.print("Smart light - " + this.getAlias() +"  will be turned off "+ seconds +" seconds later!");
			 this.getCurrentTime();
			 this.setProgramAction(true);
			 }
			 
			 else
				 System.out.print("Smart light - " + this.getAlias() +"  will be turned on "+ seconds +" seconds later!");
			 this.getCurrentTime();
			 this.setProgramAction(false);
		 }
	 }
	 //Cancels timer
	 public void cancelTimer() {
		 if(this.isConnectionStatus()) {
			 this.programTime = null;
		 }
		 
	 }
	 //Uses timer to automatically executes order
	 public void runProgram() {
		 Calendar calendar = Calendar.getInstance();
		 SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		 String date = sdf.format((Calendar.getInstance()).getTime());
		 String programTimer = "";
		 if(!(programTime == null))
			 programTimer = sdf.format(programTime.getTime());
		 if(!(programTime == null))
		 if(this.isConnectionStatus()) {
			 if(programAction)
			 if(date.equals(programTimer)) {
				 System.out.println("RunProgram -> Smart Light - " + this.getAlias());
				 if(this.isProgramAction()) {
					 this.turnOffLight();
				 }
				 else
					 this.turnOnLight();
			 }
		 }
		this.setProgramTime(null);
	 }

	public boolean isHasLightTurned() {
		return hasLightTurned;
	}

	public void setHasLightTurned(boolean hasLightTurned) {
		this.hasLightTurned = hasLightTurned;
	}

	public Calendar getProgramTime() {
		return programTime;
	}

	public void setProgramTime(Calendar programTime) {
		this.programTime = programTime;
	}

	public boolean isProgramAction() {
		return programAction;
	}

	public void setProgramAction(boolean programAction) {
		this.programAction = programAction;
	}
	//Meethod for printing current time
	 public void getCurrentTime() {
		 Calendar calendar = Calendar.getInstance();
		 System.out.println("(Current time: " + calendar.get(Calendar.HOUR_OF_DAY) + ":"
				 		+ calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND) 
				 		+ " )");
	 }
	
}
