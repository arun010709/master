package com.poc.transactionmanagement.service;

import com.poc.transactionmanagement.exception.InvalidInsuranceAmountException;
import com.poc.transactionmanagement.model.EmployeeHealthInsurance;

public interface HealthInsuranceService {
	void registerEmployeeHealthInsurance(EmployeeHealthInsurance employeeHealthInsurance) throws InvalidInsuranceAmountException;

	void deleteEmployeeHealthInsuranceById(String empid);
}
