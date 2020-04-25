package com.github.sechanakira.csvtoexcel.service;

import com.github.sechanakira.csvtoexcel.model.Request;

@FunctionalInterface
public interface ProvidersReportService {
    String generateReport(final Request request);
}
