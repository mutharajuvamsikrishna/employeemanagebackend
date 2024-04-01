package com.oniesoft.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class FamilyDetails {
    @Id
    private String email;
    private String fatherName;
    private String fatherAadhar;
    private  String fatherPanCard;
    private String motherName;
    private String motherAadhar;
    private String motherPan;
    private String married;
    private String marriedName;
    private String marriedAadhar;
    private String marriedPan;
    private String children;
    private String childname;
    private String childAadhar;
    private String childPan;
    private String children1;
    private String childname1;
    private String childAadhar1;
    private String childPan1;
    private String children2;
    private String childname2;
    private String childAadhar2;
    private String childPan2;
    public FamilyDetails(){

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getFatherAadhar() {
        return fatherAadhar;
    }

    public void setFatherAadhar(String fatherAadhar) {
        this.fatherAadhar = fatherAadhar;
    }

    public String getFatherPanCard() {
        return fatherPanCard;
    }

    public void setFatherPanCard(String fatherPanCard) {
        this.fatherPanCard = fatherPanCard;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getMotherAadhar() {
        return motherAadhar;
    }

    public void setMotherAadhar(String motherAadhar) {
        this.motherAadhar = motherAadhar;
    }

    public String getMotherPan() {
        return motherPan;
    }

    public void setMotherPan(String motherPan) {
        this.motherPan = motherPan;
    }

    public String getMarried() {
        return married;
    }

    public void setMarried(String married) {
        this.married = married;
    }

    public String getMarriedName() {
        return marriedName;
    }

    public void setMarriedName(String marriedName) {
        this.marriedName = marriedName;
    }

    public String getMarriedAadhar() {
        return marriedAadhar;
    }

    public void setMarriedAadhar(String marriedAadhar) {
        this.marriedAadhar = marriedAadhar;
    }

    public String getMarriedPan() {
        return marriedPan;
    }

    public void setMarriedPan(String marriedPan) {
        this.marriedPan = marriedPan;
    }

    public String getChildren() {
        return children;
    }

    public void setChildren(String children) {
        this.children = children;
    }

    public String getChildname() {
        return childname;
    }

    public void setChildname(String childname) {
        this.childname = childname;
    }

    public String getChildAadhar() {
        return childAadhar;
    }

    public void setChildAadhar(String childAadhar) {
        this.childAadhar = childAadhar;
    }

    public String getChildPan() {
        return childPan;
    }

    public void setChildPan(String childPan) {
        this.childPan = childPan;
    }

    public String getChildren1() {
        return children1;
    }

    public void setChildren1(String children1) {
        this.children1 = children1;
    }

    public String getChildname1() {
        return childname1;
    }

    public void setChildname1(String childname1) {
        this.childname1 = childname1;
    }

    public String getChildAadhar1() {
        return childAadhar1;
    }

    public void setChildAadhar1(String childAadhar1) {
        this.childAadhar1 = childAadhar1;
    }

    public String getChildPan1() {
        return childPan1;
    }

    public void setChildPan1(String childPan1) {
        this.childPan1 = childPan1;
    }

    public String getChildren2() {
        return children2;
    }

    public void setChildren2(String children2) {
        this.children2 = children2;
    }

    public String getChildname2() {
        return childname2;
    }

    public void setChildname2(String childname2) {
        this.childname2 = childname2;
    }

    public String getChildAadhar2() {
        return childAadhar2;
    }

    public void setChildAadhar2(String childAadhar2) {
        this.childAadhar2 = childAadhar2;
    }

    public String getChildPan2() {
        return childPan2;
    }

    public void setChildPan2(String childPan2) {
        this.childPan2 = childPan2;
    }

    @Override
    public String toString() {
        return "FamilyDetails{" +
                "email='" + email + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", fatherAadhar='" + fatherAadhar + '\'' +
                ", fatherPanCard='" + fatherPanCard + '\'' +
                ", motherName='" + motherName + '\'' +
                ", motherAadhar='" + motherAadhar + '\'' +
                ", motherPan='" + motherPan + '\'' +
                ", married='" + married + '\'' +
                ", marriedName='" + marriedName + '\'' +
                ", marriedAadhar='" + marriedAadhar + '\'' +
                ", marriedPan='" + marriedPan + '\'' +
                ", children='" + children + '\'' +
                ", childname='" + childname + '\'' +
                ", childAadhar='" + childAadhar + '\'' +
                ", childPan='" + childPan + '\'' +
                ", children1='" + children1 + '\'' +
                ", childname1='" + childname1 + '\'' +
                ", childAadhar1='" + childAadhar1 + '\'' +
                ", childPan1='" + childPan1 + '\'' +
                ", children2='" + children2 + '\'' +
                ", childname2='" + childname2 + '\'' +
                ", childAadhar2='" + childAadhar2 + '\'' +
                ", childPan2='" + childPan2 + '\'' +
                '}';
    }
}
