package com.example.Test.Service;

import com.example.Test.Models.ClientUser;
import com.example.Test.Models.InsurancePolicy;
import com.example.Test.Repository.ClaimRepository;
import com.example.Test.Repository.ClientUserRepository;
import com.example.Test.Repository.InsurancePolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class ClientUserService {
    @Autowired
    ClientUserRepository clientUserRepository;
    @Autowired
    InsurancePolicyRepository insurancePolicyRepository;
    @Autowired
    private ClaimRepository claimRepository;

    public ResponseEntity<String> add(ClientUser c){

        clientUserRepository.save(c);
            return ResponseEntity.ok("User registered successfully!");

    }
    public List<ClientUser> getall(){
        return clientUserRepository.findAll();
    }
    public ResponseEntity<ClientUser> get(Integer i) throws Exception {
        try {

            ClientUser clientUser = clientUserRepository.findById(i).get();

            return ResponseEntity.ok(clientUser);
        } catch (DataIntegrityViolationException ex) {
            throw new Exception("User is not Present");
        }
    }

    public ResponseEntity<ClientUser> put(ClientUser clientUser) throws Exception {
        try {

            ClientUser clientUser1 = clientUserRepository.findById(clientUser.getId()).get();
            clientUserRepository.save(clientUser1);
            return ResponseEntity.ok(clientUser1);
        } catch (DataIntegrityViolationException ex) {
            throw new Exception("User is not Present");
        }
    }

    public ResponseEntity<String> delete( Integer i){
        try {

            ClientUser clientUser = clientUserRepository.findById(i).get();
            clientUserRepository.delete(clientUser);
            return ResponseEntity.ok("User deleted successfully!");
        } catch (DataIntegrityViolationException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("User is not present");
        }
    }


    public ResponseEntity<String> link(int id, int pid) throws Exception {

        try {

            ClientUser clientUser = clientUserRepository.findById(id).get();
            InsurancePolicy insurancePolicy = insurancePolicyRepository.findById(pid).get();
            List<InsurancePolicy> insurancePolicyList = clientUser.getInsurancePolicyList();
            if(insurancePolicyList.contains(insurancePolicy)){
                throw new Exception(); //already linked
            }
            insurancePolicyList.add(insurancePolicy);
            clientUser.setInsurancePolicyList(insurancePolicyList);
            clientUserRepository.save(clientUser);

            return ResponseEntity.ok("Successfully linked");
        } catch (DataIntegrityViolationException ex) {
            throw new Exception("User/Policy is not Present or already Linked");
        }

    }

}
