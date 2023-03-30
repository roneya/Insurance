package com.example.Test.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

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


}
