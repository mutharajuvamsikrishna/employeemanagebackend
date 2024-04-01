package com.oniesoft.serviceimpl;

import com.oniesoft.model.FamilyDetails;
import com.oniesoft.repository.FamilyDetailsRepo;
import com.oniesoft.service.FamilyDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FamilyDetailsServiceImpl implements FamilyDetailsService {
    @Autowired
   private FamilyDetailsRepo familyDetailsRepo;
    @Override
    public void addFamilyDetails(FamilyDetails familyDetails) {
        FamilyDetails familyDetails1= familyDetailsRepo.save(familyDetails);
    }

    @Override
    public List<FamilyDetails> getFamilyDetails(String email){

        return familyDetailsRepo.findByEmail(email);
    }
}
