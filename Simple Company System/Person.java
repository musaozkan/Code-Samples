//Musa Özkan 150121058
//A specified object class

import java.util.*;

public class Person {
	private int id;
	private String firstName;
	private String lastName;
	private byte gender;
	private java.util.Calendar birthDate;
	private byte maritalStatus;
	private boolean hasDriverLicence;

	public Person(int id, String firstName, String lastName, String gender, java.util.Calendar birthDate,
			String maritalStatus, String hasDriverLicence) {
		setId(id);
		setFirstName(firstName);
		setLastName(lastName);
		setBirthDate(birthDate);
		setMaritalStatus(maritalStatus);
		setGender(gender);
		setHasDriverLicence(hasDriverLicence);
	}

	// Getters and Setters
	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setBirthDate(Calendar birthDate) {
		this.birthDate = birthDate;
	}

	public Calendar getBirthDate() {
		return birthDate;
	}

	public void setGender(String gender) {
		if (gender.equals("Man")) {
			this.gender = 2;
		} else
			this.gender = 1;
	}

	public String getGender() {
		if (gender == 2) {
			return "Man";
		} else
			return "Woman";
	}

	public void setMaritalStatus(String status) {
		if (status.equals("Single")) {
			this.maritalStatus = 1;
		} else
			this.maritalStatus = 2;
	}

	public String getMaritalStatus() {
		if (maritalStatus == 1) {
			return "Single";
		} else
			return "Married";
	}

	public void setHasDriverLicence(String info) {
		if (info.equals("Yes")) {
			this.hasDriverLicence = true;
		} else
			this.hasDriverLicence = false;
	}

	public String getHasDriverLicence() {
		if (hasDriverLicence == true) {
			return "Yes";
		} else
			return "No";
	}

	// Getters and Setters
	public String infos() {
		return (id + " " + firstName + " " + lastName + " " + getGender() + " " + test.dateFormat(birthDate) + " "
				+ getMaritalStatus() + " " + getHasDriverLicence());
	}

	@Override
	public String toString() {
		return ("Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + getGender()
				+ ", birthDate=" + test.dateFormat(birthDate) + ", maritalStatus=" + getMaritalStatus()
				+ ", hasDriverLicence=" + getHasDriverLicence() + "]");
	}

}
