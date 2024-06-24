package br.com.erudio.api.services;

import br.com.erudio.api.PersonRepository;
import br.com.erudio.api.exceptions.ResourceNotFoundException;
import br.com.erudio.api.mapper.DozerMapper;
import br.com.erudio.api.model.Person;
import br.com.erudio.api.data.vo.v1.PersonVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;

    public List<PersonVO> findAll(){
        logger.info("Finding all persons");

        return DozerMapper.parseListObject(repository.findAll(), PersonVO.class);
    }

    public PersonVO create(PersonVO person) {
        logger.info("Creating one person");

        var entity = DozerMapper.parseObject(person, Person.class);
        var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
        return vo;
    }


    public PersonVO update(PersonVO person) {

        logger.info("Updating one person");
        var entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No record found for this id"));


        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAdress(person.getAdress());
        entity.setGender(person.getGender());

        var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
        return vo;
    }


        public void delete(Long id) {

        logger.info("Deleting one person");

            var entity = repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("No record found for this id"));

            repository.delete(entity);
    }


    public PersonVO findById(long id) {

        logger.info("Finding all people: " + id);

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No record found for this id"));

        return DozerMapper.parseObject(entity, PersonVO.class);
    }

}
