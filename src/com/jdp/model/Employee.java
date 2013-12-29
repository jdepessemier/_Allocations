package com.jdp.model;

public class Employee {
	
    private int employeeId;
    private String employeeDepartment ="";
    private String employeeService ="";
    private String employeeName ="";
    
	public Employee() {
		employeeDepartment = "";
		employeeService = "";
		employeeName = "";
	}

	public Employee(String employeedepartment,
					   String employeeservice,
					   String employeename) {
	
	this.employeeDepartment = employeedepartment;
	this.employeeService = employeeservice;
	this.employeeName = employeename;
	}
	
    public int getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(int employeeid) {
        this.employeeId = employeeid;
    }
    
    public String getEmployeeDepartment() {
        return employeeDepartment;
    }
    public void setEmployeeDepartment(String employeedepartment) {
        this.employeeDepartment = employeedepartment;
    }
	
    public String getEmployeeService() {
        return employeeService;
    }
    public void setEmployeeService(String employeeservice) {
        this.employeeService = employeeservice;
    }
    
    public String getEmployeeName() {
        return employeeName;
    }
    public void setEmployeeName(String employeename) {
        this.employeeName = employeename;
    }
      
}
