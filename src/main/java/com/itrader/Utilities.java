package com.itrader;

import com.itrader.model.Candle;

public class Utilities {
	/**
	 * Computes simple average of specified numbers.
	 * 
	 * @param numbers
	 *            must not be empty
	 * @return simple average
	 * @throws IllegalArgumentException
	 *             if the numbers array is empty
	 */
	public static float simpleAverage(float... numbers) {
		if (numbers.length == 0) {
			throw new IllegalArgumentException("Argument array must not be empty");
		}
		float sum = 0;
		for (float number : numbers) {
			sum = sum + number;
		}
		return sum / numbers.length;
	}

	/**
	 * Return true if current price is less than all prices in the price window.
	 */
	public static boolean breakoutDown(float currentPrice, float... priceWindow) {
		for (float price : priceWindow) {
			if (price <= currentPrice) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Return true if current price is larger than all prices in the price window.
	 */
	public static boolean breakoutUp(float currentPrice, float... priceWindow) {
		for (float price : priceWindow) {
			if (price >= currentPrice) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean breakoutDown_Candle(Candle currentPrice, Candle... priceWindow) {
		for (Candle price : priceWindow) {
			if (price.lessThanOrEqual(currentPrice)) {
				return false;
			}
		}
		return true;
	}
		
	public static boolean breakoutUp_Candle(Candle currentPrice, Candle... priceWindow) {
		for (Candle price : priceWindow) {
			if (price.greaterThanOrEqual(currentPrice)) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println("Hello world");
	}
}
