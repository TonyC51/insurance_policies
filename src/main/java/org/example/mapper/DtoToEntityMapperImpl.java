package org.example.mapper;

import org.example.dto.InsurancePolicyCreationDto;
import org.example.dto.InsurancePolicyUpdateDto;
import org.example.model.InsurancePolicy;
import org.springframework.stereotype.Component;

@Component
public class DtoToEntityMapperImpl implements DtoToEntityMapper{
    @Override
    public InsurancePolicy createDtoToEntity(InsurancePolicyCreationDto creationPolicyDto) {
        return new InsurancePolicy(
                creationPolicyDto.name(),
                creationPolicyDto.policyStatus(),
                creationPolicyDto.startingDate(),
                creationPolicyDto.endingDate()
        );
    }

    @Override
    public InsurancePolicy updateDtoToEntity(Integer id, InsurancePolicyUpdateDto updatePolicyDto) {
        return new InsurancePolicy(
                id,
                updatePolicyDto.name(),
                updatePolicyDto.policyStatus(),
                updatePolicyDto.startingDate(),
                updatePolicyDto.endingDate(),
                updatePolicyDto.creationDate()
                );
    }
}
