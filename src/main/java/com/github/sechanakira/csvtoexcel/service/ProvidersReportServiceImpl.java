package com.github.sechanakira.csvtoexcel.service;

import com.github.sechanakira.csvtoexcel.model.ProviderReportData;
import com.github.sechanakira.csvtoexcel.model.Request;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProvidersReportServiceImpl implements ProvidersReportService {
    @Override
    public String generateReport(final Request request) {
        try {
            final Path output = Paths.get(request.getOutputPath());
            if (!Files.exists(output)) {
                Files.createFile(output);
            }

            final Path path = Paths.get(request.getPath());
            final List<String> lines = Files.readAllLines(path);
            final List<ProviderReportData> providerReportData = lines.stream()
                    .map(line -> new ProviderReportData(
                            line.split(",")[0],
                            LocalDate.parse(line.split(",")[1]),
                            line.split(",")[2],
                            line.split(",")[3],
                            LocalDate.parse(line.split(",")[4])
                    ))
                    .collect(Collectors.toList());

            final XSSFWorkbook workbook = new XSSFWorkbook();

            for (int i = 0; i < providerReportData.size(); i++) {
                final ProviderReportData data = providerReportData.get(i);
                final String sheetName = data.getCreatedAt().getMonth().name() + " " + data.getCreatedAt().getYear();
                XSSFSheet sheet = workbook.getSheet(sheetName);
                if (sheet == null) {
                    sheet = workbook.createSheet(sheetName);
                }
                final Row row = sheet.createRow(sheet.getLastRowNum() + 1);

                final Cell cell1 = row.createCell(0);
                cell1.setCellValue(data.getAccountNumber());

                final Cell cell2 = row.createCell(1);
                cell2.setCellValue(data.getCreatedAt().toString());

                final Cell cell3 = row.createCell(2);
                cell3.setCellValue(data.getLoanType());

                final Cell cell4 = row.createCell(3);
                cell4.setCellValue(data.getStatus());

                final Cell cell5 = row.createCell(4);
                cell5.setCellValue(data.getFrom().toString());
            }

            final FileOutputStream outputStream = new FileOutputStream(request.getOutputPath());
            workbook.write(outputStream);
            workbook.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return request.getOutputPath();
    }

}
