package com.github.sechanakira.csvtoexcel.api;

import com.github.sechanakira.csvtoexcel.model.Request;
import com.github.sechanakira.csvtoexcel.service.CSVToExcelService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/convert")
public class CSVToExcelServiceEndpoint {

    private final CSVToExcelService service;

    public CSVToExcelServiceEndpoint(final CSVToExcelService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseBody
    public String convert(@RequestBody final Request request) {
        return service.csvToExcel(request);
    }
}
