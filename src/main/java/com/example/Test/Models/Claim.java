package com.example.Test.Models;

import com.example.Test.Enum.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "claims")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Claim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int claimNumber;
    private String description;
    private Date claimDate;
    @Enumerated(value = EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn
    private InsurancePolicy insurancePolicy;
}
