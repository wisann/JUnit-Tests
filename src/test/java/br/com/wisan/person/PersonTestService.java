package br.com.wisan.person;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.wisan.model.Person;
import br.com.wisan.service.IPersonService;
import br.com.wisan.service.PersonService;

class PersonTestService {

	IPersonService service;
	Person person;

	@BeforeEach()
	void setup() {
		service = new PersonService();
		person = new Person("Keith", "Moon", "wisan@wisan.com.br", "Sao Paulo, BR", "Male");

	}

	@Test
	@DisplayName("When Create a Person with Success Should Return a Person Object")
	void testCreatePerson_WhenSucceed_ShouldReturnPersonObject() {
		Person actual = service.createPerson(person);

		assertNotNull(actual, () -> "The createPerson should not have returned null!");
	}

	@Test
	@DisplayName("When Create a Person with Success Should Contains First Name in Returned Person Object")
	void testCreatePerson_WhenSucceed_ShouldContainFisrtNameInReturnedPersonObject() {
		Person actual = service.createPerson(person);
		
		assertNotNull(person.getId(), () -> "Person ID is Missing");
		
		assertEquals(person.getFirstName(), actual.getFirstName(), () -> "The first name is incorrect!");

		assertEquals(person.getLastName(), actual.getLastName(), () -> "The last name is incorrect!");

		assertEquals(person.getAdress(), actual.getAdress(), () -> "The adress is incorrect!");

		assertEquals(person.getEmail(), actual.getEmail(), () -> "The email is incorrect!");

		assertEquals(person.getGender(), actual.getGender(), () -> "The gender is incorrect!");

	}
	
	@Test
	@DisplayName("When Create a Person with Null Email Should Throw Exception")
	void testPerson_WithNullEmail_ShouldThrowIllegalArgumentException() {
		person.setEmail(null);
		var expectedMessage = "The person email is null or empty";
		
		IllegalArgumentException exception =  assertThrows(IllegalArgumentException.class,() -> service.createPerson(person), 
				() -> "Empty email should have cause an illegla argument exception");
		assertEquals(expectedMessage, exception.getMessage(), ()-> "Exception error message is incorrect");

	}

}
