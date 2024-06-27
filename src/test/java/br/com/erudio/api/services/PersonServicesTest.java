package br.com.erudio.api.services;

import br.com.erudio.api.PersonRepository;
import br.com.erudio.api.data.vo.v1.PersonVO;
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

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
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

    }
    @Test
    void updateTest() {
        Person entity = input.mockEntity(1);

        Person persisted = entity;
        entity.setId(1L);

        PersonVO vo = input.mockVO(1);
        vo.setKey(1L);

        when(repository.save(entity)).thenReturn(persisted);

        var result = service.create(vo);
        assertNotNull(result);
        assertNotNull(result.getKey());
        assertNotNull(result.getLinks());
        System.out.println(result.toString());
        assertTrue(result.toString().contains("links: []"));
        assertEquals("Addres Test1", result.getAdress());
        assertEquals("First Name Test1",result.getFirstName());
        assertEquals("Last Name Test1",result.getLastName());
        assertEquals("Female",result.getGender());

    }

    @Test
    void createv2Test() {

    }

    @Test
    void createTest() {
        Person entity = input.mockEntity(1);

        Person persisted = entity;
        entity.setId(1L);

        PersonVO vo = input.mockVO(1);
        vo.setKey(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(entity));
        when(repository.save(entity)).thenReturn(persisted);

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

    @Test
    void deleteTest() {

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
