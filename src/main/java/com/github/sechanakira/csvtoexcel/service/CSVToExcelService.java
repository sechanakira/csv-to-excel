package com.github.sechanakira.csvtoexcel.service;

import com.github.sechanakira.csvtoexcel.model.ConversionRequest;

@FunctionalInterface
public interface CSVToExcelService {
    String csvToExcel(final ConversionRequest request);
}
