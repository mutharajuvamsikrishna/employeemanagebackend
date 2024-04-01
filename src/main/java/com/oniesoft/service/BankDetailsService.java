package com.oniesoft.service;

import com.oniesoft.model.BankDetails;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface BankDetailsService {
    public void addBankDetails(BankDetails bankDetails,MultipartFile bankFile) throws IOException;

}
