package com.derivedquery;

import com.derivedquery.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class DerivedqueryApplication {

	@Autowired
	private RegionRepository regionRepository;

	public static void main(String[] args) {
		SpringApplication.run(DerivedqueryApplication.class, args);
	}



	@PostConstruct
	public void testRegions(){
		System.out.println("---------Region Start--------");

		var regionList =
				regionRepository.findByCountryContainingOrderByRegion("United");
		//		regionRepository.findByCountryContaining("United");
		//		regionRepository.findDistinctByCountry("Canada");
		//regionRepository.findByCountry("Canada");

		regionList.forEach(System.out::println);

		System.out.println("---------Region End--------");

	}

}
