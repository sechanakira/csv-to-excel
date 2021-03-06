package com.github.sechanakira.csvtoexcel.service;

import com.github.sechanakira.csvtoexcel.model.Request;

@FunctionalInterface
public interface CSVToExcelService {
    String csvToExcel(final Request request);
}
