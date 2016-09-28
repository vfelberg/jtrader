package com.itrader.model;

import java.util.Date;

public class Candle {
	private float open;
	private float close;
	private float high;
	private float low;
    private Date date;
    private int volume;

	public float getOpen() {
		return open;
	}

	public void setOpen(float open) {
		this.open = open;
	}

	public float getClose() {
		return close;
	}

	public void setClose(float close) {
		this.close = close;
	}

	public float getHigh() {
		return high;
	}

	public void setHigh(float high) {
		this.high = high;
	}

	public float getLow() {
		return low;
	}

	public void setLow(float low) {
		this.low = low;
	}

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean lessThanOrEqual(Candle otherCandle) {
		return close <= otherCandle.close;
	}

	public boolean greaterThanOrEqual(Candle otherCandle) {
		return close >= otherCandle.close;
	}

	
	@Override
	public String toString() {
		return "open: " + open + ", close: " + close;
	}
}
