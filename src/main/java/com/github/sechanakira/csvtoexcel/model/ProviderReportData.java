package com.github.sechanakira.csvtoexcel.model;

import java.time.LocalDate;

public class ProviderReportData {
    private String accountNumber;
    private LocalDate createdAt;
    private String loanType;
    private String status;
    private LocalDate from;

    public ProviderReportData(String accountNumber, LocalDate createdAt, String loanType, String status, LocalDate from) {
        this.accountNumber = accountNumber;
        this.createdAt = createdAt;
        this.loanType = loanType;
        this.status = status;
        this.from = from;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getFrom() {
        return from;
    }

    public void setFrom(LocalDate from) {
        this.from = from;
    }
}
