package com.example.Test.Service;

import com.example.Test.Models.Claim;
import com.example.Test.Models.ClientUser;
import com.example.Test.Models.InsurancePolicy;
import com.example.Test.Repository.ClaimRepository;
import com.example.Test.Repository.InsurancePolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsurancePolicyService {

    @Autowired
    InsurancePolicyRepository insurancePolicyRepository;
    @Autowired
    ClaimRepository claimRepository;

    public ResponseEntity<String> add(InsurancePolicy insurancePolicy){

        insurancePolicyRepository.save(insurancePolicy);
        return ResponseEntity.ok("User registered successfully!");

    }
    public List<InsurancePolicy> getall(){
        return insurancePolicyRepository.findAll();
    }
    public ResponseEntity<InsurancePolicy> get(Integer i) throws Exception {
        try {

            InsurancePolicy insurancePolicy = insurancePolicyRepository.findById(i).get();

            return ResponseEntity.ok(insurancePolicy);
        } catch (DataIntegrityViolationException ex) {
            throw new Exception("Policy is not Present");
        }
    }

    public ResponseEntity<InsurancePolicy> put(InsurancePolicy insurancePolicy) throws Exception {
        try {

            InsurancePolicy insurancePolicy1 = insurancePolicyRepository.findById(insurancePolicy.getId()).get();
            insurancePolicyRepository.save(insurancePolicy1);
            return ResponseEntity.ok(insurancePolicy);
        } catch (DataIntegrityViolationException ex) {
            throw new Exception("Policy is not Present");
        }
    }

    public ResponseEntity<String> delete( Integer i){
        try {

            InsurancePolicy insurancePolicy = insurancePolicyRepository.findById(i).get();
            insurancePolicyRepository.delete(insurancePolicy);
            return ResponseEntity.ok("Policy deleted successfully!");
        } catch (DataIntegrityViolationException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Policy is not present");
        }
    }




        public ResponseEntity<String> link(int id, int cid) throws Exception {

            try {

                InsurancePolicy insurancePolicy = insurancePolicyRepository.findById(id).get();
                Claim claim = claimRepository.findById(cid).get();
                List<Claim> claimList = insurancePolicy.getClaimList();
                if(claimList.contains(claim)){
                    throw new Exception(); //means that claim has already been claimed
                }
                claimList.add(claim);
                insurancePolicy.setClaimList(claimList);
                insurancePolicyRepository.save(insurancePolicy);

                return ResponseEntity.ok("Successfully linked");
            } catch (DataIntegrityViolationException ex) {
                throw new Exception("Policy/Claim is not not present or already Linked");
            }

        }

}
