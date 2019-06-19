package com.example.tdd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CollectionsFillTest {

	@Test
	public void should_replaceAllElementsWithNull_forNullParameter() {
		// Given
		List<String> src = populateListFrom("Germany", "Netherlands", "New Zealand");

		// When
		Collections.fill(src, null);
		
		// Then
		Assertions.assertThat(src.size()).isEqualTo(3);
		Assertions.assertThat(src.get(0)).isNull();
	}
	
	@Test
	public void should_replaceAllElementsWithStringParameter() {
		// Given
		List<String> src = populateListFrom("Germany", "Netherlands", "New Zealand");

		// When
		Collections.fill(src, "India");
		
		// Then
		Assertions.assertThat(src.size()).isEqualTo(3);
		Assertions.assertThat(src.get(0)).isEqualTo("India");
		Assertions.assertThat(src.get(1)).isEqualTo("India");
		Assertions.assertThat(src.get(2)).isEqualTo("India");
	}

	private List<String> populateListFrom(String... elements) {
		List<String> listOfString = new ArrayList<>();

		for (String string : elements) {
			listOfString.add(string);
		}
		return listOfString;
	}

}
