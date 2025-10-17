package skode.web.innovations.apexConstruction.innovations.apexConstruction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import skode.web.innovations.apexConstruction.innovations.apexConstruction.entity.Person;
import skode.web.innovations.apexConstruction.innovations.apexConstruction.service.PersonService;

@RestController
@RequestMapping("/api/persons")
@CrossOrigin(origins = "*")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("/add")
    public Person addPerson(@RequestBody Person person) {
        return personService.addPerson(person);
    }

    @GetMapping("/all")
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    @GetMapping("/search")
    public List<Person> searchPersons(@RequestParam String name) {
        return personService.searchByName(name);
    }

    @DeleteMapping("/{id}")
    public String deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
        return "Person deleted successfully!";
    }
}
