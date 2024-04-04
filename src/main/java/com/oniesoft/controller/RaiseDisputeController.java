package com.oniesoft.controller;

import com.oniesoft.model.RaiseDispute;
import com.oniesoft.service.RaiseDisputeService;
import com.oniesoft.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/raisedisputedetails/v1")
public class RaiseDisputeController {
    @Autowired
    private RaiseDisputeService raiseDisputeService;
    @Autowired
    RegisterService registerService;
    @Value("${adminemail}")
    private String email;
    @PostMapping("/raisedisputedetails-save")
    public ResponseEntity<?> saveRaiseDisputeDetails(@RequestBody RaiseDispute raiseDispute){
        raiseDisputeService.addDisputeDetails(raiseDispute);
        String userSubject="";
        String userBody="";
        String adminSubject="";
        String adminBody="";
        System.out.println(raiseDispute.getEmail());
        registerService.sendEmail(raiseDispute.getEmail(),userSubject,userBody);
registerService.sendEmail(email,adminSubject,adminBody);
        return ResponseEntity.ok("Details Saved Succesfully");

    }
    @GetMapping("/getraisedisputedetails")
    public List<RaiseDispute> getRaiseDisputeDetails(@RequestParam String email){
        return raiseDisputeService.getDisputeDetails(email);
    }
}
