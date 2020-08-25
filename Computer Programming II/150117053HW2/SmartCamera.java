//Muhammet Hasan Albayrak 150117053
public class SmartCamera extends SmartObject 
   implements MotionControl, Comparable<SmartCamera> {
	 
	private boolean status;
	private int batteryLife;
	private boolean nigthVision;
	
	//Constractor
	  public SmartCamera(String alias, String macId, boolean nightVision,
			int batteryLife) {
		  super.setAlias(alias);
		  super.setMacId(macId);
		  this.setBatteryLife(batteryLife);
		  this.setNigthVision(nightVision);
		  
	  }
	//Starts recording
	  public void recordOn(boolean isDay) {
		  if(this.isConnectionStatus()) {
			  if(!this.isStatus()) {
				  if(isDay) {
					  this.setStatus(true);
					  System.out.println("Smart Camera - " + this.getAlias() + " is turned on now");
				  }
				  else {
					  if(this.isNigthVision()) {
						  this.setStatus(true);
						  System.out.println("Smart Camera - " + this.getAlias() + " is turned on now");
					  }
					  else
						  System.out.println("Sorry! Smart Camera - " + this.getAlias() + " does not have night vision feature.");
				  }
					  
				  
			  }
			  else
				  System.out.println("Smart Camera - " + this.getAlias() + " has been already turned on");
		  }
	  }
	  //Stops recording
	  public void recordOff() {
		  if(this.isConnectionStatus()) {
			  if(this.isStatus()) {
				  this.setStatus(false);
				  System.out.println("Smart Camera - " + this.getAlias() + " is turned off now");
			  }
			  else
				  System.out.println("Smart Camera - " + this.getAlias() + " has been already turned off");
		  }
	  }
	  //Checks device's propersties
	  public boolean testObject() {
		  if(this.isConnectionStatus()) {
			  this.SmartObjectToString();
			  System.out.println("Test is starting for " + this.getClass().getName() + " day time");
			  this.recordOn(true);
			  this.recordOff();
			  if(this.isNigthVision()) {
				  System.out.println("Test is starting for " + this.getClass().getName() + " night time");
				  this.recordOn(false);
				  this.recordOff();
			  }
			  else
				  System.out.println("Sorry! Smart Camera - " + this.getAlias() + " does not have night vision feature.");
			  
			  System.out.println("Test completed for " + this.getClass().getName());
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
					 this.recordOff();
				 return true;
				 
			 }
			 else
				 return false;
	  }
	  //Stars recording if there is motion
	  public boolean controlMotion(boolean hasMotion, boolean isDay) {
		  if(hasMotion) {
			  System.out.println("Motion detected!");
			  if(isDay) {
				  this.recordOn(true);
				  return true;
			  }
			  else {
				  if(this.isNigthVision()) {
					  this.recordOn(false);
					  return true;
				  }
				  else
					  System.out.println("No night vision");
				  return false;
			  }
		  }
		  else
			  System.out.println("Motion not detected!");
		  return false;
	  }
	
	  //Sorts cameras by their battery light
	  public int compareTo(SmartCamera smartCamera) {
		 if(this.getBatteryLife() < smartCamera.getBatteryLife() )
			 return 1;
		 if(!(this.getBatteryLife() < smartCamera.getBatteryLife()))
			 return -1;
		 
		 return 0;
	  }

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getBatteryLife() {
		return batteryLife;
	}

	public void setBatteryLife(int batteryLife) {
		this.batteryLife = batteryLife;
	}

	public boolean isNigthVision() {
		return nigthVision;
	}

	public void setNigthVision(boolean nigthVision) {
		this.nigthVision = nigthVision;
	}

	@Override
	public String toString() {
		if(this.isStatus())
		return  this.getClass().getName() +" -> "+ this.getAlias() + "'s battery life is "
				+ this.getBatteryLife() + "  status is recording"; 
		else
			return  this.getClass().getName() +" -> "+ this.getAlias() + "'s battery life is "
			+ this.getBatteryLife() + "  status is not recording"; 
	}
	  

}
