package com.oniesoft.controller;

import com.oniesoft.dto.PersonalDetailsDto;
import com.oniesoft.model.PersonalDetails;
import com.oniesoft.repository.PersonalDetailsRepo;
import com.oniesoft.service.PersonalDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/personaldetails/v1")
public class PersonalDetailsController {
    @Autowired
    PersonalDetailsService personalDetailsService;
    @Autowired
    PersonalDetailsRepo personalDetailsRepo;

    @PostMapping("/personaldetailssave")
    public ResponseEntity<String> savePerEmpWithFiles(
            @RequestParam(value = "email", required = false) String email,
            @RequestParam(value = "aadhar", required = false) String aadhar,
            @RequestParam(value = "pan", required = false) String pan,
            @RequestParam(value = "val1", required = false) String val1,
            @RequestParam(value = "status1", required = false) String status1,
            @RequestParam(value = "passportnumber", required = false) String passportnumber,
            @RequestParam(value = "exp1", required = false) String exp1,
            @RequestParam(value = "val2", required = false) String val2,
            @RequestParam(value = "status2", required = false) String status2,
            @RequestParam(value = "visanumber", required = false) String visanumber,
            @RequestParam(value = "exp2", required = false) String exp2,
            @RequestParam(value = "gender", required = false) String gender,
            @RequestParam(value = "date", required = false) String date,
            @RequestParam(value = "address", required = false) String address,
            @RequestParam(value = "city", required = false) String city,
            @RequestParam(value = "state", required = false) String state,
            @RequestParam(value = "pinnumber", required = false) String pinnumber,
            @RequestParam(value = "aadharFile", required = false) MultipartFile aadharFile,
            @RequestParam(value = "panFile", required = false) MultipartFile panFile,
            @RequestParam(value = "passportFile", required = false) MultipartFile passportFile,
            @RequestParam(value = "visaFile", required = false) MultipartFile visaFile,
            @RequestParam(value = "otherFile", required = false) MultipartFile otherFile) {

        try {
            PersonalDetails personalDetails = new PersonalDetails();
            // Set other fields in the PerEmp entity...
            personalDetails.setEmail(email);
            personalDetails.setAdhar(aadhar);
            personalDetails.setPan(pan);
            personalDetails.setVal1(val1);
            personalDetails.setStatus1(status1);
            personalDetails.setPassportnumber(passportnumber);
            personalDetails.setExp1(exp1);
            personalDetails.setVal2(val2);
            personalDetails.setStatus2(status2);
            personalDetails.setVisanumber(visanumber);
            personalDetails.setExp2(exp2);
            personalDetails.setGender(gender);
            personalDetails.setDate(date);
            personalDetails.setAdress(address);
            personalDetails.setCity(city);
            personalDetails.setState(state);
            personalDetails.setPinnumber(pinnumber);

            personalDetailsService.savePerEmpWithFiles(personalDetails, aadharFile, panFile, passportFile, visaFile, otherFile);
            return ResponseEntity.status(HttpStatus.CREATED).body("PerEmp saved successfully!");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving PerEmp with files.");
        }
    }

    @GetMapping(value = "/useruniquereq", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonalDetailsDto> getUniqueUser(@RequestParam String email) {
        PersonalDetails emp = personalDetailsRepo.findByEmail(email);

        if (emp != null) {
            List<String> filePaths = getFilePathsForPerEmp(emp);
            List<byte[]> fileContents = getFileContents(filePaths);

            PersonalDetailsDto responseDTO = new PersonalDetailsDto();
            responseDTO.setRegno(emp.getRegno());
            responseDTO.setEmail(emp.getEmail());
            responseDTO.setAdhar(emp.getAdhar());
            responseDTO.setPan(emp.getPan());
            responseDTO.setVal1(emp.getVal1());
            responseDTO.setStatus1(emp.getStatus1());
            responseDTO.setPassportnumber(emp.getPassportnumber());
            responseDTO.setExp1(emp.getExp1());
            responseDTO.setVal2(emp.getVal2());
            responseDTO.setStatus2(emp.getStatus2());
            responseDTO.setVisanumber(emp.getVisanumber());
            responseDTO.setExp2(emp.getExp2());
            responseDTO.setGender(emp.getGender());
            responseDTO.setDate(emp.getDate());
            responseDTO.setAddress(emp.getAdress());
            responseDTO.setCity(emp.getCity());
            responseDTO.setState(emp.getState());
            responseDTO.setPinnumber(emp.getPinnumber());
            responseDTO.setFilePaths(filePaths);
            responseDTO.setFileContents(fileContents);

            return ResponseEntity.ok(responseDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    private List<String> getFilePathsForPerEmp(PersonalDetails perEmp) {
        List<String> filePaths = new ArrayList<>();
        filePaths.add(perEmp.getAadharFile());
        filePaths.add(perEmp.getPanFile());
        filePaths.add(perEmp.getPassportFile());
        filePaths.add(perEmp.getVisaFile());
        filePaths.add(perEmp.getOtherFile());

        return filePaths;
    }

    private List<byte[]> getFileContents(List<String> filePaths) {
        List<byte[]> fileContents = new ArrayList<>();
        for (String filePath : filePaths) {
            if (filePath != null) {
                try {
                    byte[] content = Files.readAllBytes(Paths.get(filePath));
                    fileContents.add(content);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return fileContents;
    }

    @PutMapping("/personalupdateDetails")
    public ResponseEntity<String> upDatePerEmpWithFiles(
            @RequestParam(value = "email", required = false) String email,
            @RequestParam(value = "aadhar", required = false) String aadhar,
            @RequestParam(value = "pan", required = false) String pan,
            @RequestParam(value = "val1", required = false) String val1,
            @RequestParam(value = "status1", required = false) String status1,
            @RequestParam(value = "passportnumber", required = false) String passportnumber,
            @RequestParam(value = "exp1", required = false) String exp1,
            @RequestParam(value = "val2", required = false) String val2,
            @RequestParam(value = "status2", required = false) String status2,
            @RequestParam(value = "visanumber", required = false) String visanumber,
            @RequestParam(value = "exp2", required = false) String exp2,
            @RequestParam(value = "gender", required = false) String gender,
            @RequestParam(value = "date", required = false) String date,
            @RequestParam(value = "address", required = false) String address,
            @RequestParam(value = "city", required = false) String city,
            @RequestParam(value = "state", required = false) String state,
            @RequestParam(value = "pinnumber", required = false) String pinnumber,
            @RequestParam(value = "aadharFile", required = false) MultipartFile aadharFile,
            @RequestParam(value = "panFile", required = false) MultipartFile panFile,
            @RequestParam(value = "passportFile", required = false) MultipartFile passportFile,
            @RequestParam(value = "visaFile", required = false) MultipartFile visaFile,
            @RequestParam(value = "otherFile", required = false) MultipartFile otherFile) {

        try {
            PersonalDetails perEmp = personalDetailsRepo.findByEmail(email);
            perEmp.setRegno(perEmp.getRegno());
            perEmp.setEmail(email);
            perEmp.setAdhar(aadhar);
            perEmp.setPan(pan);
            perEmp.setVal1(val1);
            perEmp.setStatus1(status1);
            perEmp.setPassportnumber(passportnumber);
            perEmp.setExp1(exp1);
            perEmp.setVal2(val2);
            perEmp.setStatus2(status2);
            perEmp.setVisanumber(visanumber);
            perEmp.setExp2(exp2);
            perEmp.setGender(gender);
            perEmp.setDate(date);
            perEmp.setAdress(address);
            perEmp.setCity(city);
            perEmp.setState(state);
            perEmp.setPinnumber(pinnumber);

            personalDetailsService.savePerEmpWithFiles(perEmp, aadharFile, panFile, passportFile, visaFile, otherFile);
            return ResponseEntity.status(HttpStatus.CREATED).body("PerEmp saved successfully!");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving PerEmp with files.");
        }
    }


}
