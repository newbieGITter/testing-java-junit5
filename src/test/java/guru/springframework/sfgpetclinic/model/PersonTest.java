package guru.springframework.sfgpetclinic.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class PersonTest implements ModelTests {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	// Grouped Assertions
	@Test
	void testGroupedAssertions() {
		Person person = new Person(1L, "Joe", "Buck");
		
		assertAll("Test props set", 
				() -> assertEquals(person.getFirstName(), "Joe"),
				() -> assertEquals(person.getLastName(), "Buck"));
	}

	@Test
	void testGroupedAssertions_negativeScenario() {
		Person person = new Person(1L, "Joe", "Buck");
		
		assertAll("Test props set", 
				() -> assertEquals(person.getFirstName(), "Joee", "First Name failed"),
				() -> assertEquals(person.getLastName(), "Buckk", "Last Name failed"));
	}

}
