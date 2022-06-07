//Musa Özkan 150121058
//A specified object class

import java.util.*;

public class Project {
	private String projectName;
	private java.util.Calendar startDate;
	private boolean state;
	
	public Project(String pName, Calendar startDate, String state) {
		setProjectName(pName);
		setStartDate(startDate);
		setState(state);
	}
	
	public void setState(String state) {
		if(state.equals("Open")) {
			this.state = true;
		}
		else
			this.state = false;
	}
	public boolean getState() {
		return state;
	}
	public void close() {
		
	}
	
	// Getters and Setters
	public void setProjectName(String productName) {
		this.projectName = productName;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}

	public String toString() {
		return ("Project Name: " + projectName + " Project Start Date: " + test.dateFormat(startDate) + " Project State: " + state); 
	}
}
