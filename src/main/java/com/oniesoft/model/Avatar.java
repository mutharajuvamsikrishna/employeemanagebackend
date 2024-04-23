package com.oniesoft.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Avatar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long regno;
    private String email;
    private String profile;
    public Avatar(){

    }

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

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    @Override
    public String toString() {
        return "Avatar{" +
                "regno=" + regno +
                ", email='" + email + '\'' +
                ", profile='" + profile + '\'' +
                '}';
    }
}
