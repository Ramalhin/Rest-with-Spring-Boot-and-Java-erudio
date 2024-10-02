package br.com.erudio.api.repository;


import br.com.erudio.api.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;



public interface PersonRepository extends JpaRepository<Person, Long> {}
