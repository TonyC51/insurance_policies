package org.example.dto;


import org.example.model.PolicyStatus;

import java.util.Date;

public record InsurancePolicyDto(
    Integer id,
    String name,
    PolicyStatus policyStatus,
    Date startingDate,
    Date endingDate,
    Date creationDate,
    Date updateDate) {
}
