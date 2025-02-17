package org.example.mapper;

import org.example.dto.InsurancePolicyCreationDto;
import org.example.dto.InsurancePolicyUpdateDto;
import org.example.model.InsurancePolicy;

public interface DtoToEntityMapper {
    public InsurancePolicy createDtoToEntity(InsurancePolicyCreationDto creationPolicyDto);
    public InsurancePolicy updateDtoToEntity(Integer id, InsurancePolicyUpdateDto creationPolicyDto);
}
