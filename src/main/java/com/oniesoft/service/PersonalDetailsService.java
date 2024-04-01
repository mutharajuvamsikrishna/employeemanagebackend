package com.oniesoft.service;

import com.oniesoft.model.PersonalDetails;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface PersonalDetailsService {

    public void savePerEmpWithFiles(PersonalDetails personalDetails,
                                    MultipartFile aadharFile, MultipartFile panFile,
                                    MultipartFile passportFile, MultipartFile visaFile,
                                    MultipartFile otherFile) throws IOException;
}
