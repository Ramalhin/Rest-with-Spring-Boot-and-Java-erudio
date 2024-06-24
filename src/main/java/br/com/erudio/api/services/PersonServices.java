package br.com.erudio.api.services;

import br.com.erudio.api.PersonRepository;
import br.com.erudio.api.exceptions.ResourceNotFoundException;
import br.com.erudio.api.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;

    public List<Person> findAll(){
        logger.info("Finding all persons");

        return repository.findAll();
    }

    public Person create(Person person) {
        logger.info("Creating one person");
        return repository.save(person);
    }


    public Person update(Person person) {

        logger.info("Updating one person");
        Person entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No record found for this id"));


        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAdress(person.getAdress());
        entity.setGender(person.getGender());

        return repository.save(person);
    }


        public void delete(Long id) {

        logger.info("Deleting one person");

            Person entity = repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("No record found for this id"));

            repository.delete(entity);
    }


    public Person findById(long id) {

        logger.info("Finding all people: " + id);

        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No record found for this id"));
    }

}
