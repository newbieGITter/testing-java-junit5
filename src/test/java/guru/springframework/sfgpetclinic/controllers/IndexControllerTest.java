package guru.springframework.sfgpetclinic.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

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

	// Handling Expected Exceptions
	@Test
	void testOopsHandler() {
		//assertTrue("notimplemented".equals(indexController.oopsHandler()), () -> "This is some expensive" + "method to return message");
		assertThrows(ValueNotFoundException.class, () -> {
			indexController.oopsHandler();
		}, "Should throw Value not found exception");
		
	}
	
	
	// Junit Assumptions
	@Test
	public void testAssumptionTrue() {
		assumeTrue("Guru".equalsIgnoreCase(System.getenv("GURU_RUNTIME")));
	}
	
	@Test
	public void testAssumptionWithTwoStringsIsTrue() {
		assumeTrue("Guru".equalsIgnoreCase("GURU"));
	}
	
	// Condition Junit test execution
	@Test
	@EnabledOnOs(OS.WINDOWS)
	public void testMeOnWindows() {
		assertTrue("Windows".equalsIgnoreCase("Windows"));
	}
	
	@Test
	@EnabledOnJre(JRE.JAVA_8)
	public void testMeOnJava8() {
		assertTrue("Windows".equalsIgnoreCase("Windows"));
	}
	
	@Test
	@EnabledOnJre(JRE.JAVA_9)
	public void testMeOnJava9() {
		assertTrue("Windows".equalsIgnoreCase("Windows"));
	}

}
