//Musa Özkan 150121058
//A specified object class

import java.util.*;

public class Department {
	private int departmentId;
	private String departmentName;
	
	public Department(int departmentId, String departmentName) {
		setDepartmentId(departmentId);
		setDepartmentName(departmentName);
	}
	
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getDepartmentName () {
		return departmentName;
	}
	public String toString() {
		return ("Department " +"[departmentId=" + departmentId + ", " + "departmentName=" + departmentName + "]"); 
	}
}
