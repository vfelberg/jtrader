package com.itrader;

import static com.itrader.Utilities.breakoutDown;
import static com.itrader.Utilities.breakoutUp;
import static com.itrader.Utilities.simpleAverage;
import static com.itrader.Utilities.breakoutDown_Candle;
import static com.itrader.Utilities.breakoutUp_Candle;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

import com.itrader.model.Candle;

public class UtilitiesTest {

	@Test
	public void testSimpleAverage() {
		try {
			simpleAverage();
			fail("Exception expected for empty argument array");
		} catch (IllegalArgumentException e) {
			// expected
		}
		
		assertEquals(-1, simpleAverage(-1), 0);
		assertEquals(7.5, simpleAverage(5, 10), 0);
		assertEquals(2, simpleAverage(1, 2, 3), 0);
		assertEquals(1.5, simpleAverage(-2, 5, -7, 10), 0);
	}

	@Test
	public void testBreakoutDown() {
		assertTrue(breakoutDown(10, 12, 20, 11, 25, 13, 11));
		assertFalse(breakoutDown(10, 12, 20, 11, 8, 13, 11));
	}

	@Test
	public void testBreakoutDown_Candles() {
		Candle currentPrice = new Candle();
		currentPrice.setClose(10);
		currentPrice.setOpen(22);
		System.out.println("Current price: " + currentPrice);
		
		Candle c1 = new Candle();
		c1.setClose(12);
		c1.setOpen(14);
		System.out.println("C1: " + c1);
		
		Candle c2 = new Candle();
		c2.setClose(20);
		System.out.println("C2: " + c2);

		Candle c3 = new Candle();
		c3.setClose(12);
		System.out.println("C3: " + c3);
		
		Candle c4 = new Candle();
		c4.setClose(8);
		System.out.println("C4: " + c4);

		Candle[] array1 = new Candle[] {c1, c2};
		Candle[] array2 = new Candle[] {c3, c4};
		
		assertTrue(breakoutDown_Candle(currentPrice, array1));
		assertFalse(breakoutDown_Candle(currentPrice, array2));
	}

	@Test
	public void testBreakoutUp_Candles() {
		Candle currentPrice = new Candle();
		currentPrice.setClose(22);
		currentPrice.setOpen(10);
		System.out.println("Current price: " + currentPrice);
		
		Candle c1 = new Candle();
		c1.setClose(14);
		c1.setOpen(12);
		System.out.println("C1: " + c1);
		
		Candle c2 = new Candle();
		c2.setClose(20);
		System.out.println("C2: " + c2);

		Candle c3 = new Candle();
		c3.setClose(24);
		System.out.println("C3: " + c3);
		
		Candle c4 = new Candle();
		c4.setClose(8);
		System.out.println("C4: " + c4);

		Candle[] array1 = new Candle[] {c1, c2};
		Candle[] array2 = new Candle[] {c3, c4};
		
		assertTrue(breakoutUp_Candle(currentPrice, array1));
		assertFalse(breakoutUp_Candle(currentPrice, array2));
	}

	@Test
	public void testBreakoutUp() {
		assertTrue(breakoutUp(26, 12, 20, 11, 25, 13, 11));
		assertFalse(breakoutUp(7, 12, 20, 11, 8, 13, 11));
	}
	
	@Test
	public void testIteration() {
		Collection<Integer> collection = new ArrayList<>();
		for (int i = -50; i <= 100; i += 2) {
			collection.add(i);
		}
		System.out.println("Size of collection: " + collection.size());

		for (Integer number :  collection) { // for each number in collection
			System.out.println("Collection number: " + number);
		}
		
		int[] array = new int[76];
		for (int i = -50, j=0; i <= 100; i += 2, j++) {
			array[j] = i;
		}
		System.out.println("Size of array: " + array.length);
		
		for (Integer number :  array) { // for each number in array
			System.out.println("Array number: " + number);
		}
	}
}
