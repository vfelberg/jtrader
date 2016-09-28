package com.itrader.model;

import java.util.Collection;

public class InternetPriceProvider implements PriceProvider {

    @Override
    public String getName() {
        return "Internet price provider";
    }

    @Override
    public Collection<Candle> getPrices() {
        // TODO fetch the price from the internet
        return null;
    }
}
