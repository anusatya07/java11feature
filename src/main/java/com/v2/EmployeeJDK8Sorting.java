package com.v2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeJDK8Sorting {

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

	public static void main(String[] args) {
		List<EmployeeJDK8Sorting> list = new ArrayList<>();
		EmployeeJDK8Sorting emp1 = new EmployeeJDK8Sorting(1, "satish", "pune", "14000");
		EmployeeJDK8Sorting emp2 = new EmployeeJDK8Sorting(2, "hrutvi", "mumbai", "12000");
		EmployeeJDK8Sorting emp3 = new EmployeeJDK8Sorting(3, "anu", "vashi", "18000");

		list.add(emp1);
		list.add(emp2);
		list.add(emp3);

		// List<Employee> listCopy= List.copyOf(list);// Immutable jdk 10 feature

		System.out.println("Asending order");
		List<EmployeeJDK8Sorting> sortedListAsending = list.stream().sorted(Comparator.comparing(EmployeeJDK8Sorting::getSal))
				.collect(Collectors.toList());
		System.out.println(sortedListAsending);
		
		List<EmployeeJDK8Sorting> sortedList = list.stream().sorted(Comparator.comparing(EmployeeJDK8Sorting::getSal).reversed())
				.collect(Collectors.toList());
		System.out.println("Disending order");
		System.out.println(sortedList);

	}

}
