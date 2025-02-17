package org.example.mapper;

import org.example.utils.TestUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class DtoToEntityMapperImplTest {

    private final DtoToEntityMapperImpl mapper = new DtoToEntityMapperImpl();

    @Test
    void createDtoToEntity() {
        assertEquals(
                mapper.createDtoToEntity(
                    TestUtils.getExampleInsurancePolicyCreateDtos().getFirst()).getPolicyStatus(),
                    TestUtils.getExampleInsurancePolicies().getFirst().getPolicyStatus());
        assertEquals(
                mapper.createDtoToEntity(
                    TestUtils.getExampleInsurancePolicyCreateDtos().getFirst()).getStartingDate(),
                    TestUtils.getExampleInsurancePolicies().getFirst().getStartingDate());
        assertEquals(
                mapper.createDtoToEntity(
                    TestUtils.getExampleInsurancePolicyCreateDtos().getFirst()).getEndingDate(),
                    TestUtils.getExampleInsurancePolicies().getFirst().getEndingDate());
    }

    @Test
    void updateDtoToEntity() {
        assertEquals(mapper.updateDtoToEntity(
                1, TestUtils.getExampleInsurancePolicyUpdateDto()).getStartingDate(),
                TestUtils.getExampleInsurancePolicies().getFirst().getStartingDate());
        assertEquals(mapper.updateDtoToEntity(
                        1, TestUtils.getExampleInsurancePolicyUpdateDto()).getEndingDate(),
                TestUtils.getExampleInsurancePolicies().getFirst().getEndingDate());
        assertEquals(mapper.updateDtoToEntity(
                        1, TestUtils.getExampleInsurancePolicyUpdateDto()).getPolicyStatus(),
                TestUtils.getExampleInsurancePolicies().getFirst().getPolicyStatus());
    }
}