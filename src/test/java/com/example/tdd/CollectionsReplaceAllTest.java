package com.example.tdd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CollectionsReplaceAllTest {

	@Test
	public void shouldReplaceOccurenceOfAnElement_withProvidedElement() {
		// Given
		List<String> src = populateListFrom("India", "Netherlands", "Uganda");

		// When
		Collections.replaceAll(src, "Uganda", "United Kingdom");

		// Then
		Assertions.assertThat(src.size()).isEqualTo(3);
		Assertions.assertThat(src.get(2)).isEqualTo("United Kingdom");
	}

	@Test
	public void shouldReplaceAllOccurencesOfAnElement_withProvidedElement() {
		// Given
		List<String> src = populateListFrom("India", "Uganda", "Netherlands", "Uganda");

		// When
		Collections.replaceAll(src, "Uganda", "United Kingdom");

		// Then
		Assertions.assertThat(src.size()).isEqualTo(4);
		Assertions.assertThat(src.get(1)).isEqualTo("United Kingdom");
		Assertions.assertThat(src.get(3)).isEqualTo("United Kingdom");
	}

	private List<String> populateListFrom(String... elements) {
		List<String> listOfString = new ArrayList<>();

		for (String string : elements) {
			listOfString.add(string);
		}
		return listOfString;
	}

}
