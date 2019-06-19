package com.example.tdd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CollectionsDisjointTest {

	@Test
	public void shouldThrowNPE_whenEitherOfCollectionIsNull() {
		// Given
		List<String> src = null;
		List<String> dest = populateListFrom("New Zealand");

		// When
		// Then
		Assertions.assertThatNullPointerException().isThrownBy(() -> {
			Collections.disjoint(src, dest);
		});
	}

	@Test
	public void shouldThrowClassCastException_whenTwoCollectionsHaveDifferentTypeOfElements() {
		// Given
		List<String> src = new ArrayList<>();
		src.add("India");

		List<Integer> destList = new ArrayList<>();
		destList.add(1);

		// When
		boolean disjoint = Collections.disjoint(src, destList);

		Assertions.assertThat(disjoint).isEqualTo(Boolean.TRUE);

		// But if we use an ArrayList & a SortedSet in disjoint, it will throw
		// ClassCastException
		SortedSet<Integer> destSet = new TreeSet<>();
		destSet.add(1);

		// When
		// Then
		Assertions.assertThatExceptionOfType(ClassCastException.class).isThrownBy(() -> {
			Collections.disjoint(src, destSet);
		});
	}

	@Test
	public void shouldReturnFalse_whenTwoCollections_haveCommonElement() {
		// Given
		List<String> src = populateListFrom("India", "Netherlands", "New Zealand");
		List<String> dest = populateListFrom("New Zealand", "Netherlands");

		// When
		boolean disjoint = Collections.disjoint(src, dest);
		
		// Then
		Assertions.assertThat(disjoint).isEqualTo(Boolean.FALSE);
	}
	
	@Test
	public void shouldReturnTrue_whenTwoCollections_haveNoCommonElement() {
		// Given
		List<String> src = populateListFrom("India", "Netherlands");
		List<String> dest = populateListFrom("New Zealand", "Australia");

		// When
		boolean disjoint = Collections.disjoint(src, dest);
		
		// Then
		Assertions.assertThat(disjoint).isEqualTo(Boolean.TRUE);
	}

	private List<String> populateListFrom(String... elements) {
		List<String> listOfString = new ArrayList<>();

		for (String string : elements) {
			listOfString.add(string);
		}
		return listOfString;
	}

}
