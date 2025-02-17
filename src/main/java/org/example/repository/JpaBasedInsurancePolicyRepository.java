package org.example.repository;

import org.example.model.InsurancePolicy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaBasedInsurancePolicyRepository extends JpaRepository<InsurancePolicy, Integer> {
}
