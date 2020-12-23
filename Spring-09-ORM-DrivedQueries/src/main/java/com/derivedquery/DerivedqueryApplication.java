package com.derivedquery;

import com.derivedquery.repository.DepartmentRepository;
import com.derivedquery.repository.EmployeeRepository;
import com.derivedquery.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class DerivedqueryApplication {

	@Autowired
	private RegionRepository regionRepository;

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(DerivedqueryApplication.class, args);
	}


	@PostConstruct
	public void testEmployee(){
		System.out.println("---------Employee Start--------");

		var employeetList =
				employeeRepository.findByEmailIsNull();


		employeetList.forEach(System.out::println);

		System.out.println("---------Employee End--------");

	}



	@PostConstruct
	public void testRegions(){
		System.out.println("---------Region Start--------");


		System.out.println("---------print Region--------");

		var regionList =
				regionRepository.findTop2ByCountry("United States");
		//		regionRepository.findByCountryContainingOrderByRegion("United");
		//		regionRepository.findByCountryContaining("United");
		//		regionRepository.findDistinctByCountry("Canada");
		//regionRepository.findByCountry("Canada");

		regionList.forEach(System.out::println);



		var departmentList =
				departmentRepository.findByDepartment("Toys");


		System.out.println("---------print Department--------");


		departmentList.forEach(System.out::println);

		System.out.println("---------Region End--------");

	}

}
