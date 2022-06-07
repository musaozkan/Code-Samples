//Musa Özkan 150121058
//The program takes input from a text file, creates objects that necessary to work with the info and outputs it as wanted. 
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;
import java.util.Calendar;

public class test {

	private static Calendar dateFormatter(String date) {
		String[] splittedDate = date.split("/");
		int DAY = Integer.parseInt(splittedDate[0]);
		int MONTH = Integer.parseInt(splittedDate[1]);
		int YEAR = Integer.parseInt(splittedDate[2]);
		Calendar calendar = Calendar.getInstance();
		calendar.set(YEAR, MONTH, DAY);
		return calendar;
	}

	public static String dateFormat(Calendar calendar) {
		Date date = calendar.getTime();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String strDate = dateFormat.format(date);
		return strDate;
	}

	public static void main(String[] args) throws ParseException {
		ArrayList<String> listOfWords = new ArrayList<String>();
		try {
			File txt = new File("input.txt");
			Scanner input = new Scanner(txt);
			while (input.hasNext()) {
				listOfWords.add(input.next());
			}
			input.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		ArrayList<Department> departments = new ArrayList<Department>();
		ArrayList<Project> projects = new ArrayList<Project>();
		ArrayList<Product> products = new ArrayList<Product>();
		ArrayList<Person> person = new ArrayList<Person>();

		for (int i = 0; i < person.size(); i++) {
			if (person.get(i) instanceof Manager) {

			}
		}

		for (int i = 0; i < listOfWords.size(); i++) {
			if (listOfWords.get(i).equals("Department")) {
				departments.add(new Department(Integer.parseInt(listOfWords.get(++i)), listOfWords.get(++i)));
			} else if (listOfWords.get(i).equals("Project")) {
				projects.add(
						new Project(listOfWords.get(++i), dateFormatter(listOfWords.get(++i)), listOfWords.get(++i)));
			} else if (listOfWords.get(i).equals("Product")) {
				products.add(new Product(listOfWords.get(++i), dateFormatter(listOfWords.get(++i)),
						Integer.parseInt(listOfWords.get(++i))));
			} else if (listOfWords.get(i).equals("Person")) {
				int temp = i;
				person.add(new Person(Integer.parseInt(listOfWords.get(temp + 3)), listOfWords.get(temp + 1),
						listOfWords.get(temp + 2), listOfWords.get(temp + 4), dateFormatter(listOfWords.get(temp + 5)),
						listOfWords.get(temp + 6), listOfWords.get(temp + 7)));
			} else if (listOfWords.get(i).equals("Employee")) {
				int temp = i;
				for (int a = 0; a < person.size(); a++) {
					if (person.get(a).getId() == Integer.parseInt(listOfWords.get(temp + 1))) {
						Person per = person.get(a);
						if (listOfWords.get(temp + 4).equals("Accounting")) {
							person.set(a, new Employee(per, Integer.parseInt(listOfWords.get(temp + 2)),
									dateFormatter(listOfWords.get(temp + 3)), departments.get(0)));
						} else if (listOfWords.get(temp + 4).equals("Marketing")) {
							person.set(a, new Employee(per, Integer.parseInt(listOfWords.get(temp + 2)),
									dateFormatter(listOfWords.get(temp + 3)), departments.get(1)));
						}
					}
				}
			} else if (listOfWords.get(i).equals("Manager")) {
				int temp = i;
				for (int a = 0; a < person.size(); a++) {
					if (person.get(a).getId() == Integer.parseInt(listOfWords.get(temp + 1))) {
						Employee emp = (Employee) person.get(a);
						person.set(a, new Manager(emp, Integer.parseInt(listOfWords.get(temp + 2))));
					}
				}
			} else if (listOfWords.get(i).equals("RegularEmployee")) {
				int temp = i;
				for (int a = 0; a < person.size(); a++) {
					if (person.get(a).getId() == Integer.parseInt(listOfWords.get(temp + 1))) {
						Employee emp = (Employee) person.get(a);
						person.set(a, new RegularEmployee(emp, Integer.parseInt(listOfWords.get(temp + 2))));
					}
				}
			} else if (listOfWords.get(i).equals("Developer")) {
				int temp = i;
				ArrayList<Project> p = new ArrayList<Project>();
				for (int a = 0; a < person.size(); a++) {
					if (person.get(a).getId() == Integer.parseInt(listOfWords.get(temp + 1))) {
						RegularEmployee regemp = (RegularEmployee) person.get(a);
						for (int x = 0; x < projects.size(); x++) {
							for (int y = 0; y < 4; y++) {
								if (listOfWords.get(temp + 2 + y).equals(projects.get(x).getProjectName())) {
									p.add(projects.get(x));
								}
							}
						}
						person.set(a, new Developer(regemp, p));
					}
				}
			} else if (listOfWords.get(i).equals("SalesEmployee")) {
				int temp = i;
				ArrayList<Product> p = new ArrayList<Product>();
				for (int a = 0; a < person.size(); a++) {
					if (person.get(a).getId() == Integer.parseInt(listOfWords.get(temp + 1))) {
						RegularEmployee regemp = (RegularEmployee) person.get(a);
						for (int x = 0; x < products.size(); x++) {
							for (int y = 0; y < 4; y++) {
								if (listOfWords.get(temp + 2 + y).equals(products.get(x).getProductName())) {
									p.add(products.get(x));
								}
							}
						}
						person.set(a, new SalesEmployee(regemp, p));
					}
				}
			} else if (listOfWords.get(i).equals("Customer")) {
				int temp = i;
				ArrayList<Product> p = new ArrayList<Product>();
				for (int a = 0; a < person.size(); a++) {
					if (person.get(a).getId() == Integer.parseInt(listOfWords.get(temp + 1))) {
						Person per = person.get(a);
						for (int x = 0; x < 2; x++) {
							for (int y = 0; y < products.size(); y++) {
								if (products.get(y).getProductName().equals(listOfWords.get(temp + 2 + x))) {
									p.add(products.get(x));
								}
							}
						}
						person.set(a, new Customer(per, p));
					}
				}
			}
		}

		try {
			File output = new File("Output.txt");
			if (output.createNewFile()) {
				FileWriter writer = new FileWriter("Output.txt");
				for (int d = 0; d < departments.size(); d++) {
					writer.write("************************************************\n");
					writer.write(departments.get(d).toString() + "\n");
					for (int p = 0; p < person.size(); p++) {
						int temp = 0;
						if (person.get(p) instanceof Manager) {
							writer.write("\t" + person.get(p).toString() + "\n");
							temp = p;
							break;
						}
					}
					writer.write("\n");
				}
				writer.close();
			} else {
				System.out.println("File already exists.");
			}
		} catch (

		IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

	}
}
