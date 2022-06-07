//Musa Özkan 150121058
//A specified object class

import java.util.*;

public class Developer extends RegularEmployee {
	private ArrayList<Project> projects = new ArrayList<Project>();
	public static int numberOfDevelopers;

	public Developer(int id, String firstName, String lastName, String gender, Calendar birthDate, String maritalStatus,
			String hasDriverLicence, double salary, Calendar hireDate, Department department, double pScore,
			ArrayList<Project> p) {
		super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicence, salary, hireDate, department,
				pScore);
		this.numberOfDevelopers++;
	}

	public Developer(RegularEmployee re, ArrayList<Project> p) {
		super(re.getId(), re.getFirstName(), re.getLastName(), re.getGender(), re.getBirthDate(), re.getMaritalStatus(),
				re.getHasDriverLicence(), re.getSalary(), re.getHireDate(), re.getDepartment(),
				re.getPerformanceScore());
		for (int i = 0; i < p.size(); i++) {
			addProjects(p.get(i));
		}
		this.numberOfDevelopers++;
	}

	public boolean addProjects(Project s) {
		return projects.add(s);
	}

	public boolean removeProjects(Project s) {
		return projects.remove(s);
	}

	@Override
	public String toString() {
		String[] infos = super.infos().split(" ");
		return ("1. Developer\n" + "\tPerson Info [id=" + infos[0] + ", firstName=" + infos[1] + ", lastName="
				+ infos[2] + ", gender=" + infos[3] + "]\n" + "\tEmployee Info [salary=" + infos[7] + ", hireDate="
				+ infos[8] + "]" + "RegularEmployee Info [performanceScore=" + infos[9] + ", bonus=" + infos[10] + "]");
	}
}
