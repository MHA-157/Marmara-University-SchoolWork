//Muhammet Hasan Albayrak 150117053
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SmartPlug extends SmartObject 
    implements Programmable  {
     
	private boolean status;
	private Calendar programTime;
	private boolean programAction;
	
	
	//Constractor
	public SmartPlug(String alias, String macId) {
		super.setAlias(alias);
		super.setMacId(macId);
	}
	//Turns on plug
	public void turnOn() {
		if(this.isConnectionStatus()) {
			if(!this.isStatus()) {
				this.setStatus(true);
				System.out.print("Smart Plug - " + this.getAlias() + " is turned on now");
				this.getCurrentTime();
			}
			else
				System.out.println("Smart Plug - " + this.getAlias() + "  has been already turned on");
		}
		
	}
	//Turns off plug
	public void turnOff() {
		if(this.isConnectionStatus()) {
			if(this.isStatus()) {
				this.setStatus(false);
				System.out.print("Smart Plug - " + this.getAlias() + " is turned off now");
				this.getCurrentTime();
			}
			else
				System.out.println("Smart Plug - " + this.getAlias() + "  has been already turned off");
		}
	}
	//Checks properties
	public boolean testObject() {
		if(this.isConnectionStatus()) {
			 this.SmartObjectToString();
			 this.turnOn();
			 this.turnOff();
			 System.out.println("Test completed for SmartPlug");
			 return true;
		 }
		 else 
			 return false;
	}
	//Terminates device
	public boolean shutDownObject() {
		 if(this.isConnectionStatus()) {
			 this.SmartObjectToString();
			 if(this.isStatus())
				 this.turnOff();
			 return true;
			 
		 }
		 else
			 return false;
	}
	//Sets timer by orders
	public void setTimer(int seconds) {
		 if(this.isConnectionStatus()) {
			 Calendar calendar = Calendar.getInstance();
			 this.setProgramTime(calendar);
			 programTime.add(seconds, seconds);
			 if(this.isStatus()) {
				 System.out.print("Smart plug - " + this.getAlias() +"  will be turned off "+ seconds +" seconds later!");
			 this.getCurrentTime();
			 this.setProgramAction(true);
			 }
			 else
				 System.out.print("Smart plug - " + this.getAlias() +"  will be turned on "+ seconds +" seconds later!");
			 this.getCurrentTime();
			 this.setProgramAction(false);
		 }
		
	}
	//Cancel order timer
	public void cancelTimer() {
		if(this.isConnectionStatus()) {
			 this.programTime = null;
		 }
	}
	//Executes timed order
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
				 System.out.println("RunProgram -> Smart Plug - " + this.getAlias());
				 if(this.isProgramAction()) {
					 this.turnOff();
				 }
				 else
					 this.turnOn();
			 }
		 }
		this.setProgramTime(null);
		
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
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
	
	
}
