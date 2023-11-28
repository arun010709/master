package com.poc.transactionmanagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.poc.transactionmanagement.dao.HealthInsuranceDao;
import com.poc.transactionmanagement.exception.InvalidInsuranceAmountException;
import com.poc.transactionmanagement.model.EmployeeHealthInsurance;
import com.poc.transactionmanagement.service.HealthInsuranceService;

@Service
public class HealthInsuranceServiceImpl implements HealthInsuranceService {

	@Autowired
	HealthInsuranceDao healthInsuranceDao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void registerEmployeeHealthInsurance(EmployeeHealthInsurance employeeHealthInsurance) throws InvalidInsuranceAmountException {
		if (employeeHealthInsurance.getCoverageAmount() < 0) {
			throw new InvalidInsuranceAmountException("Coverage Amount Should not be negative");
			}
		healthInsuranceDao.registerEmployeeHealthInsurance(employeeHealthInsurance);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteEmployeeHealthInsuranceById(String empid) {
		healthInsuranceDao.deleteEmployeeHealthInsuranceById(empid);
	}

}
