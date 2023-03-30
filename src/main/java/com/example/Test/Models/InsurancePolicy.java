package com.example.Test.Models;

import com.example.Test.Enum.Type;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

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

}
