package com.poc.transactionmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.poc.transactionmanagement.exception.InvalidInsuranceAmountException;
import com.poc.transactionmanagement.model.Employee;
import com.poc.transactionmanagement.model.EmployeeHealthInsurance;
import com.poc.transactionmanagement.service.EmployeeService;
import com.poc.transactionmanagement.service.OrganizationService;

@SpringBootApplication
public class SpringBootJdbcApplication {

	public static void main(String[] args) throws InvalidInsuranceAmountException {
		ApplicationContext context = SpringApplication.run(SpringBootJdbcApplication.class, args);
		OrganizationService organizationService = context.getBean(OrganizationService.class);
		//EmployeeService employeeService = context.getBean(EmployeeService.class);

		Employee emp = new Employee();
		emp.setEmpId("emp1");
		emp.setEmpName("emp1");

		EmployeeHealthInsurance employeeHealthInsurance = new EmployeeHealthInsurance();
		employeeHealthInsurance.setEmpId("emp1");
		employeeHealthInsurance.setHealthInsuranceSchemeName("premium");
		employeeHealthInsurance.setCoverageAmount(-1);

		organizationService.joinOrganization(emp, employeeHealthInsurance);
		//employeeService.insertEmployee(emp);
	}
}
