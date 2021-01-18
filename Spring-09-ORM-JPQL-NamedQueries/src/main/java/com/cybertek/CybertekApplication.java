package com.cybertek;

import com.cybertek.repository.DepartmentRepository;
import com.cybertek.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class CybertekApplication {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private DepartmentRepository departmentRepository;


	public static void main(String[] args) {
		SpringApplication.run(CybertekApplication.class, args);
	}


	@PostConstruct
	public void testEmployee(){
		System.out.println(employeeRepository.getEmployeeDetail());
		System.out.println(employeeRepository.getEmployeeSalary());

		System.out.println(employeeRepository.getEmployeeByEmail("fmorffew4@a8.net").get());


		employeeRepository.updateEmployeeJPQL(1);

		employeeRepository.updateEmployeeNativeQuery(1);

		//System.out.println(employeeRepository.retrieveEmployeeBySalaryGreaterThan(100));
	}


	@PostConstruct
	public void testDepartment(){

		System.out.println(departmentRepository.retrieveDepartmentByDivisionContains("oor"));
		//System.out.println(departmentRepository.retrieveDepartmentByDivision("Kids"));

		System.out.println(departmentRepository.findOzzyDepartment("kids"));

	//	System.out.println(departmentRepository.countAllDepartments());

	}

}
