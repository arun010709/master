package com.poc.transactionmanagement.dao;

import com.poc.transactionmanagement.model.EmployeeHealthInsurance;

public interface HealthInsuranceDao {
	void registerEmployeeHealthInsurance(EmployeeHealthInsurance employeeHealthInsurance);

	void deleteEmployeeHealthInsuranceById(String empid);
}