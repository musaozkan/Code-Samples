//Musa Özkan 150121058
//An abstract object class 
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public abstract class SmartObject {
	//Datafields
	private String alias; // Name of the smart device
	private String macId; // Each device has unique macId to connect to the internet
	private String IP; // Internet Protocol for communicating with other devices on internet
	private boolean connectionStatus; // Whether device is connected or not
	//No-arg constructor
	public SmartObject() {

	}
	//A constructor with a specialized signature
	public SmartObject(String alias, String macId) {
		setAlias(alias);
		setMacId(macId);
	}
	//A method that gets current time from System and converts it to string 
	public String currentTimeString() {
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date(System.currentTimeMillis());
		return formatter.format(date);
	}
	//A method that gets current time from System and converts it to Calendar object
	public Calendar currentTimeCalendar() {
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date(System.currentTimeMillis());
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR, date.getHours());
		calendar.set(Calendar.MINUTE, date.getMinutes());
		calendar.set(Calendar.SECOND, date.getSeconds());
		return calendar;
	}
	//A method that sets Ip value and connection status that it gets , prints string and returns true if the implementation happened 
	public boolean connect(String Ip) {
		setIP(Ip);
		setConnectionStatus(true);
		System.out.println( getAlias() + " connection established");
		return true;
	}
	//A method that sets Ip null and connection status false, then if it happens, returns true
	public boolean disconnect() {
		setIP(null);
		setConnectionStatus(false);
		return true;
	}
	//Basically prints a string about the object
	public void smartObjectToString() {
		System.out.println("This is " + getAlias() + "\n\tMacId: " + getMacId() + "\n\tIP: " + getIP()); 
	}
	//Controls connection and returns true or false depending on the connection status
	public boolean controlConnection() {
		if (isConnectionStatus() == true) {
			return true;
		} else
			System.out.println("This device is not connected. " + /* className */" -> " + getAlias()); 
		return false;
	}
	//An abstract method
	public abstract boolean testObject();
	//An abstract method
	public abstract boolean shutDownObject();
	//Getters and Setters
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

	public void setIP(String IP) {
		this.IP = IP;
	}

	public boolean isConnectionStatus() {
		return connectionStatus;
	}

	public void setConnectionStatus(boolean connectionStatus) {
		this.connectionStatus = connectionStatus;
	}

}
