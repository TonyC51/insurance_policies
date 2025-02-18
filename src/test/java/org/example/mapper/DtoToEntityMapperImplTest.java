package org.example.mapper;

import org.example.model.InsurancePolicy;
import org.example.utils.TestUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class DtoToEntityMapperImplTest {

    private final DtoToEntityMapperImpl mapper = new DtoToEntityMapperImpl();

    @Test
    void createDtoToEntity() {
        InsurancePolicy mapped = mapper.createDtoToEntity(
                TestUtils.getExampleInsurancePolicyCreateDtos().getFirst());
        InsurancePolicy expected = TestUtils.getExampleInsurancePolicies().getFirst();
        assertEquals(mapped.getPolicyStatus(), expected.getPolicyStatus());
        assertEquals(mapped.getStartingDate(), expected.getStartingDate());
        assertEquals(mapped.getEndingDate(), expected.getEndingDate());
        assertEquals(mapped.getName(), expected.getName());
    }

    @Test
    void updateDtoToEntity() {
        InsurancePolicy mapped = mapper.updateDtoToEntity(
                1, TestUtils.getExampleInsurancePolicyUpdateDto());
        InsurancePolicy expected = TestUtils.getExampleInsurancePolicies().getFirst();
        assertEquals(mapped.getStartingDate(), expected.getStartingDate());
        assertEquals(mapped.getEndingDate(), expected.getEndingDate());
        assertEquals(mapped.getPolicyStatus(), expected.getPolicyStatus());
        assertEquals(mapped.getName(), expected.getName());
    }
}