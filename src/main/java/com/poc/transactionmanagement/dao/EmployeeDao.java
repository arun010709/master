package com.poc.transactionmanagement.dao;

import com.poc.transactionmanagement.model.Employee;

public interface EmployeeDao {
	void insertEmployee(Employee cus);

	void deleteEmployeeById(String empid);
}
