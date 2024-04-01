package com.oniesoft.service;

import com.oniesoft.model.FamilyDetails;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface FamilyDetailsService {
    public void addFamilyDetails(FamilyDetails familyDetails);
    public List<FamilyDetails> getFamilyDetails(@RequestParam String email);
}
