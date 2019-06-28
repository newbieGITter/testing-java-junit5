package com.example.tdd;

import static org.junit.jupiter.api.Assertions.assertAll;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CustomArrayListTest {

	private CustomArrayList cal = new CustomArrayList();

	@BeforeEach
	public void setup() {
		cal.add(new Integer(2));
		cal.add(new Integer(5));
		cal.add(new Integer(1));
		cal.add(new Integer(23));
		cal.add(new Integer(14));
	}

	@Test
	public void should_returnFive_whenFiveElementsAdded_inList() {
		// Given

		// When

		// then
		Assertions.assertThat(cal.getSize()).isEqualTo(5);
	}

	@Test
	public void shouldThrowException_whenIndexGreaterThanListSize() {
		// Given

		// When
		// cal.get(99);

		// Then
		assertAll("Test throwing exceptions in multiple scenarios",
				() -> Assertions.assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> {
					cal.get(-1);
				}), () -> Assertions.assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> {
					cal.get(99);
				}));
	}

	@Test
	public void shouldReturnElement_whenValidIndex_withinListIsPassed() {
		// Given

		// When
		Object element = cal.get(3);

		// Then
		Assertions.assertThat(element).isEqualTo(23);
	}

	@Test
	public void shouldThrowException_whenTryingToRemoveElement_withNonExistingIndex() {
		// Given

		// When

		// Then
		assertAll("Test throwing exceptions in multiple scenarios",
				() -> Assertions.assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> {
					cal.remove(-1);
				}), () -> Assertions.assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> {
					cal.remove(99);
				}));
	}

	@Test
	public void shouldReturnRemovedObject_whenRemovingElement_withExistingIndex() {
		// Given

		// When
		Object removedObj = cal.remove(3);

		// Then
		Assertions.assertThat(removedObj).isEqualTo(23);
		Assertions.assertThat(cal.get(3)).isEqualTo(14);
		Assertions.assertThat(cal.getSize()).isEqualTo(4);
	}

}
