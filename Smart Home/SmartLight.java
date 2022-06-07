//Musa Özkan 150121058
//An object class class 
import java.text.*;
import java.util.*;

public class SmartLight extends SmartObject implements LocationControl, Programmable {
	//Datafields
	private boolean hasLightTurned;
	private Calendar programTime = Calendar.getInstance();
	private boolean programAction;
	//A constructor with a specialized signature
	public SmartLight(String alias, String macId) {
		super(alias, macId);
	}
	//if connection status true sets haslLightTurned true or false depending on the value of itself
	public void turnOnLight() {
		if (super.isConnectionStatus() == true) {
			if (isHasLightTurned() == true) {
				System.out.println("Smart Light - " + getAlias() + " has been already turned on");
			} else {
				setHasLightTurned(true);
				System.out.println("Smart Light - " + getAlias() + " is turned on now (Current time: "
						+ currentTimeString() + ")");
			}
		}
	}
	//if connection status true sets haslLightTurned true or false depending on the value of itself
	public void turnOffLight() {
		if (super.isConnectionStatus() == true) {
			if (isHasLightTurned() == true) {
				setHasLightTurned(false);
				System.out.println("Smart Light - " + getAlias() + " is turned off now (Current time: "
						+ currentTimeString() + ")");
			} else {
				System.out.println("Smart Light - " + getAlias() + " has been already turned off");
			}
		}
	}
	//if connection status true controls the objects methods and prints out some strings
	@Override
	public boolean testObject() {
		if (super.isConnectionStatus() == true) {
			System.out.println("Test is starting for SmartLight");
			System.out.println(
					"This is SmartLight device " + getAlias() + "\n\tMacId: " + getMacId() + "\n\tIP: " + getIP());
			turnOnLight();
			turnOffLight();
			System.out.println("Test completed for SmartLight\n");
			return true;
		}
		return false;
	}
	//Basşcally closes object and sets datafields depending on that
	@Override
	public boolean shutDownObject() {
		if (super.isConnectionStatus() == true) {
			super.smartObjectToString();
			if (isHasLightTurned() == true) {
				turnOffLight();
				return true;
			}
		}
		return false;
	}
	//If all true, it closes lights and sets datafields depending on that
	@Override
	public void onLeave() {
		if (super.isConnectionStatus() == true) {
			if (isHasLightTurned() == true) {
				System.out.println("On Come -> Smart Light - " + getAlias());
				turnOffLight();
			}
		}
	}
	//If all true, it opens lights and sets datafields depending on that
	@Override
	public void onCome() {
		if (super.isConnectionStatus() == true) {
			if (isHasLightTurned() == false) {
				System.out.println("On Come -> Smart Light - " + getAlias());
				turnOnLight();
			}
		}
	}
	//It sets programAction to true or false depending on the second value taken
	@Override
	public void setTimer(int seconds) {
		if (super.isConnectionStatus() == true) {
			Date date = new Date(System.currentTimeMillis() + seconds * 1000);
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.HOUR, date.getHours());
			calendar.set(Calendar.MINUTE, date.getMinutes());
			calendar.set(Calendar.SECOND, date.getSeconds());
			setProgramTime(calendar);
			if (isHasLightTurned() == true) {
				setProgramAction(false);
				setHasLightTurned(false);
				System.out.println("Smart light - " + getAlias() + " will be turned off " + seconds
						+ " seconds later! (Current time: " + currentTimeString() + ")");
			} else {
				setProgramAction(true);
				setHasLightTurned(true);
				System.out.println("Smart light - " + getAlias() + " will be turned on " + seconds
						+ " seconds later! (Current time: " + currentTimeString() + ")");
			}
		}
	}
	//It sets programTime to null 
	@Override
	public void cancelTimer() {
		if (super.isConnectionStatus() == true) {
			setProgramTime(null);
		}
	}
	//It runs the program depending on the current time and the taken time
	@Override
	public void runProgram() {
		Date date = getProgramTime().getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		if (super.isConnectionStatus() == true) {
			if ((formatter.format(date)).equals(currentTimeString())) {
				System.out.println("RunProgram -> Smart Light - " + getAlias()); 
				if (isHasLightTurned() == true) {
					turnOffLight();
				} else
					turnOnLight();
			}
		}
	}
	//Basically prints a string about the object
	@Override
	public void smartObjectToString() {
		System.out
				.println("This is SmartLight device " + getAlias() + "\n\tMacId: " + getMacId() + "\n\tIP: " + getIP());
	}
	//Getters and Setters
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

}
