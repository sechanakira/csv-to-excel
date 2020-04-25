package com.github.sechanakira.csvtoexcel.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Request {

    @NotNull
    @NotBlank
    @NotEmpty
    private String path;

    @NotNull
    @NotBlank
    @NotEmpty
    private String outputPath;


    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getOutputPath() {
        return outputPath;
    }

    public void setOutputPath(String outputPath) {
        this.outputPath = outputPath;
    }
}
