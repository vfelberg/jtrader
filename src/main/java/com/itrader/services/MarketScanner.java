package com.itrader.services;

public class MarketScanner {
    private static final int DEFAULT_SCAN_PERIOD_MILLIS = 5000;

    private int scanPeriodMillis = DEFAULT_SCAN_PERIOD_MILLIS;
    private ScanResultListener scanResultListener;

    public void setScanPeriodMillis(int scanPeriodMillis) {
        this.scanPeriodMillis = scanPeriodMillis;
    }

    public void setScanResultListener(ScanResultListener scanResultListener) {
        this.scanResultListener = scanResultListener;
    }

    public void startScanning() {
        while (true) {
            System.out.println("Scanning markets");
            ScanResult scanResult = new ScanResult();
            scanResultListener.onScanResult(scanResult);
            try {
                Thread.sleep(scanPeriodMillis);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}
