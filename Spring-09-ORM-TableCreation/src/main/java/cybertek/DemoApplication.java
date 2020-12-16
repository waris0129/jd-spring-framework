package cybertek;

import cybertek.entity.Car;
import cybertek.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class DemoApplication {

	@Autowired
	CarRepository carRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@PostConstruct
	public void dataInit(){

		Car c1 = new Car("BMW","M5");
		Car c2 = new Car("KIA","Sorento");
		Car c3 = new Car("Mercedes","S500");
		Car c4 = new Car("Hyundai","Tucson");

		carRepository.save(c1);
		carRepository.save(c2);
		carRepository.save(c3);
		carRepository.save(c4);

		carRepository.findAll();


	}

}
