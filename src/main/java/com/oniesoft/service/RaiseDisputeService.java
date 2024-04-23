package com.oniesoft.service;

import com.oniesoft.model.RaiseDispute;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface RaiseDisputeService {
    public void addDisputeDetails(RaiseDispute raiseDispute);
    public List<RaiseDispute> getDisputeDetails(@RequestParam String email);
   public List<RaiseDispute> searchRaiseDispute(@Param("query") String query);
    public List<RaiseDispute> getAllTickets();
    public  void  putRaisTicketDetails(RaiseDispute raiseDispute);

}
