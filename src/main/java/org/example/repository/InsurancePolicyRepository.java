package org.example.repository;

import org.example.model.InsurancePolicy;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface InsurancePolicyRepository {
    List<InsurancePolicy> findAll(Pageable pageable);
    InsurancePolicy createPolicy(InsurancePolicy policy);
    Optional<InsurancePolicy> findPolicyById(Integer id);
    InsurancePolicy updatePolicyById(InsurancePolicy policy);
}