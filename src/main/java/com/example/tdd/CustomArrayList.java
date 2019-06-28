package com.example.tdd;

import java.util.Arrays;

public class CustomArrayList {

	private Object elementData[];
	private static final int INITIAL_CAPACITY = 10;
	private int size;
	
	public CustomArrayList() {
		elementData = new Object[INITIAL_CAPACITY];
	}
	
	public void add(Integer integer) {
		if(size == elementData.length) {
			ensureCapacity(); // increase current capacity of list, make it double
		}
		elementData[size++] = integer;
	}

	private void ensureCapacity() {
		int newIncreasedCapacity = elementData.length * 2;
		elementData = Arrays.copyOf(elementData, newIncreasedCapacity);
		
	}

	public int getSize() {
		return size;
	}

	public Object get(int index) {
		if( index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", size: " + size);
		}
		return elementData[index];
	}

}
