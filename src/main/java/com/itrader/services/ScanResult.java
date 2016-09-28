package com.itrader.services;

import com.itrader.model.Candle;

import java.util.Collection;

public class ScanResult {
    private Collection<Candle> candles;

    public Collection<Candle> getCandles() {
        return candles;
    }

    public void setCandles(Collection<Candle> candles) {
        this.candles = candles;
    }
}
