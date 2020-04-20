package com.github.sechanakira.csvtoexcel.exception;

public class OutputFileNotWritable extends RuntimeException {
    public OutputFileNotWritable(final String msg) {
        super(msg);
    }
}
