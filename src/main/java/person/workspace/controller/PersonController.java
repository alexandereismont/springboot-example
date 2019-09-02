package person.workspace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import person.workspace.controller.dto.PersonId;
import person.workspace.controller.dto.UpdatedName;
import person.workspace.controller.exceptions.PersonNotFoundException;
import person.workspace.model.Activity;
import person.workspace.model.Person;
import person.workspace.repository.PersonRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/person")
public class PersonController {

    private PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    @GetMapping("/all")
    public List<Person> getAllPersons(){
        return personRepository.findAll();
    }

    @PostMapping("/update-name")
    public void updateName(@RequestBody UpdatedName updatedName){
        Person person = personRepository.findById(updatedName.getPersonId()).orElseThrow(()
                -> new PersonNotFoundException(updatedName.getPersonId()));
        person.setFirstName(updatedName.getNewFirstName());
        person.setLastName(updatedName.getNewLastName());
        personRepository.save(person);
    }

    @PostMapping("/add")
    public void addPerson(@RequestBody Person person){
        personRepository.save(person);
    }

    @PostMapping("/get-activities")
    public List<String> getAcivitiesForAPerson(@RequestBody PersonId personId){
        List<Activity> activities = personRepository.getOne(personId.getPersonId()).getActivities();
        return activities.stream().map(Activity::getActivityName).collect(Collectors.toList());
    }

}
