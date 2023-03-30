package com.example.Test.Repository;

import com.example.Test.Models.ClientUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientUserRepository extends JpaRepository<ClientUser,Integer> {
}
