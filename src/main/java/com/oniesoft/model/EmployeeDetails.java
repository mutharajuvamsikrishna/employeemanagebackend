package com.oniesoft.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EmployeeDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int laptopId;
    private String empId;
private  String totalExperience;
private String currentCtc;
private String role;
private String designation;
private String joinDate;
private String isLaptop;
private String laptopIssueDate;
private String laptopModel;

private String pf;
private String domain;
private String skills;
private String onsite;
private String countries;
private String cities;
private String companyNames;
private String clientSupport;
private String prevCompany;
private String prevEmpId;
private String prevJoinDate;
private String prevEndDate;
private String prevDomain;
private String prevCtc;
    private String prevCompany1;
    private String prevEmpId1;
    private String prevJoinDate1;
    private String prevEndDate1;
    private String prevDomain1;
    private String prevCtc1;
    public EmployeeDetails(){

    }

    public int getLaptopId() {
        return laptopId;
    }

    public void setLaptopId(int laptopId) {
        this.laptopId = laptopId;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getTotalExperience() {
        return totalExperience;
    }

    public void setTotalExperience(String totalExperience) {
        this.totalExperience = totalExperience;
    }

    public String getCurrentCtc() {
        return currentCtc;
    }

    public void setCurrentCtc(String currentCtc) {
        this.currentCtc = currentCtc;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public String getIsLaptop() {
        return isLaptop;
    }

    public void setIsLaptop(String isLaptop) {
        this.isLaptop = isLaptop;
    }

    public String getLaptopIssueDate() {
        return laptopIssueDate;
    }

    public void setLaptopIssueDate(String laptopIssueDate) {
        this.laptopIssueDate = laptopIssueDate;
    }

    public String getLaptopModel() {
        return laptopModel;
    }

    public void setLaptopModel(String laptopModel) {
        this.laptopModel = laptopModel;
    }

    public String getPf() {
        return pf;
    }

    public void setPf(String pf) {
        this.pf = pf;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getOnsite() {
        return onsite;
    }

    public void setOnsite(String onsite) {
        this.onsite = onsite;
    }

    public String getCountries() {
        return countries;
    }

    public void setCountries(String countries) {
        this.countries = countries;
    }

    public String getCities() {
        return cities;
    }

    public void setCities(String cities) {
        this.cities = cities;
    }

    public String getCompanyNames() {
        return companyNames;
    }

    public void setCompanyNames(String companyNames) {
        this.companyNames = companyNames;
    }

    public String getClientSupport() {
        return clientSupport;
    }

    public void setClientSupport(String clientSupport) {
        this.clientSupport = clientSupport;
    }

    public String getPrevCompany() {
        return prevCompany;
    }

    public void setPrevCompany(String prevCompany) {
        this.prevCompany = prevCompany;
    }

    public String getPrevEmpId() {
        return prevEmpId;
    }

    public void setPrevEmpId(String prevEmpId) {
        this.prevEmpId = prevEmpId;
    }

    public String getPrevJoinDate() {
        return prevJoinDate;
    }

    public void setPrevJoinDate(String prevJoinDate) {
        this.prevJoinDate = prevJoinDate;
    }

    public String getPrevEndDate() {
        return prevEndDate;
    }

    public void setPrevEndDate(String prevEndDate) {
        this.prevEndDate = prevEndDate;
    }

    public String getPrevDomain() {
        return prevDomain;
    }

    public void setPrevDomain(String prevDomain) {
        this.prevDomain = prevDomain;
    }

    public String getPrevCtc() {
        return prevCtc;
    }

    public void setPrevCtc(String prevCtc) {
        this.prevCtc = prevCtc;
    }

    public String getPrevCompany1() {
        return prevCompany1;
    }

    public void setPrevCompany1(String prevCompany1) {
        this.prevCompany1 = prevCompany1;
    }

    public String getPrevEmpId1() {
        return prevEmpId1;
    }

    public void setPrevEmpId1(String prevEmpId1) {
        this.prevEmpId1 = prevEmpId1;
    }

    public String getPrevJoinDate1() {
        return prevJoinDate1;
    }

    public void setPrevJoinDate1(String prevJoinDate1) {
        this.prevJoinDate1 = prevJoinDate1;
    }

    public String getPrevEndDate1() {
        return prevEndDate1;
    }

    public void setPrevEndDate1(String prevEndDate1) {
        this.prevEndDate1 = prevEndDate1;
    }

    public String getPrevDomain1() {
        return prevDomain1;
    }

    public void setPrevDomain1(String prevDomain1) {
        this.prevDomain1 = prevDomain1;
    }

    public String getPrevCtc1() {
        return prevCtc1;
    }

    public void setPrevCtc1(String prevCtc1) {
        this.prevCtc1 = prevCtc1;
    }

    @Override
    public String toString() {
        return "EmployeeDetails{" +
                "laptopId=" + laptopId +
                ", empId='" + empId + '\'' +
                ", totalExperience='" + totalExperience + '\'' +
                ", currentCtc='" + currentCtc + '\'' +
                ", role='" + role + '\'' +
                ", designation='" + designation + '\'' +
                ", joinDate='" + joinDate + '\'' +
                ", isLaptop='" + isLaptop + '\'' +
                ", laptopIssueDate='" + laptopIssueDate + '\'' +
                ", laptopModel='" + laptopModel + '\'' +
                ", pf='" + pf + '\'' +
                ", domain='" + domain + '\'' +
                ", skills='" + skills + '\'' +
                ", onsite='" + onsite + '\'' +
                ", countries='" + countries + '\'' +
                ", cities='" + cities + '\'' +
                ", companyNames='" + companyNames + '\'' +
                ", clientSupport='" + clientSupport + '\'' +
                ", prevCompany='" + prevCompany + '\'' +
                ", prevEmpId='" + prevEmpId + '\'' +
                ", prevJoinDate='" + prevJoinDate + '\'' +
                ", prevEndDate='" + prevEndDate + '\'' +
                ", prevDomain='" + prevDomain + '\'' +
                ", prevCtc='" + prevCtc + '\'' +
                ", prevCompany1='" + prevCompany1 + '\'' +
                ", prevEmpId1='" + prevEmpId1 + '\'' +
                ", prevJoinDate1='" + prevJoinDate1 + '\'' +
                ", prevEndDate1='" + prevEndDate1 + '\'' +
                ", prevDomain1='" + prevDomain1 + '\'' +
                ", prevCtc1='" + prevCtc1 + '\'' +
                '}';
    }
}
