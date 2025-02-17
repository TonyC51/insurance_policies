package org.example.repository;

import org.example.model.InsurancePolicy;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JpaInsurancePolicyRepository implements InsurancePolicyRepository {

    private final JpaBasedInsurancePolicyRepository jpaBasedInsurancePolicyRepository;

    public JpaInsurancePolicyRepository(JpaBasedInsurancePolicyRepository jpaBasedInsurancePolicyRepository) {
        this.jpaBasedInsurancePolicyRepository = jpaBasedInsurancePolicyRepository;
    }

    @Override
    public List<InsurancePolicy> findAll(Pageable pageable) {
        return jpaBasedInsurancePolicyRepository.findAll(pageable).stream().toList();
    }

    @Override
    public InsurancePolicy createPolicy(InsurancePolicy policy) {
        return jpaBasedInsurancePolicyRepository.save(policy);
    }

    @Override
    public Optional<InsurancePolicy> findPolicyById(Integer id) {
        return jpaBasedInsurancePolicyRepository.findById(id);
    }

    @Override
    public InsurancePolicy updatePolicyById(InsurancePolicy policy) {
        return jpaBasedInsurancePolicyRepository.save(policy);
    }
}
