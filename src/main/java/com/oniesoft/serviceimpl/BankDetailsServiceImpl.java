package com.oniesoft.serviceimpl;

import com.oniesoft.model.BankDetails;
import com.oniesoft.repository.BankDetailsRepo;
import com.oniesoft.service.BankDetailsService;
import com.oniesoft.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
@Service
public class BankDetailsServiceImpl implements BankDetailsService {
    @Autowired
    private BankDetailsRepo bankDetailsRepo;

@Autowired
private FileService fileService;
    @Override
    public void addBankDetails(BankDetails bankDetails, MultipartFile bankFile) throws IOException {


            BankDetails  bankDetails1 = bankDetailsRepo.save(bankDetails);
            // Save files and update file paths in the PerEmp entity
            if(bankFile!=null) {
                String bank = fileService.saveFile(bankDetails1.getRegno(), "bank", bankFile);
              bankDetails1.setBankFile(bank);
              bankDetailsRepo.save(bankDetails1);
            }
    }




}

