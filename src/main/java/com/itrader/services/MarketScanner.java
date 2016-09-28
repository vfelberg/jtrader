package com.itrader.services;

import com.itrader.model.PriceProvider;

import java.util.ArrayList;
import java.util.Collection;

public class MarketScanner {
    private static final int DEFAULT_SCAN_PERIOD_MILLIS = 5000;

    private int scanPeriodMillis = DEFAULT_SCAN_PERIOD_MILLIS;

    private Collection<PriceProvider> priceProviders = new ArrayList<>();
    private Collection<ScanResultListener> scanResultListeners = new ArrayList<>();

    public void setScanPeriodMillis(int scanPeriodMillis) {
        this.scanPeriodMillis = scanPeriodMillis;
    }

    public void addPriceProvider(PriceProvider priceProvider) {
        priceProviders.add(priceProvider);
    }

    public void addScanResultListener(ScanResultListener scanResultListener) {
        scanResultListeners.add(scanResultListener);
    }

    public void startScanning() {
        while (true) {
            System.out.println("Scanning markets");

            for (PriceProvider provider : priceProviders) {
                System.out.println("Scanning " + provider.getName());
                ScanResult scanResult = scanProvider(provider);

                for (ScanResultListener scanResultListener : scanResultListeners) {
                    scanResultListener.onScanResult(scanResult);
                }
            }

            try {
                Thread.sleep(scanPeriodMillis);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }

    private ScanResult scanProvider(PriceProvider priceProvider) {
        ScanResult scanResult = new ScanResult();
        scanResult.setCandles(priceProvider.getPrices());
        return scanResult;
    }
}
