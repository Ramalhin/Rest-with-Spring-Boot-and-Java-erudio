package br.com.erudio.api.mapper.custom;

import br.com.erudio.api.data.vo.v2.PersonVOV2;
import br.com.erudio.api.model.Person;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonMapper {

    public PersonVOV2 convertEntityToVO(Person person) {
        PersonVOV2 vo = new PersonVOV2();
        vo.setId(person.getId());
        vo.setFirstName(person.getFirstName());
        vo.setLastName(person.getLastName());
        vo.setAdress(person.getAdress());
        vo.setGender(person.getGender());
        vo.setBirthDay(new Date());
        return vo;
    }

    public Person convertVoTOEntity(PersonVOV2 person) {
        Person entity = new Person();
        entity.setId(person.getId());
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAdress(person.getAdress());
        entity.setGender(person.getGender());
        // vo.setBirthDay(new Date());
        return entity;
    }

}
