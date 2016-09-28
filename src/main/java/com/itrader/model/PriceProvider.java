package com.itrader.model;

import java.util.Collection;

public interface PriceProvider {
    String getName();

    Collection<Candle> getPrices();
}
