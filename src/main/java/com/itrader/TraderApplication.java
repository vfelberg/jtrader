package com.itrader;

import com.itrader.model.CsvPriceProvider;
import com.itrader.model.InternetPriceProvider;
import com.itrader.model.PriceProvider;
import com.itrader.services.MarketScanner;
import com.itrader.services.ScanResultListener;

public class TraderApplication {
    public static void main(String[] args) {

        PriceProvider provider1 = new CsvPriceProvider();
        PriceProvider provider2 = new InternetPriceProvider();

        MarketScanner scanner = new MarketScanner();
        scanner.setScanPeriodMillis(10000);
        scanner.addPriceProvider(provider1);
        scanner.addPriceProvider(provider2);
        scanner.addScanResultListener(new ScanResultListener());
        scanner.startScanning();
    }
}
