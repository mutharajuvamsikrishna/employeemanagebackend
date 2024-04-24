package com.oniesoft.controller;

import com.oniesoft.model.RaiseDispute;
import com.oniesoft.service.RaiseDisputeService;
import com.oniesoft.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
        String userSubject="";
        String userBody="";
        String adminSubject="";
        String adminBody="";
        System.out.println(raiseDispute.getEmail());
        registerService.sendEmail(raiseDispute.getEmail(),userSubject,userBody);
        if(raiseDispute.getSelectedMainType().equals("HR")){
            raiseDispute.setSelectedMainType("ROLE_HR");
            raiseDisputeService.addDisputeDetails(raiseDispute);
            registerService.sendEmail(email,adminSubject,adminBody);
        }
       else if(raiseDispute.getSelectedMainType().equals("Finance")){
            raiseDispute.setSelectedMainType("ROLE_FINANCE");
            raiseDisputeService.addDisputeDetails(raiseDispute);
            registerService.sendEmail(email,adminSubject,adminBody);
        }
        else if(raiseDispute.getSelectedMainType().equals("Admin")){
            raiseDispute.setSelectedMainType("ROLE_ADMIN");
            raiseDisputeService.addDisputeDetails(raiseDispute);
            registerService.sendEmail(email,adminSubject,adminBody);
        }
        else if(raiseDispute.getSelectedMainType().equals("IT")){
            raiseDispute.setSelectedMainType("ROLE_IT");
            raiseDisputeService.addDisputeDetails(raiseDispute);
            registerService.sendEmail(email,adminSubject,adminBody);
        }
        else if(raiseDispute.getSelectedMainType().equals("Project")){
            raiseDispute.setSelectedMainType("ROLE_PROJECT");
            raiseDisputeService.addDisputeDetails(raiseDispute);
            registerService.sendEmail(email,adminSubject,adminBody);
        }
        return ResponseEntity.ok("Details Saved Succesfully");

    }
    @GetMapping("/getraisedisputedetails")
    public List<RaiseDispute> getRaiseDisputeDetails(@RequestParam String email){
        return raiseDisputeService.getDisputeDetails(email);
    }
   @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_SUPERADMIN')")
    @GetMapping("/searchtickets")
    public List<RaiseDispute> searchTickets(@RequestParam String query){
        return raiseDisputeService.searchRaiseDispute(query);
    }
   @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_SUPERADMIN')")
    @GetMapping("/getalltickets")
    public List<RaiseDispute> getTickets(){
        return raiseDisputeService.getAllTickets();
    }
   @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_SUPERADMIN')")
    @PutMapping("/ticket-update")
    public ResponseEntity<?> upDtateTickets(@RequestBody RaiseDispute raiseDispute){
        raiseDisputeService.putRaisTicketDetails(raiseDispute);
        String userSubject="";
        String userBody="";
        String adminSubject="";
        String adminBody="";
        System.out.println(raiseDispute.getEmail());
        registerService.sendEmail(raiseDispute.getEmail(),userSubject,userBody);
        if(raiseDispute.getSelectedMainType().equals("ROLE_HR")){
            registerService.sendEmail(email,adminSubject,adminBody);
        }
        else if(raiseDispute.getSelectedMainType().equals("ROLE_FINANCE")){
            registerService.sendEmail(email,adminSubject,adminBody);
        }
        else if(raiseDispute.getSelectedMainType().equals("ROLE_ADMIN")){
            registerService.sendEmail(email,adminSubject,adminBody);
        }
        else if(raiseDispute.getSelectedMainType().equals("ROLE_IT")){
            registerService.sendEmail(email,adminSubject,adminBody);
        }
        else if(raiseDispute.getSelectedMainType().equals("ROLE_PROJECT")){
            registerService.sendEmail(email,adminSubject,adminBody);
        }
    return ResponseEntity.ok("Updated SuccessFully");
    }
}
