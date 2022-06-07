//Musa Özkan 150121058
//An object class class 
import java.util.*;

public class SmartHome {
	//An arraylist
	private ArrayList<SmartObject> smartObjectList = new ArrayList<SmartObject>();
	//Noarg constructor
	public SmartHome() {

	}
	//Adds objects
	public boolean addSmartObject(SmartObject smartObject) {
		smartObjectList.add(smartObject);
		String IP = "10.0.0." + (99 + smartObjectList.size());
		System.out.println("--------------------------------------------------------------------------\r\n"
				+ "--------------------------------------------------------------------------\r\n"
				+ "Adding new SmartObject\r\n"
				+ "--------------------------------------------------------------------------");
		smartObject.connect(IP);
		smartObject.testObject();
		return true;
	}
	// removes objects
	public boolean removeSmartObject(SmartObject smartObject) {
		smartObjectList.remove(smartObject);
		return true;
	}
	//controls location
	public void controlLocation(boolean onCome) {
		System.out.println("--------------------------------------------------------------------------\r\n"
				+ "--------------------------------------------------------------------------\r\n"
				+ "LocationControl : OnCome\r\n"
				+ "--------------------------------------------------------------------------");
		for (int i = 0; i < smartObjectList.size(); i++) {
			if (smartObjectList.get(i) instanceof LocationControl) {
				if (onCome == true) {
					((SmartLight) smartObjectList.get(i)).onCome();
				} else
					((SmartLight) smartObjectList.get(i)).onLeave();
			}
		}
	}
	//controls motion
	public void controlMotion(boolean hasMotion, boolean isDay) {
		System.out.println("--------------------------------------------------------------------------\r\n"
				+ "--------------------------------------------------------------------------\r\n"
				+ "MotionControl: HasMotion, isDay\r\n"
				+ "--------------------------------------------------------------------------");
		for (int i = 0; i < smartObjectList.size(); i++) {
			if (smartObjectList.get(i) instanceof MotionControl) {
				((SmartCamera) smartObjectList.get(i)).controlMotion(hasMotion, isDay);
			}
		}
	}
	//runs runProgram by checking given needs
	public void controlProgrammable() {
		System.out.println("--------------------------------------------------------------------------\r\n"
				+ "--------------------------------------------------------------------------\r\n"
				+ "Programmable: runProgram\r\n"
				+ "--------------------------------------------------------------------------");
		for (int i = 0; i < smartObjectList.size(); i++) {
			if ((smartObjectList.get(i) instanceof Programmable) && (smartObjectList.get(i) instanceof SmartLight)) {
				((SmartLight) smartObjectList.get(i)).runProgram();
			} else if ((smartObjectList.get(i) instanceof Programmable)
					&& (smartObjectList.get(i) instanceof SmartPlug)) {
				((SmartPlug) smartObjectList.get(i)).runProgram();
			}
		}
	}
	//Sets and controls programTimer
	public void controlTimer(int seconds) {
		System.out.println("--------------------------------------------------------------------------\r\n"
				+ "--------------------------------------------------------------------------\r\n"
				+ "Programmable: Timer = " + seconds + " seconds\r\n"
				+ "--------------------------------------------------------------------------");
		for (int i = 0; i < smartObjectList.size(); i++) {
			if ((smartObjectList.get(i) instanceof Programmable) && (smartObjectList.get(i) instanceof SmartLight)) {
				if (seconds > 0) {
					((SmartLight) smartObjectList.get(i)).setTimer(seconds);
				} else if (seconds == 0) {
					((SmartLight) smartObjectList.get(i)).cancelTimer();
				}
			} else if ((smartObjectList.get(i) instanceof Programmable)
					&& (smartObjectList.get(i) instanceof SmartPlug)) {
				if (seconds > 0) {
					((SmartPlug) smartObjectList.get(i)).setTimer(seconds);
				} else if (seconds == 0) {
					((SmartPlug) smartObjectList.get(i)).cancelTimer();
				}
			}
		}
	}
	//Sets and controls program timer randomly
	public void controlTimerRandomly() {
		System.out.println("--------------------------------------------------------------------------\r\n"
				+ "--------------------------------------------------------------------------\r\n"
				+ "Programmable: Timer = 5 or 10 seconds randomly\r\n"
				+ "--------------------------------------------------------------------------");
		int seconds = 0;
		for (int i = 0; i < smartObjectList.size(); i++) {
			seconds = (int)(Math.random()*2+1);
			if ((smartObjectList.get(i) instanceof Programmable) && (smartObjectList.get(i) instanceof SmartLight)) {
				if (seconds == 1) {
					((SmartLight) smartObjectList.get(i)).setTimer(5);
				} else if (seconds == 2) {
					((SmartLight) smartObjectList.get(i)).setTimer(10);
				}else if (seconds == 0) {
					((SmartLight) smartObjectList.get(i)).cancelTimer();
				}
			} else if ((smartObjectList.get(i) instanceof Programmable)
					&& (smartObjectList.get(i) instanceof SmartPlug)) {
				if (seconds == 1) {
					((SmartPlug) smartObjectList.get(i)).setTimer(5);
				} else if (seconds == 0) {
					((SmartPlug) smartObjectList.get(i)).cancelTimer();
				} else if (seconds == 2) {
					((SmartPlug) smartObjectList.get(i)).setTimer(10);
				}
			}
		}
	}
	//Sorts cameras via their battery life
	public void sortCameras() {
		System.out.println("--------------------------------------------------------------------------\r\n"
				+ "--------------------------------------------------------------------------\r\n"
				+ "Sort Smart Cameras\r\n"
				+ "--------------------------------------------------------------------------");
		ArrayList smartCameraBatteryLifeList = new ArrayList();
		
		for(int i = 0 ; i<smartObjectList.size() ; i++) {
			if(smartObjectList.get(i) instanceof Comparable) {
				smartCameraBatteryLifeList.add(smartObjectList.get(i));
			}
		}
		
		Collections.sort(smartCameraBatteryLifeList);
		
		for(int i = 0 ; i<smartCameraBatteryLifeList.size() ; i++ ) {
			System.out.println(smartCameraBatteryLifeList.get(i));
		}
	}
	//Getters Setters
	public ArrayList<SmartObject> getSmartObjectList() {
		return smartObjectList;
	}

	public void setSmartObjectList(ArrayList<SmartObject> smartObjectList) {
		this.smartObjectList = smartObjectList;
	}

}
