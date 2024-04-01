package com.oniesoft.serviceimpl;

import com.oniesoft.model.PersonalDetails;
import com.oniesoft.repository.PersonalDetailsRepo;
import com.oniesoft.service.PersonalDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class PersonalDetailsServiceImpl implements PersonalDetailsService {
    @Autowired
    PersonalDetailsRepo personalDetailsRepo;
    @Autowired
    private FileServiceImpl fileService;
    @Override
    public void savePerEmpWithFiles(PersonalDetails personalDetails,
                                    MultipartFile aadharFile, MultipartFile panFile,
                                    MultipartFile passportFile, MultipartFile visaFile,
                                    MultipartFile otherFile) throws IOException {


        PersonalDetails  savedPerEmp = personalDetailsRepo.save(personalDetails);
        // Save files and update file paths in the PerEmp entity
        if(aadharFile!=null) {
            String aadharFilePath = fileService.saveFile(savedPerEmp.getRegno(), "aadhar", aadharFile);
            savedPerEmp.setAadharFile(aadharFilePath);
        }
        if(panFile!=null) {
            String panFilePath = fileService.saveFile(savedPerEmp.getRegno(), "pan", panFile);
            savedPerEmp.setPanFile(panFilePath);
        } if(passportFile!=null) {
            String passportFilePath = fileService.saveFile(savedPerEmp.getRegno(), "passport", passportFile);
            savedPerEmp.setPassportFile(passportFilePath);
        } if(visaFile!=null) {
            String visaFilePath = fileService.saveFile(savedPerEmp.getRegno(), "visa", visaFile);
            savedPerEmp.setVisaFile(visaFilePath);
        } if(otherFile!=null) {
            String otherFilePath = fileService.saveFile(savedPerEmp.getRegno(), "other", otherFile);
            savedPerEmp.setOtherFile(otherFilePath);
        }
        // Update the PerEmp entity with file paths and save again
        personalDetailsRepo.save(savedPerEmp);
    }
}
