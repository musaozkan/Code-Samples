//Musa Özkan 150121058
//A specified object class
import java.util.*;

public class Employee extends Person {
	private double salary;
	private java.util.Calendar hireDate;
	private Department department;
	public static int numberOfEmployees=0;

	public Employee(int id, String firstName, String lastName, String gender, Calendar birthDate, String maritalStatus,
			String hasDriverLicence, double salary, Calendar hireDate, Department department) {
		super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicence);
		this.numberOfEmployees++;
	}

	public Employee(Person person, double salary, Calendar hireDate, Department department) {
		super(person.getId(), person.getFirstName(), person.getLastName(), person.getGender(), person.getBirthDate(), person.getMaritalStatus(), person.getHasDriverLicence());
		setSalary(salary);
		setHireDate(hireDate);
		setDepartment(department);	
		this.numberOfEmployees++;
	}

	public double raiseSalary(double percent) {
		return salary * (1 + percent);
	}

	public double raiseSalary(int amount) {
		return salary + amount;
	}

	// Getters and Setters
	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getSalary() {
		return salary;
	}

	public void setHireDate(Calendar hireDate) {
		this.hireDate = hireDate;
	}

	public Calendar getHireDate() {
		return hireDate;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}

	public Department getDepartment() {
		return department;
	}

	public void setNumberOfEmployees(int numberofEmployees) {
		this.numberOfEmployees = numberofEmployees;
	}

	public double getNumberOfEmployees() {
		return numberOfEmployees;
	}

	// Getters and Setters
	public String infos() {
		return super.infos() + salary + " " + test.dateFormat(hireDate) ;
	}
	@Override
	public String toString() {
		return ("Salary: " + getSalary() + " Department Name: " + department.getDepartmentName()); 
	}
}
