package com.example.tdd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CollectionsReverseTest {

	@Test
	public void should_throwNPE_whenNullIsSentAsParameter() {
		// Given
		
		// When
		
		// Then
		Assertions.assertThatNullPointerException().isThrownBy(() -> {
			Collections.reverse(null);
		});
	}

	@Test
	public void shouldReverse_allElementsInList() {
		// Given
		List<String> src = populateListFrom("India", "Netherlands", "United Kingdom");

		// When
		Collections.reverse(src);

		// Then
		Assertions.assertThat(src.size()).isEqualTo(3);
		Assertions.assertThat(src.get(0)).isEqualTo("United Kingdom");
		Assertions.assertThat(src.get(1)).isEqualTo("Netherlands");
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
