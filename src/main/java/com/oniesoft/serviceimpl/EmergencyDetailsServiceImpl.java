package com.oniesoft.serviceimpl;

import com.oniesoft.model.EmergencyDetails;
import com.oniesoft.repository.EmergencyDetailsRepo;
import com.oniesoft.service.EmergencyDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmergencyDetailsServiceImpl implements EmergencyDetailsService {
    @Autowired
    EmergencyDetailsRepo emergencyDetailsRepo;
    @Override
    public void addEmergencyDetails(EmergencyDetails emergencyDetails) {
        emergencyDetailsRepo.save(emergencyDetails);
    }

    @Override
    public List<EmergencyDetails> getEmergencyDetails(String email) {
        return emergencyDetailsRepo.findByEmail(email);
    }
}
