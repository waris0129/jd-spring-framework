package orm.cybertek.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import orm.cybertek.entity.Address;
import orm.cybertek.entity.Person;
import orm.cybertek.repository.AddressRepository;
import orm.cybertek.repository.PersonRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DataGenerator implements CommandLineRunner {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public void run(String... args) throws Exception {

        List<Person> personList = new ArrayList<>();

        Person p1 = new Person("Mike","Smith");
        Person p2 = new Person("Ozzy","Nisa");
        Person p3 = new Person("Gina","Waris");

        Address a1 = new Address("King St","22042");
        Address a2 = new Address("Luik St","22045");
        Address a3 = new Address("Bromp St","230982");


        // case 1

//        p1.setAddress(Arrays.asList(a1,a2));
//        personRepository.saveAll(Arrays.asList(p1));

        // case 2

        personRepository.save(p1);

        a1.setPerson(p1);
        a2.setPerson(p1);
        a3.setPerson(p1);


        addressRepository.saveAll(Arrays.asList(a1,a2,a3));


    }
}
