package com.login.utils;

import com.opencsv.CSVReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CSVReaderUtil {

    public static Object[][] readCSV(String filePath) {

        List<Object[]> data = new ArrayList<>();

        try {
            InputStream is = CSVReaderUtil.class
                    .getClassLoader()
                    .getResourceAsStream(filePath);

            CSVReader reader = new CSVReader(new InputStreamReader(is));
            String[] line;

            reader.readNext(); // skip header

            while ((line = reader.readNext()) != null) {
                data.add(line);
            }

            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return data.toArray(new Object[0][]);
    }
}
