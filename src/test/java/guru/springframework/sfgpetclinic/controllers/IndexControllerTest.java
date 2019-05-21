package guru.springframework.sfgpetclinic.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import guru.springframework.sfgpetclinic.exceptions.ValueNotFoundException;

class IndexControllerTest {
	
	IndexController indexController;

	@BeforeEach
	void setUpBeforeClass() throws Exception {
		indexController = new IndexController();
	}

	@Test
	void testIndex() {
		assertEquals("index", indexController.index(), "Wrong view returned");
		
		assertEquals("index", indexController.index(), () -> "Another expensive " + "Create me only if you need to");
	}

	@Test
	void testOopsHandler() {
		//assertTrue("notimplemented".equals(indexController.oopsHandler()), () -> "This is some expensive" + "method to return message");
		assertThrows(ValueNotFoundException.class, () -> {
			indexController.oopsHandler();
		}, "Should throw Value not found exception");
		
	}

}
