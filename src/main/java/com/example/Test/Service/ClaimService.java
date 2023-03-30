package com.example.Test.Service;

import com.example.Test.Models.Claim;
import com.example.Test.Repository.ClaimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClaimService {

    @Autowired
    ClaimRepository claimRepository;
    public ResponseEntity<String> add(Claim claim){

        claimRepository.save(claim);
        return ResponseEntity.ok("Claim added successfully!");

    }
    public List<Claim> getall(){
        return claimRepository.findAll();
    }
    public ResponseEntity<Claim> get(Integer i) throws Exception {
        try {

            Claim claim = claimRepository.findById(i).get();

            return ResponseEntity.ok(claim);
        } catch (DataIntegrityViolationException ex) {
            throw new Exception("Claim is not Present");
        }
    }

    public ResponseEntity<Claim> put(Claim claim) throws Exception {
        try {

            Claim claim1 = claimRepository.findById(claim.getClaimNumber()).get();
            claimRepository.save(claim1);
            return ResponseEntity.ok(claim1);
        } catch (DataIntegrityViolationException ex) {
            throw new Exception("Claim is not Present");
        }
    }

    public ResponseEntity<String> delete( Integer i){
        try {

            Claim claim = claimRepository.findById(i).get();
            claimRepository.delete(claim);
            return ResponseEntity.ok("Claim deleted successfully!");
        } catch (DataIntegrityViolationException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Claim is not present");
        }
    }
}
