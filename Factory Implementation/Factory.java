// Musa Özkan 150121058 
// This class has all o the methods that lets the system work.
import java.util.Arrays;

public class Factory {
	private String name;
	private Employee[] employees;
	private Storage storage;
	private Payroll[] payrolls;
	private double itemPrice;
	// A constructor to determine taken values
	Factory(String name, int capacity, double itemPrice) {
		this.name = name;
		this.itemPrice = itemPrice;
		this.storage = new Storage(capacity);
	}
	// A method to calculate the revanue
	public double getRevenue() {
		return Item.numberOfItems * (this.itemPrice);
	}
	
	public double getPaidSalaries() {
		double salaries = 0;
		for (int i = 0; i < payrolls.length; i++) {
			salaries += payrolls[i].calculateSalary();
		}
		return salaries;
	}
	// Adds employees to arrays with copyOf method.
	public void addEmployee(Employee employee) {
		if (employees == null) {
			employees = new Employee[1];
			employees[0] = employee;
		} else {
			employees = Arrays.copyOf(employees, employees.length + 1);
			employees[employees.length - 1] = employee;
		}
		Item[] items2 = employees[employees.length - 1].startShift();
		for (int i = 0; i < items2.length; i++) {
			storage.addItem(items2[i]);
		}
	}

	public Employee removeEmployee(int id) {
		if (employees == null) {
			System.out.println("There are no employees!"); // Buraya bişi yaz
			return null;
		} 
		int x = -5;
		for (int i = 0; i < employees.length; i++) {
			if (employees[i].getId() == id) {
				x = i;
				break;
			}
		}
		if (x == -5) {
			System.out.println("Employee does not exist!"); // Buraya bişi yaz
			return null;
		}

        Employee rEmployee = employees[x];

        Employee[] copiedEmployees = new Employee[employees.length-1];

        for (int i = 0, j = 0; i < employees.length; i++) {
            if (i!=x) {
                copiedEmployees[j++] = employees[i];
            }
        }
        employees = copiedEmployees;
        addPayroll(rEmployee.endShift());
        return rEmployee;
	}

	private void addPayroll(Payroll payroll) {

		if(payrolls==null) {
            payrolls = new Payroll[1];
            payrolls[0] = payroll;
        }

        else {
            payrolls = Arrays.copyOf(payrolls, payrolls.length + 1);
            payrolls[payrolls.length-1] = payroll;
        }
	}
}
