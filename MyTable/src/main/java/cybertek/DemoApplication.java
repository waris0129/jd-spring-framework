package cybertek;

import cybertek.entity.Employee;
import cybertek.enums.Gender;
import cybertek.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

@SpringBootApplication
public class DemoApplication {

	@Autowired
	private EmployeeService employeeService;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@PostConstruct
	public void injectDate(){

		Employee waris = new Employee("Waris","Nigmat", Gender.MALE, LocalDate.of(1984, Month.JANUARY,29),"SDET", BigDecimal.valueOf(8000));
		Employee gina = new Employee("Gina","Mardan", Gender.FEMALE, LocalDate.of(1984, Month.JULY,29),"ADMIN", BigDecimal.valueOf(10000));
		Employee amina = new Employee("Amina","Mamut", Gender.FEMALE, LocalDate.of(1956, Month.JANUARY,03),"PO", BigDecimal.valueOf(15000));
		Employee nafisa = new Employee("Nafisa","Nigmat", Gender.FEMALE, LocalDate.of(1980, Month.NOVEMBER,11),"PM", BigDecimal.valueOf(20000));


		employeeService.save(waris);
		employeeService.save(gina);
		employeeService.save(amina);
		employeeService.save(nafisa);
	}

}
