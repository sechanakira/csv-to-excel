package com.github.sechanakira.csvtoexcel.api;

import com.github.sechanakira.csvtoexcel.model.Request;
import com.github.sechanakira.csvtoexcel.service.ProvidersReportService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/providers")
public class ProvidersReport {

    final ProvidersReportService service;

    public ProvidersReport(final ProvidersReportService service){
        this.service = service;
    }

    @PostMapping
    @ResponseBody
    public String generateReport(final @RequestBody Request request){
        return service.generateReport(request);
    }
}
