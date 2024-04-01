package com.oniesoft.model;

public class OtpVerificationRequest {
private String emailOtp;
    private String otp;

    private String mob;
    private String email;

    public OtpVerificationRequest() {
    }

    public String getEmailOtp() {
        return emailOtp;
    }

    public void setEmailOtp(String emailOtp) {
        this.emailOtp = emailOtp;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getMob() {
        return mob;
    }

    public void setMob(String mob) {
        this.mob = mob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "OtpVerificationRequest{" +
                "emailOtp='" + emailOtp + '\'' +
                ", otp='" + otp + '\'' +
                ", mob='" + mob + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
