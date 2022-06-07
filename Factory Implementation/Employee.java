// Musa Özkan 150121058 
// This class simply creates Employee objects 
public class Employee { // represents an employee working for the factory.
	private int id; // keeps the id number of the Employee object created.
	private String name;
	private String surname;
	private int workHour; // keeps the number of hours an employee will work.
	private int speed; // keeps the number of items that the employee can produce in an hour.
	private Item[] items; // array holds the items produced by the employee.
	private Payroll payroll;

	//
	public Employee(int id, String name, String surname, int workHour, int speed) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.workHour = workHour;
		this.speed = speed;
	}

	public Item[] startShift() {
		int total = this.speed * this.workHour;
		items = new Item[100];
		for (int i = 0; i < total; i++) {
			items[i] = new Item((int) (Math.random() * 100) + 1); 
			}
		return items;
	}

	public Payroll endShift() {
		return new Payroll(this.workHour, this.workHour*this.speed);
	}

	public String toString() {
		return ("This is the employee with id " + this.id + " speed " + this.speed + ". " + "The work hour is "
				+ this.workHour + " and the produced item count is " + this.speed*this.workHour);
	}
	
	
	/* Getters and Setters */
	
	public int getId() {
		return this.id;
	}
	public int getWorkHour() {
		return this.workHour;
	}
	public int getSpeed() {
		return this.speed;
	}
	
	/* No-Arg Constructor */
	public Employee() {
		
	}
}

		
		


