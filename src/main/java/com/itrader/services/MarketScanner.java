package com.itrader.services;

import java.util.ArrayList;
import java.util.Collection;

public class MarketScanner {
    private static final int DEFAULT_SCAN_PERIOD_MILLIS = 5000;

    private int scanPeriodMillis = DEFAULT_SCAN_PERIOD_MILLIS;
    private Collection<ScanResultListener> scanResultListeners = new ArrayList<>();

    public void setScanPeriodMillis(int scanPeriodMillis) {
        this.scanPeriodMillis = scanPeriodMillis;
    }

    public void addScanResultListener(ScanResultListener scanResultListener) {
        scanResultListeners.add(scanResultListener);
    }

    public void startScanning() {
        while (true) {
            System.out.println("Scanning markets");
            ScanResult scanResult = new ScanResult();
            for (ScanResultListener scanResultListener : scanResultListeners) {
                scanResultListener.onScanResult(scanResult);
            }
            try {
                Thread.sleep(scanPeriodMillis);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}
