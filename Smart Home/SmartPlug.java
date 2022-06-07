//Musa Özkan 150121058
//An object class class 
import java.text.SimpleDateFormat;
import java.util.*;

public class SmartPlug extends SmartObject implements Programmable {
	//Datafields
	private boolean status;
	private Calendar programTime = Calendar.getInstance();
	private boolean programAction;
	//A constructor with a specialized signature
	public SmartPlug(String alias, String macId) {
		super(alias, macId);
	}
	//if connection status true sets status true or false depending on the value of itself
	public void turnOn() {
		if (super.isConnectionStatus() == true) {
			if (isStatus() == true) {
				System.out.println("Smart Plug - " + getAlias() + " has been already turned on");
			} else
				setStatus(true);
			System.out.println(
					"Smart Plug - " + getAlias() + " is turned on now (Current time: " + currentTimeString() + ")");
		}
	}
	//if connection status true sets status true or false depending on the value of itself
	public void turnOff() {
		if (super.isConnectionStatus() == true) {
			if (isStatus() == true) {
				setStatus(false);
				System.out.println("Smart Plug - " + getAlias() + " is turned off now (Current time: "
						+ currentTimeString() + ")");
			} else {
				System.out.println("Smart Plug - " + getAlias() + " has been already turned off");
			}
		}
	}
	//if connection status true controls the objects methods and prints out some strings
	@Override
	public boolean testObject() {
		if (super.isConnectionStatus() == true) {
			System.out.println("Test is starting for SmartPlug");
			System.out.println(
					"This is SmartPlug device " + getAlias() + "\n\tMacId: " + getMacId() + "\n\tIP: " + getIP());
			turnOn();
			turnOff();
			System.out.println("Test completed for SmartPlug\n");
			return true;
		}
		return false;
	}
	//Basically closes object and sets datafields depending on that
	@Override
	public boolean shutDownObject() {
		if (super.isConnectionStatus() == true) {
			super.smartObjectToString();
			if (isStatus() == true) {
				turnOff();
				return true;
			}
		}
		return false;
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
			if (isStatus() == true) {
				setProgramAction(false);
				setStatus(false);
				System.out.println("Smart plug - " + getAlias() + " will be turned off " + seconds
						+ " seconds later! (Current time: " + currentTimeString() + ")");
			} else {
				setProgramAction(true);
				setStatus(true);
				System.out.println("Smart plug - " + getAlias() + " will be turned on " + seconds
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
				System.out.println("RunProgram -> Smart Plug - " + getAlias()); // gonna use objects name later
				if (isStatus() == true) {
					turnOff();
				} else
					turnOn();
			}
		}
	}
	//Basically prints a string about the object
	@Override
	public void smartObjectToString() {
		System.out
				.println("This is SmartPlug device " + getAlias() + "\n\tMacId: " + getMacId() + "\n\tIP: " + getIP());
	}
	//Getters and Setters
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
