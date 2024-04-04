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
    private String status;
    private String description;
    private String complaintDate;
    private String resolvedDate;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
                ", status='" + status + '\'' +
                ", description='" + description + '\'' +
                ", complaintDate='" + complaintDate + '\'' +
                ", resolvedDate='" + resolvedDate + '\'' +
                '}';
    }
}
