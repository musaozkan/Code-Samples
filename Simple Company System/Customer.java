//Musa Özkan 150121058
//A specified object class

import java.util.*;

public class Customer extends Person {

	private ArrayList<Product> products;

	public Customer(int id, String firstName, String lastName, String gender, Calendar birthDate, String maritalStatus,
			String hasDriverLicence, ArrayList<Product> products) {
		super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicence);
	}

	public Customer(Person person, ArrayList<Product> products) {
		super(person.getId(), person.getFirstName(), person.getLastName(), person.getGender(), person.getBirthDate(),
				person.getMaritalStatus(), person.getHasDriverLicence());
		setProducts(products);
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	public String toString() {
		return products.get(0).getProductName();
	}

}
