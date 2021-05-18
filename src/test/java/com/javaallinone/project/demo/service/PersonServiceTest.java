package com.javaallinone.project.demo.service;

import com.javaallinone.project.demo.domain.Person;
import com.javaallinone.project.demo.dto.PersonDto;
import com.javaallinone.project.demo.repository.PersonRepository;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatcher;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    @InjectMocks
    private PersonService personService;

    @Mock
    private PersonRepository personRepository;

    @Test
    void getPerson(){
        when(personRepository.findById(1L)).thenReturn(java.util.Optional.of(new Person("martin")));
        Person person = personService.getPerson(1L);
        assertThat(person.getName()).isEqualTo("martin");
    }

    @Test
    void getPersonIfNotFound(){
        when(personRepository.findById(1L)).thenReturn(Optional.empty());
        Person person = personService.getPerson(1L);
        assertThat(person).isNull();
    }

    @Test
    void put(){
        PersonDto personDto = new PersonDto("kjb", LocalDate.now(), "game","pangyo","010-2762-6870", "programmer");

        personService.put(personDto);
        personService.put(personDto);

        verify(personRepository, times(2)).save(any(Person.class));
    }


    @Test
    void getPeopleByName(){
        when(personRepository.findByName("jjj")).thenReturn(Lists.newArrayList(new Person("jjj")));
        List<Person> person = personService.getPeopleByName("jjj");
        assertThat(person.get(0).getName()).isEqualTo("jjj");
    }
    
    @Test
    void modify(){
        PersonDto personDto = new PersonDto("kjb", LocalDate.now(), "game","pangyo","010-2762-6870", "programmer");
        when(personRepository.findById(1L)).thenReturn(Optional.of(new Person("kjb")));
        personService.modify(1L, personDto);
        verify(personRepository, times(1)).save(any(Person.class));
    }

    @Test
    void modifyByname(){
        when(personRepository.findById(1L)).thenReturn(Optional.of(new Person("kjb")));
        personService.modify(1L, "zzz");
        verify(personRepository, times(1)).save(any(Person.class));
    }

    @Test
    void deleteByNameEmpty(){
        when(personRepository.findById(1L)).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, ()-> personService.delete(1L));
    }

    @Test
    void delete(){
        when(personRepository.findById(1L)).thenReturn(Optional.of(new Person("kjb")));
        personService.delete(1L);
        verify(personRepository, times(1)).save(argThat(new IsPersonWillBeDeleted()));
    }

    private static class IsPersonWillBeDeleted implements ArgumentMatcher<Person>{ // 인자가 제대로 들어갔고 작동하는지 체크하기위함. //
        @Override
        public boolean matches(Person person) {
            return person.isDeleted();
        }
    }
}