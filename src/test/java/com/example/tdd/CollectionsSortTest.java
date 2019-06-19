package com.example.tdd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CollectionsSortTest {

	@Test
	public void should_throwNPE_whenNullIsSentAsParameter() {
		// Given
		
		// When
		
		// Then
		Assertions.assertThatNullPointerException().isThrownBy(() -> {
			Collections.sort(null, null);
		});
	}
	
	@Test
	public void should_throwClassCastException_whenElementsAreNotMutuallyComparable() {
		// Given
		List<Object> shoppingCartList = populateListFrom(new Integer(1), "India");
		
		// When
		
		// Then
		Assertions.assertThatExceptionOfType(ClassCastException.class).isThrownBy(() -> {
			Collections.sort(shoppingCartList, null);
		});
	}
	
	@Test
	public void should_sortAlphabetically_forListofStrings() {
		// Given
		List<Object> countryList = populateListFrom("India", "New Zealand", "Zimbabwe", "Australia");
		
		// When
		Collections.sort(countryList, null);
		
		// Then
		Assertions.assertThat(countryList.size()).isEqualTo(4);
		Assertions.assertThat(countryList.get(0)).isEqualTo("Australia");
		Assertions.assertThat(countryList.get(3)).isEqualTo("Zimbabwe");
	}
	
	@Test
	public void should_sortNumerically_forListOfIntegers() {
		// Given
		List<Object> countryList = populateListFrom(22, 44, 33, 55, 27);
		
		// When
		Collections.sort(countryList, null);
		
		// Then
		Assertions.assertThat(countryList.size()).isEqualTo(5);
		Assertions.assertThat(countryList.get(0)).isEqualTo(22);
		Assertions.assertThat(countryList.get(4)).isEqualTo(55);
	}

	private List<Object> populateListFrom(Object... elements) {
		List<Object> listOfThings = new ArrayList<>();

		for (Object obj : elements) {
			listOfThings.add(obj);
		}
		return listOfThings;
	}

}
