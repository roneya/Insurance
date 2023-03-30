package com.example.Test.Controller;

import com.example.Test.Models.ClientUser;
import com.example.Test.Models.InsurancePolicy;
import com.example.Test.Service.InsurancePolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/policies")
public class InsurancePolicyController {
    @Autowired
    InsurancePolicyService insurancePolicyService;

    @PostMapping()
    public ResponseEntity<String> add(@RequestBody InsurancePolicy insurancePolicy){
        return insurancePolicyService.add(insurancePolicy);
    }
    @GetMapping("")
    public List<InsurancePolicy> getall(){
        return insurancePolicyService.getall();
    }

    @GetMapping("{id}")
    public ResponseEntity<InsurancePolicy> get(@RequestParam Integer i) throws Exception {
        return insurancePolicyService.get(i);
    }

    @PutMapping("{id}")
    public ResponseEntity<InsurancePolicy> put(@RequestBody InsurancePolicy insurancePolicy) throws Exception {
        return insurancePolicyService.put(insurancePolicy);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@RequestParam Integer i){
        return insurancePolicyService.delete(i);
    }
}
