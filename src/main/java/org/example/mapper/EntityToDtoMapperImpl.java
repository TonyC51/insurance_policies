package org.example.mapper;

import org.example.dto.InsurancePolicyDto;
import org.example.model.InsurancePolicy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EntityToDtoMapperImpl implements EntityToDtoMapper{

    @Override
    public InsurancePolicyDto entityToDto(InsurancePolicy insurancePolicyEntity) {
        return new InsurancePolicyDto(
                insurancePolicyEntity.getId(),
                insurancePolicyEntity.getName(),
                insurancePolicyEntity.getPolicyStatus(),
                insurancePolicyEntity.getStartingDate(),
                insurancePolicyEntity.getEndingDate(),
                insurancePolicyEntity.getCreationDate(),
                insurancePolicyEntity.getUpdateDate());
    }

    @Override
    public List<InsurancePolicyDto> entitiesToDtos(List<InsurancePolicy> insurancePolicyList) {
        return insurancePolicyList.stream().map(insurancePolicyEntity -> new InsurancePolicyDto(
                insurancePolicyEntity.getId(),
                insurancePolicyEntity.getName(),
                insurancePolicyEntity.getPolicyStatus(),
                insurancePolicyEntity.getStartingDate(),
                insurancePolicyEntity.getEndingDate(),
                insurancePolicyEntity.getCreationDate(),
                insurancePolicyEntity.getUpdateDate())).toList();
    }
}
