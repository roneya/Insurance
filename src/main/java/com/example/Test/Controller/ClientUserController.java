package com.example.Test.Controller;

import com.example.Test.Models.ClientUser;
import com.example.Test.Service.ClientUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/clients")
public class ClientUserController {
    @Autowired
    ClientUserService clientUserService;

    @PostMapping()
    public ResponseEntity<String> add(@RequestBody ClientUser clientUser){
        return clientUserService.add(clientUser);
    }
    @GetMapping("")
    public List<ClientUser> getall(){
        return clientUserService.getall();
    }

    @GetMapping("{id}")
    public ResponseEntity<ClientUser> get(@PathVariable Integer i) throws Exception {
        return clientUserService.get(i);
    }

    @PutMapping("{id}")
    public ResponseEntity<ClientUser> put(@PathVariable int id("id") ,@RequestBody ClientUser clientUser) throws Exception {
        return clientUserService.put(clientUser);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@RequestParam Integer i){
        return clientUserService.delete(i);
    }

    @PutMapping("link/{id}/{pid}")
    public ResponseEntity<String> link(@PathVariable("id") int clientId, @PathVariable("pid") int policyId) throws Exception {
        return clientUserService.link(clientId, policyId);
    }

}
