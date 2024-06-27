package br.com.erudio.api.services;

import br.com.erudio.api.PersonRepository;
import br.com.erudio.api.data.vo.v1.PersonVO;
import br.com.erudio.api.exceptions.RequiredObjectsIsNullException;
import br.com.erudio.api.model.Person;
import br.com.erudio.api.unittests.mockito.services.PersonServices;
import br.com.erudio.unittests.mocks.MockPerson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class PersonServicesTest {

    MockPerson input;

    @InjectMocks
    private PersonServices service;

    @Mock
    PersonRepository repository;

    @BeforeEach
    void setUpMocks() throws Exception{
        input = new MockPerson();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findAllTest() {
        List<Person> list = input.mockEntityList();

        when(repository.findAll()).thenReturn(list);

        var persons = service.findAll();
        assertNotNull(persons);
        assertEquals(14,persons.size());

        var personOne = persons.get(1);

        assertNotNull(personOne);
        assertNotNull(personOne.getKey());
        assertNotNull(personOne.getLinks());

        assertTrue(personOne.toString().contains("links: [</person/api/v1/1>;rel=\"self\"]"));
        assertEquals("Addres Test1", personOne.getAdress());
        assertEquals("First Name Test1", personOne.getFirstName());
        assertEquals("Last Name Test1", personOne.getLastName());
        assertEquals("Female", personOne.getGender());


    }
    @Test
    void updateTest() {
        Person entity = input.mockEntity(1);

        Person persisted = entity;
        persisted.setId(1L);

        PersonVO vo = input.mockVO(1);
        vo.setKey(1L);

        lenient().when(repository.findById(1L)).thenReturn(Optional.of(entity));
        lenient().when(repository.save(entity)).thenReturn(persisted);

        var result = service.update(vo);
        assertNotNull(result);
        assertNotNull(result.getKey());
        assertNotNull(result.getLinks());
        System.out.println(result.toString());


        assertTrue(result.toString().contains("links: [</person/api/v1/1>;rel=\"self\"]"));
        assertEquals("Addres Test1", result.getAdress());
        assertEquals("First Name Test1", result.getFirstName());
        assertEquals("Last Name Test1", result.getLastName());
        assertEquals("Female", result.getGender());
    }

    @Test
    void updateWithNullPersonTest() {
        Exception exception = assertThrows(RequiredObjectsIsNullException.class, () -> {
            service.update(null);
        });
        String expectedMessage = "";
        String actual = exception.getMessage();
        assertTrue(actual.contains(expectedMessage));


    }
    @Test
    void createTest() {
        Person entity = input.mockEntity(1);

        Person persisted = entity;
        persisted.setId(1L);

        PersonVO vo = input.mockVO(1);
        vo.setKey(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(entity));


        var result = service.update(vo);
        assertNotNull(result);
        assertNotNull(result.getKey());
        assertNotNull(result.getLinks());
        System.out.println(result.toString());
        assertTrue(result.toString().contains("links: [</person/api/v1/1>;rel=\"self\"]"));
        assertEquals("Addres Test1", result.getAdress());
        assertEquals("First Name Test1",result.getFirstName());
        assertEquals("Last Name Test1",result.getLastName());
        assertEquals("Female",result.getGender());

    }

    void createWithNullPersonTest() {
        Exception exception = assertThrows(RequiredObjectsIsNullException.class, () ->{
            service.create(null);
        });
        String expectedMessage = ";";
        String actual = exception.getMessage();
        assertTrue(actual.contains(expectedMessage));

    }


    @Test
    void createv2Test() {

    }

    @Test
    void deleteTest() {
        Person entity = input.mockEntity(1);
        entity.setId(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(entity));

       service.delete(1L);
    }

    @Test
    void findByIdTest() {
            Person entity = input.mockEntity(1);
            entity.setId(1L);

            when(repository.findById(1L)).thenReturn(Optional.of(entity));

            var result = service.findById(1L);
            assertNotNull(result);
            assertNotNull(result.getKey());
            assertNotNull(result.getLinks());
            System.out.println("Result: " + result.toString());
            assertTrue(result.toString().contains("links: [</person/api/v1/1>;rel=\"self\"]"));
            assertEquals("Addres Test1", result.getAdress());
            assertEquals("First Name Test1",result.getFirstName());
            assertEquals("Last Name Test1",result.getLastName());
            assertEquals("Female",result.getGender());

        }
    }
