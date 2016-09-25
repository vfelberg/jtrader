package com.itrader;

import com.itrader.services.MarketScanner;
import com.itrader.services.ScanResultListener;

public class TraderApplication {
    public static void main(String[] args) {
        MarketScanner scanner = new MarketScanner();
        scanner.setScanPeriodMillis(10000);
        scanner.setScanResultListener(new ScanResultListener());
        scanner.startScanning();
    }
}
