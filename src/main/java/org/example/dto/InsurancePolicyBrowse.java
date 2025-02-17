package org.example.dto;

import jakarta.validation.constraints.Max;

public record InsurancePolicyBrowse(Integer from, @Max(100) Integer pageSize) {
}
