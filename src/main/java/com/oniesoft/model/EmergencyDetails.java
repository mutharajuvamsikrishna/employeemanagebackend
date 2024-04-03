package com.oniesoft.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class EmergencyDetails {
    @Id
    private String email;
    private String name;
    private String relation;
    private String mobileNumber;
    private String state;
    private String city;
    public EmergencyDetails(){

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "EmergencyDetails{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", relation='" + relation + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
