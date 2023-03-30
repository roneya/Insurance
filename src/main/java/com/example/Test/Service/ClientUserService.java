package com.example.Test.Service;

import com.example.Test.Models.ClientUser;
import com.example.Test.Repository.ClientUserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientUserService {
    @Autowired
    ClientUserRepository clientUserRepository;
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

}
