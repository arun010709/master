package com.poc.transactionmanagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.poc.transactionmanagement.exception.InvalidInsuranceAmountException;
import com.poc.transactionmanagement.model.Employee;
import com.poc.transactionmanagement.model.EmployeeHealthInsurance;
import com.poc.transactionmanagement.service.EmployeeService;
import com.poc.transactionmanagement.service.HealthInsuranceService;
import com.poc.transactionmanagement.service.OrganizationService;

@Service
public class OrganzationServiceImpl implements OrganizationService {

	@Autowired
	EmployeeService employeeService;

	@Autowired
	HealthInsuranceService healthInsuranceService;

	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = InvalidInsuranceAmountException.class)
	public void joinOrganization(Employee employee, EmployeeHealthInsurance employeeHealthInsurance) throws InvalidInsuranceAmountException {
		employeeService.insertEmployee(employee);
		healthInsuranceService.registerEmployeeHealthInsurance(employeeHealthInsurance);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void leaveOrganization(Employee employee, EmployeeHealthInsurance employeeHealthInsurance) {
		employeeService.deleteEmployeeById(employee.getEmpId());
		healthInsuranceService.deleteEmployeeHealthInsuranceById(employeeHealthInsurance.getEmpId());
	}
}
