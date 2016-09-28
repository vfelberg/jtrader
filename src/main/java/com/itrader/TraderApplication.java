package com.itrader;

import com.itrader.model.PriceProvider;
import com.itrader.services.MarketScanner;
import com.itrader.services.ScanResultListener;

public class TraderApplication {
    public static void main(String[] args) {

        PriceProvider provider1 = new PriceProvider();
        PriceProvider provider2 = new PriceProvider();

        provider1.setName("Deutsche Bank");
        provider2.setName("Lang & Schwarz");
        provider1.setUrl("http://www.deutsche-bank.de");
        provider2.setUrl("http://www.ls-d.de");


        MarketScanner scanner = new MarketScanner();
        scanner.setScanPeriodMillis(10000);
        scanner.addPriceProvider(provider1);
        scanner.addPriceProvider(provider2);
        scanner.addScanResultListener(new ScanResultListener());
        scanner.startScanning();
    }
}
