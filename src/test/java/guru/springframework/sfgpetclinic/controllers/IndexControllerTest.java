package guru.springframework.sfgpetclinic.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
	void testOupsHandler() {
		assertTrue("notimplemented".equals(indexController.oupsHandler()), () -> "This is some expensive" + "method to return message");
		
	}

}
