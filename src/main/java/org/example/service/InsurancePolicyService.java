package org.example.service;

import org.example.dto.InsurancePolicyCreationDto;
import org.example.dto.InsurancePolicyDto;
import org.example.dto.InsurancePolicyUpdateDto;
import org.example.exceptions.InsurancePolicyNotExistException;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface InsurancePolicyService {
    InsurancePolicyDto createInsurancePolicy(InsurancePolicyCreationDto insurancePolicyCreationDto);
    InsurancePolicyDto updateInsurancePolicy(Integer id, InsurancePolicyUpdateDto insurancePolicyUpdateDto);
    InsurancePolicyDto findById(Integer id) throws InsurancePolicyNotExistException;
    List<InsurancePolicyDto> findAllInsurancePolicies(Pageable pageable);
}