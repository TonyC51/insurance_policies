package org.example.mapper;

import org.example.dto.InsurancePolicyDto;
import org.example.model.InsurancePolicy;

import java.util.List;

public interface EntityToDtoMapper {
    public InsurancePolicyDto entityToDto(InsurancePolicy insurancePolicyEntity);
    public List<InsurancePolicyDto> entitiesToDtos(List<InsurancePolicy> insurancePolicyList);
}
