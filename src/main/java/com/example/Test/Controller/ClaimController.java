package com.example.Test.Controller;

import com.example.Test.Models.Claim;
import com.example.Test.Models.ClientUser;
import com.example.Test.Service.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/claims")
public class ClaimController {


    @Autowired
    ClaimService claimService;

    @PostMapping()
    public ResponseEntity<String> add(@RequestBody Claim claim){
        return claimService.add(claim);
    }
    @GetMapping("")
    public List<Claim> getall(){
        return claimService.getall();
    }

    @GetMapping("{id}")
    public ResponseEntity<Claim> get(@RequestParam Integer i) throws Exception {
        return claimService.get(i);
    }

    @PutMapping("{id}")
    public ResponseEntity<Claim> put(@RequestBody Claim claim) throws Exception {
        return claimService.put(claim);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@RequestParam Integer i){
        return claimService.delete(i);
    }

}
