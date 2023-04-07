package com.example.Test.Models;

import com.example.Test.Enum.Type;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "policies")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class InsurancePolicy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private Type type;

    private int amount;
    private Date startDate;
    private Date endDate;

    @ManyToOne
    @JoinColumn
    private ClientUser clientUser;

    @OneToMany( mappedBy = "insurancePolicy",cascade = CascadeType.ALL)
    private List<Claim> claimList = new ArrayList<>();

}
