package com.oniesoft.controller;

import com.oniesoft.dto.BankDetailsDto;
import com.oniesoft.model.BankDetails;
import com.oniesoft.repository.BankDetailsRepo;
import com.oniesoft.service.BankDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/bankdetails/v1")
public class BankDetailsController {
    @Autowired
    private BankDetailsService bankDetailsService;
    @Autowired
    private BankDetailsRepo bankDetailsRepo;

    @PostMapping("/bankdetails-save")
    public ResponseEntity<?> addBankDetails(@RequestParam String empId, @RequestParam String bankName,
                                            @RequestParam String branch, @RequestParam String ifcCode,
                                            @RequestParam String accountNumber, @RequestParam(required = false) MultipartFile bankFile,
                                            @RequestParam String name) throws IOException {
        BankDetails bankDetails = new BankDetails();
        bankDetails.setEmpId(empId);
        bankDetails.setBankName(bankName);
        bankDetails.setBranch(branch);
        bankDetails.setIfcCode(ifcCode);
        bankDetails.setAccountNumber(accountNumber);
        bankDetails.setName(name);
        bankDetailsService.addBankDetails(bankDetails, bankFile);
        return ResponseEntity.ok("ok");

    }
    @PutMapping("/bankdetails-update")
    public ResponseEntity<?> updateBankDetails(@RequestParam Long regno,@RequestParam String empId, @RequestParam String bankName,
                                            @RequestParam String branch, @RequestParam String ifcCode,
                                            @RequestParam String accountNumber, @RequestParam(required = false) MultipartFile bankFile,
                                            @RequestParam String name) throws IOException {

        BankDetails bankDetails =bankDetailsRepo.findByEmpId(empId);
        bankDetails.setBankName(bankName);
        bankDetails.setBranch(branch);
        bankDetails.setIfcCode(ifcCode);
        bankDetails.setAccountNumber(accountNumber);
        bankDetails.setName(name);
        bankDetailsService.addBankDetails(bankDetails, bankFile);
        return ResponseEntity.ok("ok");

    }
    @GetMapping(value = "/getbankdetails", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BankDetailsDto> getBankDetails(@RequestParam String empId) {
        System.out.println("OKKK");
        BankDetails bankDetails = bankDetailsRepo.findByEmpId(empId);
        if (bankDetails != null) {
            List<String> filePaths = getFilePathsForBank(bankDetails);
            List<byte[]> fileContents = getFileContents(filePaths);
            BankDetailsDto bankDetailsDto = new BankDetailsDto();
            bankDetailsDto.setRegno(bankDetails.getRegno());
            bankDetailsDto.setEmpId(bankDetails.getEmpId());
            bankDetailsDto.setBankName(bankDetails.getBankName());
            bankDetailsDto.setBranch(bankDetails.getBranch());
            bankDetailsDto.setIfcCode(bankDetails.getIfcCode());
            bankDetailsDto.setAccountNumber(bankDetails.getAccountNumber());
            bankDetailsDto.setName(bankDetails.getName());
            bankDetailsDto.setBankFile(bankDetails.getBankFile());
            bankDetailsDto.setFileContents(fileContents);
            return ResponseEntity.ok(bankDetailsDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    private List<String> getFilePathsForBank(BankDetails bankDetails) {
        List<String> filePaths = new ArrayList<>();
        filePaths.add(bankDetails.getBankFile());
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


}
