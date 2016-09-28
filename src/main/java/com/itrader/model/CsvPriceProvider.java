package com.itrader.model;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;

public class CsvPriceProvider implements PriceProvider {
    @Override
    public String getName() {
        return "CSV price provider";
    }

    @Override
    public Collection<Candle> getPrices() {
        Collection<Candle> result = new ArrayList<>();
        try {
            File file = new File("dax.csv");
            CSVParser parser = CSVParser.parse(file, Charset.forName("UTF-8"), CSVFormat.RFC4180.withFirstRecordAsHeader());
            for (CSVRecord csvRecord : parser) {
                Candle candle = new Candle();
                String open = csvRecord.get("Open");
                candle.setOpen(Float.parseFloat(open));
                result.add(candle);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
