package br.com.erudio.api.unittests.mockito.services;

import br.com.erudio.api.PersonRepository;
import br.com.erudio.api.data.vo.v2.PersonVOV2;
import br.com.erudio.api.exceptions.ResourceNotFoundException;
import br.com.erudio.api.mapper.DozerMapper;
import br.com.erudio.api.mapper.custom.PersonMapper;
import br.com.erudio.api.model.Person;
import br.com.erudio.api.data.vo.v1.PersonVO;
import br.com.erudio.api.model.controller.PersonController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class PersonServices {

    private final Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;

    @Autowired
    PersonMapper mapper;

    public List<PersonVO> findAll(){
        logger.info("Finding all persons");

        var persons = DozerMapper.parseListObject(repository.findAll(), PersonVO.class);
        persons.stream().forEach(p -> p.add(linkTo(methodOn(PersonController.class).findById(p.getKey())).withSelfRel()));
        return persons;
    }

    public PersonVO create(PersonVO person) {
        logger.info("Creating one person");

        var entity = DozerMapper.parseObject(person, Person.class);
        var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
        return vo;
    }

    public PersonVOV2 createv2(PersonVOV2 person) {
        logger.info("Creating one person v2");

        var entity = mapper.convertVoTOEntity(person);
        var vo = mapper.convertEntityToVO(repository.save(entity));
        return vo;
    }



    public PersonVO update(PersonVO person) {

        logger.info("Updating one person");
        var entity = repository.findById(person.getKey())
                .orElseThrow(() -> new ResourceNotFoundException("No record found for this id"));


        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAdress(person.getAdress());
        entity.setGender(person.getGender());

        var vo = DozerMapper.parseObject(entity, PersonVO.class);
        vo.add(linkTo(methodOn(PersonController.class).findById(vo.getKey())).withSelfRel());
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

        var vo = DozerMapper.parseObject(entity, PersonVO.class);
        vo.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
        return vo;
    }


}
