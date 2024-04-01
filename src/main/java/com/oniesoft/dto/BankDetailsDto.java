package com.oniesoft.dto;

import java.util.List;

public class BankDetailsDto {
    private Long regno;
    private String email;
    private String bankName;
    private String branch;
    private String ifcCode;
    private String accountNumber;
    private String name;
    private String bankFile;
    private List<String> filePaths;
    private List<byte[]> fileContents;

    // Getters and setters

    public Long getRegno() {
        return regno;
    }

    public void setRegno(Long regno) {
        this.regno = regno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getIfcCode() {
        return ifcCode;
    }

    public void setIfcCode(String ifcCode) {
        this.ifcCode = ifcCode;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBankFile() {
        return bankFile;
    }

    public void setBankFile(String bankFile) {
        this.bankFile = bankFile;
    }

    public List<String> getFilePaths() {
        return filePaths;
    }

    public void setFilePaths(List<String> filePaths) {
        this.filePaths = filePaths;
    }

    public List<byte[]> getFileContents() {
        return fileContents;
    }

    public void setFileContents(List<byte[]> fileContents) {
        this.fileContents = fileContents;
    }

    @Override
    public String toString() {
        return "BankDetailsDto{" +
                "regno=" + regno +
                ", email='" + email + '\'' +
                ", bankName='" + bankName + '\'' +
                ", branch='" + branch + '\'' +
                ", ifcCode='" + ifcCode + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", name='" + name + '\'' +
                ", bankFile='" + bankFile + '\'' +
                ", filePaths=" + filePaths +
                ", fileContents=" + fileContents +
                '}';
    }
}
