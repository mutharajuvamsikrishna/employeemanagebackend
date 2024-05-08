package com.oniesoft.serviceimpl;

import com.oniesoft.model.RaiseDispute;
import com.oniesoft.repository.RaiseDisputeRepo;
import com.oniesoft.service.RaiseDisputeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RaiseDisputeServiceImpl implements RaiseDisputeService {
    @Autowired
    private RaiseDisputeRepo raiseDisputeRepo;
    @Override
    public void addDisputeDetails(RaiseDispute raiseDispute) {
        raiseDisputeRepo.save(raiseDispute);
    }

    @Override
    public List<RaiseDispute> getDisputeDetails(String empId) {
        return raiseDisputeRepo.findByEmpId(empId);
    }

    @Override
    public List<RaiseDispute> searchRaiseDispute(String query) {
            List<RaiseDispute> raiseDisputeList=raiseDisputeRepo.searchRaiseDispute(query);
            return raiseDisputeList;
        }

    @Override
    public List<RaiseDispute> getAllTickets() {
        return raiseDisputeRepo.findAll();
    }

    @Override
    public void putRaisTicketDetails(RaiseDispute raiseDispute) {
        System.out.println(raiseDispute.getRegno());
        Optional<RaiseDispute> raiseDispute1 =raiseDisputeRepo.findById(raiseDispute.getRegno());
         RaiseDispute raiseDispute2=raiseDispute1.get();
         raiseDisputeRepo.save(raiseDispute);

    }
}
