//Musa Özkan 150121058
//An object class class 
import java.text.*;
import java.util.*;

public class SmartCamera extends SmartObject implements MotionControl, Comparable {
	//Datafields
	private boolean status;
	private int batteryLife;
	private boolean nightVision;
	//A constructor with a specialized signature
	public SmartCamera(String alias, String macId, boolean nightVision, int batteryLife) {
		super(alias, macId);
		setNightVision(nightVision);
		setBatteryLife(batteryLife);
	}
	//if connection status true sets status true or false depending on the value of itself
	public void recordOn(boolean isDay) {
		if ((super.isConnectionStatus() == true) && (isDay == true)) {
			setStatus(true);
			System.out.println("Smart Camera - " + getAlias() + " is turned on now");
		} else if ((super.isConnectionStatus() == true) && (isDay == false) && (nightVision == true)) {
			setStatus(true);
			System.out.println("Smart Camera - " + getAlias() + " is turned on now");
		} else if ((super.isConnectionStatus() == true) && (isDay == false) && (nightVision == false)) {
			System.out.println("Sorry! Smart Camera - " + getAlias() + " does not have night vision feature.");
		}
	}
	//if connection status true sets status true or false depending on the value of itself
	public void recordOff() {
		if ((super.isConnectionStatus() == true) && (isStatus() == true)) {
			setStatus(false);
			System.out.println("Smart Camera - " + getAlias() + " is turned off now");
		} else if ((super.isConnectionStatus() == true) && (isStatus() == false)) {
			System.out.println("Smart Camera - " + getAlias() + " has been already turned off");
		}
	}
	//if connection status true controls the objects methods and prints out some strings
	@Override
	public boolean testObject() {
		if (super.isConnectionStatus() == true) {
			System.out.println("Test is starting for SmartCamera");
			System.out.println(
					"This is SmartCamera device " + getAlias() + "\n\tMacId: " + getMacId() + "\n\tIP: " + getIP());
			System.out.println("Test is starting for SmartCamera day time");
			this.recordOn(true);
			this.recordOff();
			System.out.println("Test is starting for SmartCamera night time");
			this.recordOn(false);
			this.recordOff();
			System.out.println("Test completed for SmartCamera\n");
			return true;
		}
		return false;
	}
	//Basically closes object and sets datafields depending on that
	@Override
	public boolean shutDownObject() {
		if ((super.isConnectionStatus() == true) && (isStatus() == true)) {
			super.smartObjectToString();
			recordOff();
			return true;
		}
		return false;
	}
	//Controls if there is motion or not by taken value
	@Override
	public boolean controlMotion(boolean hasMotion, boolean isDay) {
		if (hasMotion == false) {
			System.out.println("Motion not detected!");
			return false;
		} else {
			System.out.println("Motion detected!");
			if (isDay == true) {
				recordOn(isDay);
				return true;
			} else {
				if (isNightVision() == true) {
					recordOn(isDay);
					return true;
				}
			}
		}
		return false;
	}
	//Compares cameras battery life to another via if else caluses
	public int compareTo(Object smartCamera) {
		if (batteryLife > ((SmartCamera) smartCamera).getBatteryLife()) {
			return 1;
		}
		if (batteryLife == ((SmartCamera) smartCamera).getBatteryLife()) {
			return 0;
		} else
			return -1;
	}
	//Basically prints a string about the object
	@Override
	public void smartObjectToString() {
		System.out.println(
				"This is SmartCamera device " + getAlias() + "\n\tMacId: " + getMacId() + "\n\tIP: " + getIP());
	}

	@Override
	public String toString() {
		return ("SmartCamera -> " + getAlias() + " battery life is " + getBatteryLife() + " status is recording");
	}
	//Getters and Setters
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

	public boolean isNightVision() {
		return nightVision;
	}

	public void setNightVision(boolean nightVision) {
		this.nightVision = nightVision;
	}

}
