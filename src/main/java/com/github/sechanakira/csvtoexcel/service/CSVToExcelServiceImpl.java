package com.github.sechanakira.csvtoexcel.service;

import com.github.sechanakira.csvtoexcel.exception.GeneralException;
import com.github.sechanakira.csvtoexcel.exception.OutputFileNotWritable;
import com.github.sechanakira.csvtoexcel.model.ConversionRequest;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class CSVToExcelServiceImpl implements CSVToExcelService {
    @Override
    public String csvToExcel(final ConversionRequest request) {
        try {
            final Path output = Paths.get(request.getOutputPath());
            if (!Files.exists(output)) {
                Files.createFile(output);
            }
            final boolean outputWritable = Files.isWritable(output);
            if (!outputWritable) {
                throw new OutputFileNotWritable(request.getOutputPath());
            }

            final List<String> lines = Files.readAllLines(Paths.get(request.getPath()));
            final String[] headers = lines.get(0).split("\\|");


        } catch (final IOException ex) {
            throw new GeneralException(ex.getMessage());
        }
        return request.getOutputPath();
    }
}
