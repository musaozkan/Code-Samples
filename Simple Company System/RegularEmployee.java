//Musa Özkan 150121058
//A specified object class

import java.util.*;

public class RegularEmployee extends Employee {
	private double performanceScore;
	private double bonus;
	
	public RegularEmployee(int id, String firstName, String lastName, String gender, Calendar birthDate, String maritalStatus, String hasDriverLicence, double salary, Calendar hireDate, Department department, double performanceScore) {
		super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicence, salary, hireDate, department);
	}
	
	public RegularEmployee(Employee employee, double performanceScore) {
		super((Person)employee, employee.getSalary(), employee.getHireDate(), employee.getDepartment());
		setPerformanceScore(performanceScore);
	}
	
	//Getters and Setters
	public void setPerformanceScore(double performanceScore) {
		this.performanceScore = performanceScore;
	}
	public double getPerformanceScore() {
		return performanceScore;
	}
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	public double getBonus() {
		return bonus;
	}
	//Getters and Setters
	public String infos() {
		return super.infos() + " " + performanceScore + " " + bonus ;
	}
	@Override
	public String toString() {
		return ("Regular Employee Performance Score: " + performanceScore); 
	}
}
