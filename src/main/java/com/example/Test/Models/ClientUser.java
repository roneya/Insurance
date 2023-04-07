package com.example.Test.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "clients")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ClientUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    private String name;
    private Date dataOfBirth;
    private String address;
    private String mobNo;
    @OneToMany(mappedBy = "clientUser", cascade = CascadeType.ALL)
    private List<InsurancePolicy> insurancePolicyList =  new ArrayList<>();


}
