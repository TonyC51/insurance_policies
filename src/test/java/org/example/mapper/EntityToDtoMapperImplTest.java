package org.example.mapper;

import org.example.utils.TestUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EntityToDtoMapperImplTest {

    private final EntityToDtoMapperImpl mapper = new EntityToDtoMapperImpl();


    @Test
    void entityToDto() {
        assertEquals(mapper.entityToDto(
                TestUtils.getExampleInsurancePolicies().getFirst()).policyStatus(),
                TestUtils.getExampleInsurancePolicyDtos().getFirst().policyStatus());
        assertEquals(mapper.entityToDto(
                        TestUtils.getExampleInsurancePolicies().getFirst()).startingDate(),
                TestUtils.getExampleInsurancePolicyDtos().getFirst().startingDate());
        assertEquals(mapper.entityToDto(
                        TestUtils.getExampleInsurancePolicies().getFirst()).endingDate(),
                TestUtils.getExampleInsurancePolicyDtos().getFirst().endingDate());
    }

    @Test
    void entitiesToDtos() {
        assertEquals(mapper.entitiesToDtos(
                        TestUtils.getExampleInsurancePolicies()).getFirst().policyStatus(),
                TestUtils.getExampleInsurancePolicyDtos().getFirst().policyStatus());
        assertEquals(mapper.entitiesToDtos(
                        TestUtils.getExampleInsurancePolicies()).getFirst().startingDate(),
                TestUtils.getExampleInsurancePolicyDtos().getFirst().startingDate());
        assertEquals(mapper.entitiesToDtos(
                        TestUtils.getExampleInsurancePolicies()).getFirst().endingDate(),
                TestUtils.getExampleInsurancePolicyDtos().getFirst().endingDate());
    }
}