package com.example.tdd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CollectionsFrequencyTest {

	@Test
	public void shouldThrowNPE_whenNullIsPassedAsCollection() {
		// Given

		// When
		
		// Then
		Assertions.assertThatNullPointerException().isThrownBy(() -> {
			Collections.frequency(null, "India");
		});
	}
	
	@Test
	public void should_ReturnOne_whenStringAppearsOnceInCollection() {
		// Given
		List<String> src = populateListFrom("India", "Netherlands", "New Zealand");

		// When
		int frequency = Collections.frequency(src, "India");
		
		// Then
		Assertions.assertThat(frequency).isEqualTo(1);
		Assertions.assertThat(src.get(0)).isEqualTo("India");
	}
	
	@Test
	public void should_ReturnTwo_whenStringAppearsTwiceInCollection() {
		// Given
		List<String> src = populateListFrom("India", "Netherlands", "New Zealand", "India");

		// When
		int frequency = Collections.frequency(src, "India");
		
		// Then
		Assertions.assertThat(frequency).isEqualTo(2);
	}

	
	@Test
	public void should_ReturnTwo_whenNullAppearsTwiceInCollection() {
		// Given
		List<String> src = populateListFrom("India", "Netherlands", "New Zealand", null, null);

		// When
		int frequency = Collections.frequency(src, null);
		
		// Then
		Assertions.assertThat(frequency).isEqualTo(2);
	}

	private List<String> populateListFrom(String... elements) {
		List<String> listOfString = new ArrayList<>();

		for (String string : elements) {
			listOfString.add(string);
		}
		return listOfString;
	}

}
