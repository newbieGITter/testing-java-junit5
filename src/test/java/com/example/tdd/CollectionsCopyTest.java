package com.example.tdd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CollectionsCopyTest {

	@Test
	public void shouldThrowException_whenDestHasLessElements() {
		// Given
		List<String> src = populateListFrom("India", "Netherlands");
		List<String> dest = populateListFrom("New Zealand");
		
		// When
		// Then
		Assertions.assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> {
			Collections.copy(dest, src);
		}).withMessage("Source does not fit in dest");
	}

	@Test
	public void shouldChangeNothingInDestList_whensrcListIsEmpty() {
		// Given
		List<String> src = populateListFrom();
		List<String> dest = populateListFrom("New Zealand");

		// When
		Collections.copy(dest, src);
		
		Assertions.assertThat(dest.size()).isEqualTo(1);
		Assertions.assertThat(dest.get(0)).isEqualTo("New Zealand");
	}
	
	
	@Test
	public void shouldCopySrcElements_andRemoveDestElements_whenDestHasEqualElements() {
		// Given
		List<String> src = populateListFrom("India", "Netherlands");
		List<String> dest = populateListFrom("New Zealand", "Germany");

		// When
		Collections.copy(dest, src);
		
		// Then
		Assertions.assertThat(dest.size()).isEqualTo(2);
		Assertions.assertThat(dest.get(0)).isEqualTo("India");
		Assertions.assertThat(dest.get(1)).isEqualTo("Netherlands");
	}
	
	@Test
	public void shouldCopySrcElements_butRetainDestElements_whenDestHasMoreElements() {
		// Given
		List<String> src = populateListFrom("India", "Netherlands");
		List<String> dest = populateListFrom("New Zealand", "Germany", "France");

		// When
		Collections.copy(dest, src);

		// Then
		Assertions.assertThat(dest.size()).isEqualTo(3);
	}

	private List<String> populateListFrom(String... elements) {
		List<String> listOfString = new ArrayList<>();
		
		for (String string : elements) {
			listOfString.add(string);
		}
		return listOfString;
	}

}
