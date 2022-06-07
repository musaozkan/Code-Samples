//Musa Özkan 150121058
//A specified object class

import java.util.*;

public class SalesEmployee extends RegularEmployee {
	private ArrayList<Product> sales = new ArrayList<Product>();
	public static int numberOfSalesEmployees;
	
	
	public SalesEmployee(int id, String firstName, String lastName, String gender, Calendar birthDate, String maritalStatus, String hasDriverLicence, double salary, Calendar hireDate, Department department, double pScore, ArrayList<Product> s) {
		super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicence, salary, hireDate, department, pScore);
		this.numberOfSalesEmployees++;
	}
	public SalesEmployee(RegularEmployee re, ArrayList<Product> s) {
		super((Employee)re , re.getPerformanceScore()); 
		for(int i=0;i<s.size();i++) {
			addSale(s.get(i));
		}
		this.numberOfSalesEmployees++;
	}
	
	public boolean addSale(Product s) {
		return sales.add(s);
	}
	public boolean removeSale(Product s) {
		return sales.remove(s);
	}
	
	public String toString() {
		String str = "";
		for(int i = 0 ; i<sales.size() ; i++) {
			str = str + sales.get(i).getProductName() + " "; 
		}
		return ("Product Names: " + str); 
	}
}
