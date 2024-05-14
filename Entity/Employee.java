package Entity;

import java.lang.*;

public class Employee extends Person {
	private String employeeId;
	private String empSalary;

	public Employee() {
	}

	public Employee(String name, String age, String contactNum,
			String employeeId, String empSalary) {

		super(name, age, contactNum);
		this.employeeId = employeeId;
		this.empSalary = empSalary;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeSalary(String empSalary) {
		this.empSalary = empSalary;
	}

	public String getEmployeeSalary() {
		return empSalary;
	}

	public void showInfo() {

		// System.out.println("--------Employee Info---------");
		super.showInfo();
		System.out.println("Employee ID: " + employeeId);
		System.out.println("Employee Salary: " + empSalary);
	}

	public Employee parseEmployee(String data) {
		String[] tokens = data.split(",");
		String name = tokens[1];
		String age = tokens[2];
		String contactNum = tokens[3];
		String employeeId = tokens[0];
		String empSalary = tokens[4];

		return new Employee(name, age, contactNum, employeeId, empSalary);
	}

	@Override
	public String toString() {
		return getEmployeeId() + "," + getName() + "," + getAge() + "," + getContactNum() + "," + getEmployeeSalary();
	}
}