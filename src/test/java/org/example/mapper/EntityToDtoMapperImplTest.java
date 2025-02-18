package org.example.mapper;

import org.example.dto.InsurancePolicyDto;
import org.example.utils.TestUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EntityToDtoMapperImplTest {

    private final EntityToDtoMapperImpl mapper = new EntityToDtoMapperImpl();

    @Test
    void entityToDto() {
        InsurancePolicyDto mapped = mapper.entityToDto(
                TestUtils.getExampleInsurancePolicies().getFirst());
        InsurancePolicyDto expected = TestUtils.getExampleInsurancePolicyDtos().getFirst();
        assertEquals(mapped.policyStatus(), expected.policyStatus());
        assertEquals(mapped.startingDate(), expected.startingDate());
        assertEquals(mapped.endingDate(), expected.endingDate());
        assertEquals(mapped.name(), expected.name());
    }

    @Test
    void entitiesToDtos() {
        InsurancePolicyDto mapped = mapper.entitiesToDtos(
                TestUtils.getExampleInsurancePolicies()).getFirst();
        InsurancePolicyDto expected = TestUtils.getExampleInsurancePolicyDtos().getFirst();
        assertEquals(mapped.policyStatus(), expected.policyStatus());
        assertEquals(mapped.startingDate(), expected.startingDate());
        assertEquals(mapped.endingDate(), expected.endingDate());
        assertEquals(mapped.name(), expected.name());
    }
}