package com.poc.transactionmanagement.service;

import com.poc.transactionmanagement.exception.InvalidInsuranceAmountException;
import com.poc.transactionmanagement.model.Employee;
import com.poc.transactionmanagement.model.EmployeeHealthInsurance;

public interface OrganizationService {
	public void joinOrganization(Employee employee, EmployeeHealthInsurance employeeHealthInsurance) throws InvalidInsuranceAmountException;

	public void leaveOrganization(Employee employee, EmployeeHealthInsurance employeeHealthInsurance);
}
