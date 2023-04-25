package com.v2;

import java.util.Optional;
 class EmployeeJDK8Sorting {
private int empId;
private String empName;
private String city;
private String sal;

public EmployeeJDK8Sorting() {
	super();
}

public EmployeeJDK8Sorting(int empId, String empName, String city, String sal) {
	super();
	this.empId = empId;
	this.empName = empName;
	this.city = city;
	this.sal = sal;
}

public int getEmpId() {
	return empId;
}

public void setEmpId(int empId) {
	this.empId = empId;
}

public String getEmpName() {
	return empName;
}

public void setEmpName(String empName) {
	this.empName = empName;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public String getSal() {
	return sal;
}

public void setSal(String sal) {
	this.sal = sal;
}

@Override
public String toString() {
	return "Employee [empId=" + empId + ", empName=" + empName + ", city=" + city + ", sal=" + sal + "]";
}
}
public class Java8Optional {

	public static void main(String[] args) {
		String[] str = new String[10];
		
		Optional<EmployeeJDK8Sorting> checkNull = Optional.ofNullable(new EmployeeJDK8Sorting());
		if (checkNull.isPresent()) {
			String word = str[5].toLowerCase();
			System.out.print(str);
		} else {
			System.out.println("string is null");
		}
		checkNull.get();
		
	}
}