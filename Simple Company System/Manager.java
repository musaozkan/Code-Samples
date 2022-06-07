//Musa Özkan 150121058
//A specified object class

import java.util.*;

public class Manager extends Employee {

	private ArrayList<RegularEmployee> regularEmployees;
	private double bonusBudget;

	public Manager(int id, String firstName, String lastName, String gender, Calendar birthDate, String maritalStatus, String hasDriverLicence, double salary, Calendar hireDate, Department department, double bonusBudget) {
		super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicence, salary, hireDate, department);
	}

	public Manager(Employee employee, double bonusBudget) {
		super(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getGender(), employee.getBirthDate(), employee.getMaritalStatus(), employee.getHasDriverLicence(), employee.getSalary(), employee.getHireDate(), employee.getDepartment());
		setBonusBudget(bonusBudget);
	}

	public void addEmployee(RegularEmployee e) {
		regularEmployees.add(e);
	}

	public void removeEmployee(RegularEmployee e) {
		regularEmployees.remove(e);
	}
	
	public void distributeBonusBudget() {
		double totalDivisor=0; 
		double unit=0;
		for(int i=0 ; i<regularEmployees.size() ; i++ ) {
			totalDivisor =+ (regularEmployees.get(i).getBonus())*(regularEmployees.get(i).getPerformanceScore());
		}
		unit = bonusBudget/totalDivisor;
		for(int i=0 ; i<regularEmployees.size() ; i++) {
			regularEmployees.get(i).setBonus(unit*regularEmployees.get(i).getSalary()*regularEmployees.get(i).getPerformanceScore());
		}
	}

	// Getters and Setters
	public void setRegularEmployees(ArrayList<RegularEmployee> regularEmployees) {
		this.regularEmployees = regularEmployees;
	}

	public ArrayList<RegularEmployee> getRegularEmployees() {
		return regularEmployees;
	}

	public void setBonusBudget(double bonusBudget) {
		this.bonusBudget = bonusBudget;
	}

	public double getBonusBudget() {
		return bonusBudget;
	}

	// Getters and Setters
	@Override
	public String toString() {
		String[] infos = super.infos().split(" ");
		return ("\tManager " + "[id: " + infos[0] + ", " +  infos[1] + " " +  infos[2] +"\n\t\t# of Employees: "  ); 
	}
}
