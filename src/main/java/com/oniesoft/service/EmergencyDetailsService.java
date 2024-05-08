package com.oniesoft.service;

import com.oniesoft.model.EmergencyDetails;

import java.util.List;

public interface EmergencyDetailsService {
    public void addEmergencyDetails(EmergencyDetails emergencyDetails);
    public List<EmergencyDetails> getEmergencyDetails(String empId);
}
