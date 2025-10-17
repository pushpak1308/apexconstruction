package skode.web.innovations.apexConstruction.innovations.apexConstruction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import skode.web.innovations.apexConstruction.innovations.apexConstruction.entity.Person;
import skode.web.innovations.apexConstruction.innovations.apexConstruction.repository.PersonRepository;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person addPerson(Person person) {
        return personRepository.save(person);
    }

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public List<Person> searchByName(String name) {
        return personRepository.findByPersonNameContainingIgnoreCase(name);
    }

    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }
}
