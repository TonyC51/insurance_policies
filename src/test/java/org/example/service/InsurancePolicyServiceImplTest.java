package org.example.service;

import org.example.dto.InsurancePolicyCreationDto;
import org.example.dto.InsurancePolicyDto;
import org.example.dto.InsurancePolicyUpdateDto;
import org.example.mapper.DtoToEntityMapperImpl;
import org.example.mapper.EntityToDtoMapperImpl;
import org.example.model.InsurancePolicy;
import org.example.repository.InsurancePolicyRepository;
import org.example.utils.TestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class InsurancePolicyServiceImplTest {

    private final InsurancePolicyRepository insurancePolicyRepository = mock();
    private final DtoToEntityMapperImpl dtoToEntityMapper = mock();
    private final EntityToDtoMapperImpl entityToDtoMapper = mock();
    private final InsurancePolicyServiceImpl service = new InsurancePolicyServiceImpl(insurancePolicyRepository, dtoToEntityMapper, entityToDtoMapper);

    private final InsurancePolicy insurancePolicyEntity = TestUtils.getExampleInsurancePolicies().getFirst();
    private final InsurancePolicy insurancePolicyEntityUpdated = TestUtils.getExampleInsurancePolicieUpdated();
    private final InsurancePolicy insurancePolicieCreation = TestUtils.getExampleInsurancePolicieCreation();
    private final InsurancePolicyUpdateDto insurancePolicyUpdateDto = TestUtils.getExampleInsurancePolicyUpdateDto();
    private final InsurancePolicyDto insurancePolicyUpdatedDto = TestUtils.getExampleInsurancePolicyUpdatedDto();
    private final InsurancePolicyDto insurancePolicyDto = TestUtils.getExampleInsurancePolicyDtos().getFirst();
    private final InsurancePolicyCreationDto insurancePolicyCreationDto = TestUtils.getExampleInsurancePolicyCreateDtos().getFirst();

    @BeforeEach
    void setUp() {
        when(entityToDtoMapper.entityToDto(insurancePolicyEntity)).thenReturn(insurancePolicyDto);
        when(dtoToEntityMapper.createDtoToEntity(insurancePolicyCreationDto)).thenReturn(insurancePolicieCreation);
        when(dtoToEntityMapper.updateDtoToEntity(1, insurancePolicyUpdateDto)).thenReturn(TestUtils.getExampleInsurancePolicieUpdate());
    }

    @Test
    void createInsurancePolicy() {
        // When
        when(insurancePolicyRepository.createPolicy(insurancePolicieCreation)).thenReturn(insurancePolicyEntity);
        InsurancePolicyDto result = service.createInsurancePolicy(insurancePolicyCreationDto);
        // Then
        assertEquals(insurancePolicyDto, result);
    }

    @Test
    void updateInsurancePolicy() {
        // Given
        when(entityToDtoMapper.entityToDto(insurancePolicyEntityUpdated)).thenReturn(insurancePolicyUpdatedDto);
        when(insurancePolicyRepository.updatePolicyById(TestUtils.getExampleInsurancePolicieUpdate())).thenReturn(insurancePolicyEntityUpdated);
        // When
        InsurancePolicyDto result = service.updateInsurancePolicy(1, insurancePolicyUpdateDto);
        // Then
        assertEquals(insurancePolicyUpdatedDto, result);
    }

    @Test
    void findById() {
        // Given
        when(insurancePolicyRepository.findPolicyById(1)).thenReturn(Optional.of(insurancePolicyEntity));
        // When
        InsurancePolicyDto result = service.findById(1);
        // Then
        assertEquals(insurancePolicyDto, result);
    }

    @Test
    void findAllInsurancePolicies() {
        // Given
        PageRequest pr = PageRequest.of(0,2);
        when(entityToDtoMapper.entitiesToDtos(TestUtils.getExampleInsurancePolicies())).thenReturn(TestUtils.getExampleInsurancePolicyDtos());
        when(insurancePolicyRepository.findAll(pr)).thenReturn(TestUtils.getExampleInsurancePolicies());
        // When
        List<InsurancePolicyDto> results = service.findAllInsurancePolicies(pr);
        // Then
        assertEquals(2, results.size());
        assertEquals(results.get(0), TestUtils.getExampleInsurancePolicyDtos().getFirst());
        assertEquals(results.get(1), TestUtils.getExampleInsurancePolicyDtos().get(1));
    }
}