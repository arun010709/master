package com.poc.transactionmanagement.service;

import com.poc.transactionmanagement.model.Employee;

public interface EmployeeService {
	void insertEmployee(Employee emp);

	void deleteEmployeeById(String empid);
}
