package br.com.wisan.service;

import java.util.concurrent.atomic.AtomicLong;

import br.com.wisan.model.Person;

public class PersonService implements IPersonService {

	@Override
	public Person createPerson(Person person) {

		if(person.getEmail()== null || person.getEmail().isBlank()) throw new IllegalArgumentException(
				"The person email is null or empty");
		var id = new AtomicLong().incrementAndGet();
		person.setId(id);
		return person;

	}

}
