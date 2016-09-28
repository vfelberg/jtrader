package com.itrader.services;

public class ScanResultListener {
    public void onScanResult(ScanResult scanResult) {
        System.out.println("Processing scan result: " + scanResult.getCandles());
    }
}
