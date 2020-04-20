package com.github.sechanakira.csvtoexcel.service;

import com.github.sechanakira.csvtoexcel.model.ConversionRequest;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

@Service
public class CSVToExcelServiceImpl implements CSVToExcelService {
    @Override
    public String csvToExcel(final ConversionRequest request) {
        try {
            final List<String> lines = Files.readAllLines(Paths.get(request.getPath()));
            final String[] headers = lines.get(0).split("|");
            System.out.println(Arrays.toString(headers));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
