package com.insuranceme.insurance_me.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Policy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String policyHolderName;
    private String type;
    private Double premiumAmount;
    private String startDate;
    private String endDate;
}
