package org.example.dto;


import org.example.model.PolicyStatus;

import java.util.Date;

public record InsurancePolicyCreationDto(
    String name,
    PolicyStatus policyStatus,
    Date startingDate,
    Date endingDate) {
}

