package guru.springframework.sfgpetclinic.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class OwnerTest implements ModelTests {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	// Dependent assertions
	@Test
	void testDependentAssertions() {
		Owner owner = new Owner(1L, "Joe", "Buck");
		owner.setCity("Mumbai");
		owner.setTelephone("12141515566");
		
		assertAll("Properties test", 
				() -> assertAll("Person properties",
						() -> assertEquals("Joe", owner.getFirstName(), "Person first name did not match"),
						() -> assertEquals("Buck", owner.getLastName(), "Person last name did not match")),
				
				() -> assertAll("Owner properties",
						() -> assertEquals("Mumbai", owner.getCity(), "Owner City did not match"),
						() -> assertEquals("12141515566", owner.getTelephone(), "Owner Telephone did not match"))
				);
	}

}
