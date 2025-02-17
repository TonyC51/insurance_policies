package org.example.service;

import org.example.dto.InsurancePolicyCreationDto;
import org.example.dto.InsurancePolicyDto;
import org.example.dto.InsurancePolicyUpdateDto;
import org.example.exceptions.InsurancePolicyNotExistException;
import org.example.mapper.DtoToEntityMapper;
import org.example.mapper.EntityToDtoMapper;
import org.example.model.InsurancePolicy;
import org.example.repository.InsurancePolicyRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsurancePolicyServiceImpl implements InsurancePolicyService {

    private final InsurancePolicyRepository insurancePolicyRepository;
    private final DtoToEntityMapper dtoToEntityMapper;
    private final EntityToDtoMapper entityToDtoMapper;

    public InsurancePolicyServiceImpl(
            InsurancePolicyRepository insurancePolicyRepository,
            DtoToEntityMapper dtoToEntityMapper,
            EntityToDtoMapper entityToDtoMapper) {
        this.insurancePolicyRepository = insurancePolicyRepository;
        this.dtoToEntityMapper = dtoToEntityMapper;
        this.entityToDtoMapper = entityToDtoMapper;
    }

    @Override
    public InsurancePolicyDto createInsurancePolicy(InsurancePolicyCreationDto insurancePolicyCreationDto) {
        InsurancePolicy ip = dtoToEntityMapper.createDtoToEntity(insurancePolicyCreationDto);

        InsurancePolicy res = insurancePolicyRepository.createPolicy(
                ip
        );

        return entityToDtoMapper.entityToDto(res);
    }

    @Override
    public InsurancePolicyDto updateInsurancePolicy(Integer id, InsurancePolicyUpdateDto insurancePolicyUpdateDto) {
        return entityToDtoMapper.entityToDto(
            insurancePolicyRepository.updatePolicyById(
                    dtoToEntityMapper.updateDtoToEntity(id, insurancePolicyUpdateDto)
            )
        );
    }

    @Override
    public InsurancePolicyDto findById(Integer id) throws InsurancePolicyNotExistException {
        return entityToDtoMapper.entityToDto(insurancePolicyRepository.findPolicyById(id).orElseThrow(() -> new InsurancePolicyNotExistException(id)));
    }

    @Override
    public List<InsurancePolicyDto> findAllInsurancePolicies(Pageable pageable) {
        return entityToDtoMapper.entitiesToDtos(insurancePolicyRepository.findAll(pageable));
    }
}
