package com.oniesoft.serviceimpl;

import com.oniesoft.model.RaiseDispute;
import com.oniesoft.repository.RaiseDisputeRepo;
import com.oniesoft.service.RaiseDisputeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RaiseDisputeServiceImpl implements RaiseDisputeService {
    @Autowired
    private RaiseDisputeRepo raiseDisputeRepo;
    @Override
    public void addDisputeDetails(RaiseDispute raiseDispute) {
        raiseDisputeRepo.save(raiseDispute);
    }

    @Override
    public List<RaiseDispute> getDisputeDetails(String email) {
        return raiseDisputeRepo.findByEmail(email);
    }
}
