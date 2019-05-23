package guru.springframework.sfgpetclinic.controllers;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import guru.springframework.sfgpetclinic.fauxspring.Model;
import guru.springframework.sfgpetclinic.fauxspring.ModelMapImpl;
import guru.springframework.sfgpetclinic.services.SpecialtyService;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.map.SpecialityMapService;
import guru.springframework.sfgpetclinic.services.map.VetMapService;

class VetControllerTest implements ControllerTests {
	
	private VetController vetController;
	
	private VetService vetService;
	
	private SpecialtyService specialtyService;

	@BeforeEach
	void setUp() throws Exception {
		specialtyService = new SpecialityMapService();
		vetService = new VetMapService(specialtyService);
		vetController = new VetController(vetService);
	}

	@Test
	void testListVets() {
		Model model = new ModelMapImpl();
		
		String view = vetController.listVets(model);
		
		assertThat("vets/index").isEqualTo(view);
	}

}
