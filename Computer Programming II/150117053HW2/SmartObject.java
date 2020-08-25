//Muhammet Hasan Albayrak 150117053
import java.util.Calendar;

public abstract class SmartObject {
	private String alias;
	private String macId;
	private String IP;
	private boolean connectionStatus;
	
	//Constractor
	 public SmartObject() {
		 
	 }
	 //Takes IP and connects device
	 public boolean connect(String IP) {
		 setIP(IP);
		 setConnectionStatus(true);
		 if(isConnectionStatus()) {
		 System.out.println(getAlias() + " connection established.");
		 return true;
		 }
		 return false;
	 }
	 //Disconnects devie
	 public boolean disconnect() {
		 setIP(null);
		 setConnectionStatus(false);
		 if(!isConnectionStatus()) {
			 System.out.println(getAlias() + " connection abolished.");
			 return true;
			 }
			 return false;
	 }
	 //Prints device's information
	 public void SmartObjectToString() {
		 System.out.println("This is " + this.getClass().getName() + " device " + 
	     this.getAlias() + "\n" + 
				 "MacOd : " + this.getMacId() + "\n" +
	     "IP : " + this.getIP());
		 
	 }
	 //Check connection
	 public boolean controlConnection() {
		 
		 if(!this.isConnectionStatus()) {
			 System.out.println("This device is not connected. " + this.getClass().getName() + 
					 "-> " + this.getAlias());
		 }
		 
		 return true;
	 }
	 //Abstrac method for subclases
	 public abstract boolean testObject(); 
		 
	 
	 
	 public abstract boolean shutDownObject(); 
		 
	 

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getMacId() {
		return macId;
	}

	public void setMacId(String macId) {
		this.macId = macId;
	}

	public String getIP() {
		return IP;
	}

	public void setIP(String iP) {
		IP = iP;
	}

	public boolean isConnectionStatus() {
		return connectionStatus;
	}

	public void setConnectionStatus(boolean connectionStatus) {
		this.connectionStatus = connectionStatus;
	}
	//Method for printing out current time for subclasses
	public void getCurrentTime() {
		 Calendar calendar = Calendar.getInstance();
		 System.out.println("(Current time: " + calendar.get(Calendar.HOUR_OF_DAY) + ":"
				 		+ calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND) 
				 		+ " )");
	 }

}
