package com.oniesoft.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class RaiseDispute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int regno;
    private String email;
    private String empId;
    private String status;
    private String selectedSubType;
    private String  selectedMainType;
    private String description;
    private String responseText;
    private String complaintDate;
    private String resolvedDate;
    public RaiseDispute(){

    }

    public int getRegno() {
        return regno;
    }

    public void setRegno(int regno) {
        this.regno = regno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSelectedSubType() {
        return selectedSubType;
    }

    public void setSelectedSubType(String selectedSubType) {
        this.selectedSubType = selectedSubType;
    }

    public String getSelectedMainType() {
        return selectedMainType;
    }

    public void setSelectedMainType(String selectedMainType) {
        this.selectedMainType = selectedMainType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResponseText() {
        return responseText;
    }

    public void setResponseText(String responseText) {
        this.responseText = responseText;
    }

    public String getComplaintDate() {
        return complaintDate;
    }

    public void setComplaintDate(String complaintDate) {
        this.complaintDate = complaintDate;
    }

    public String getResolvedDate() {
        return resolvedDate;
    }

    public void setResolvedDate(String resolvedDate) {
        this.resolvedDate = resolvedDate;
    }

    @Override
    public String toString() {
        return "RaiseDispute{" +
                "regno=" + regno +
                ", email='" + email + '\'' +
                ", empId='" + empId + '\'' +
                ", status='" + status + '\'' +
                ", selectedSubType='" + selectedSubType + '\'' +
                ", selectedMainType='" + selectedMainType + '\'' +
                ", description='" + description + '\'' +
                ", responseText='" + responseText + '\'' +
                ", complaintDate='" + complaintDate + '\'' +
                ", resolvedDate='" + resolvedDate + '\'' +
                '}';
    }
}
