package com.oniesoft.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class AdminCheckList {
    @Id
    private String email;
    private boolean candidateConfirmation;
    private boolean hrAssignment;
    private boolean submitRelievingLetter;
    private boolean submitExperienceLetter;
    private boolean submitPayslips;
    private boolean fillJoiningForm;
    private boolean submitPhotos;
    private boolean submitCertificates;
    private boolean signContract;
    private boolean signITIPR;
    private boolean signJoiningLetter;
    private boolean welcomeKit;
    private boolean employeeNumber;
    private boolean  laptop;
    private boolean workstation;
    private boolean internetAccess;
    private boolean intranetAccess;
    private boolean emailAccess;
    private boolean teamsAccess;
    private boolean attendance;
    private boolean timeSheet;
    private boolean finance;
    private boolean employeeIDCard;
    private boolean employeeAccessCard;
    private boolean  parkingSlot;
    public AdminCheckList(){

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isCandidateConfirmation() {
        return candidateConfirmation;
    }

    public void setCandidateConfirmation(boolean candidateConfirmation) {
        this.candidateConfirmation = candidateConfirmation;
    }

    public boolean isHrAssignment() {
        return hrAssignment;
    }

    public void setHrAssignment(boolean hrAssignment) {
        this.hrAssignment = hrAssignment;
    }

    public boolean isSubmitRelievingLetter() {
        return submitRelievingLetter;
    }

    public void setSubmitRelievingLetter(boolean submitRelievingLetter) {
        this.submitRelievingLetter = submitRelievingLetter;
    }

    public boolean isSubmitExperienceLetter() {
        return submitExperienceLetter;
    }

    public void setSubmitExperienceLetter(boolean submitExperienceLetter) {
        this.submitExperienceLetter = submitExperienceLetter;
    }

    public boolean isSubmitPayslips() {
        return submitPayslips;
    }

    public void setSubmitPayslips(boolean submitPayslips) {
        this.submitPayslips = submitPayslips;
    }

    public boolean isFillJoiningForm() {
        return fillJoiningForm;
    }

    public void setFillJoiningForm(boolean fillJoiningForm) {
        this.fillJoiningForm = fillJoiningForm;
    }

    public boolean isSubmitPhotos() {
        return submitPhotos;
    }

    public void setSubmitPhotos(boolean submitPhotos) {
        this.submitPhotos = submitPhotos;
    }

    public boolean isSubmitCertificates() {
        return submitCertificates;
    }

    public void setSubmitCertificates(boolean submitCertificates) {
        this.submitCertificates = submitCertificates;
    }

    public boolean isSignContract() {
        return signContract;
    }

    public void setSignContract(boolean signContract) {
        this.signContract = signContract;
    }

    public boolean isSignITIPR() {
        return signITIPR;
    }

    public void setSignITIPR(boolean signITIPR) {
        this.signITIPR = signITIPR;
    }

    public boolean isSignJoiningLetter() {
        return signJoiningLetter;
    }

    public void setSignJoiningLetter(boolean signJoiningLetter) {
        this.signJoiningLetter = signJoiningLetter;
    }

    public boolean isWelcomeKit() {
        return welcomeKit;
    }

    public void setWelcomeKit(boolean welcomeKit) {
        this.welcomeKit = welcomeKit;
    }

    public boolean isEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(boolean employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public boolean isLaptop() {
        return laptop;
    }

    public void setLaptop(boolean laptop) {
        this.laptop = laptop;
    }

    public boolean isWorkstation() {
        return workstation;
    }

    public void setWorkstation(boolean workstation) {
        this.workstation = workstation;
    }

    public boolean isInternetAccess() {
        return internetAccess;
    }

    public void setInternetAccess(boolean internetAccess) {
        this.internetAccess = internetAccess;
    }

    public boolean isIntranetAccess() {
        return intranetAccess;
    }

    public void setIntranetAccess(boolean intranetAccess) {
        this.intranetAccess = intranetAccess;
    }

    public boolean isEmailAccess() {
        return emailAccess;
    }

    public void setEmailAccess(boolean emailAccess) {
        this.emailAccess = emailAccess;
    }

    public boolean isTeamsAccess() {
        return teamsAccess;
    }

    public void setTeamsAccess(boolean teamsAccess) {
        this.teamsAccess = teamsAccess;
    }

    public boolean isAttendance() {
        return attendance;
    }

    public void setAttendance(boolean attendance) {
        this.attendance = attendance;
    }

    public boolean isTimeSheet() {
        return timeSheet;
    }

    public void setTimeSheet(boolean timeSheet) {
        this.timeSheet = timeSheet;
    }

    public boolean isFinance() {
        return finance;
    }

    public void setFinance(boolean finance) {
        this.finance = finance;
    }

    public boolean isEmployeeIDCard() {
        return employeeIDCard;
    }

    public void setEmployeeIDCard(boolean employeeIDCard) {
        this.employeeIDCard = employeeIDCard;
    }

    public boolean isEmployeeAccessCard() {
        return employeeAccessCard;
    }

    public void setEmployeeAccessCard(boolean employeeAccessCard) {
        this.employeeAccessCard = employeeAccessCard;
    }

    public boolean isParkingSlot() {
        return parkingSlot;
    }

    public void setParkingSlot(boolean parkingSlot) {
        this.parkingSlot = parkingSlot;
    }

    @Override
    public String toString() {
        return "AdminCheckList{" +
                "email='" + email + '\'' +
                ", candidateConfirmation=" + candidateConfirmation +
                ", hrAssignment=" + hrAssignment +
                ", submitRelievingLetter=" + submitRelievingLetter +
                ", submitExperienceLetter=" + submitExperienceLetter +
                ", submitPayslips=" + submitPayslips +
                ", fillJoiningForm=" + fillJoiningForm +
                ", submitPhotos=" + submitPhotos +
                ", submitCertificates=" + submitCertificates +
                ", signContract=" + signContract +
                ", signITIPR=" + signITIPR +
                ", signJoiningLetter=" + signJoiningLetter +
                ", welcomeKit=" + welcomeKit +
                ", employeeNumber=" + employeeNumber +
                ", laptop=" + laptop +
                ", workstation=" + workstation +
                ", internetAccess=" + internetAccess +
                ", intranetAccess=" + intranetAccess +
                ", emailAccess=" + emailAccess +
                ", teamsAccess=" + teamsAccess +
                ", attendance=" + attendance +
                ", timeSheet=" + timeSheet +
                ", finance=" + finance +
                ", employeeIDCard=" + employeeIDCard +
                ", employeeAccessCard=" + employeeAccessCard +
                ", parkingSlot=" + parkingSlot +
                '}';
    }
}
