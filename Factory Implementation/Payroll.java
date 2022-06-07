// Musa Özkan 150121058 
// This class simply creates payroll objects and calculates salary with calculateSalary() method and prints sentences about it.
public class Payroll {
	private int workHour; //
	private int itemCount; //
	//Constructor
	public Payroll(int workHour, int itemCount) {
		this.workHour = workHour;
		this.itemCount = itemCount;
	}
	// Calculates Salaries
	public int calculateSalary() {
		return (this.workHour * 3)+(this.itemCount*2);
	}
	// It writes down the things we want
	public String toString() {
		return ("The work hour is " + this.workHour + " and the produced item count is " + this.itemCount + ".");
	}
}
