package org.example.utils;

import org.example.dto.InsurancePolicyCreationDto;
import org.example.dto.InsurancePolicyDto;
import org.example.dto.InsurancePolicyUpdateDto;
import org.example.model.InsurancePolicy;
import org.example.model.PolicyStatus;

import java.util.Date;
import java.util.List;

public class TestUtils {

    private static final long startDateMsExample = 1746144000000L;  // 02/05/2025
    private static final long creationDateMsExample = 1746144000000L;  // 02/05/2025

    private static final long endDateMsExample = 1746244000000L; //     03/05/2025
    private static final long updatedDateMsExample = 1746344000000L; //     04/05/2025


    public static List<InsurancePolicy> getExampleInsurancePolicies() {

        return List.of(
                new InsurancePolicy(
                        1,
                        "test1",
                        PolicyStatus.ACTIVE,
                        new Date(startDateMsExample),
                        new Date(endDateMsExample),
                        new Date(creationDateMsExample),
                        new Date(creationDateMsExample)
                ),
                new InsurancePolicy(
                        2,
                        "test2",
                        PolicyStatus.INACTIVE,
                        new Date(startDateMsExample),
                        new Date(endDateMsExample),
                        new Date(creationDateMsExample),
                        new Date(creationDateMsExample)));
    }

    public static InsurancePolicy getExampleInsurancePolicieUpdated() {

        return new InsurancePolicy(
                        1,
                        "test1",
                        PolicyStatus.ACTIVE,
                        new Date(startDateMsExample),
                        new Date(endDateMsExample),
                        new Date(creationDateMsExample),
                        new Date(updatedDateMsExample)
                );
    }

    public static InsurancePolicy getExampleInsurancePolicieCreation() {
        return new InsurancePolicy(
                "test1",
                PolicyStatus.ACTIVE,
                new Date(startDateMsExample),
                new Date(endDateMsExample)
        );
    }

    public static InsurancePolicy getExampleInsurancePolicieUpdate() {
        return new InsurancePolicy(
                1,
                "test1",
                PolicyStatus.ACTIVE,
                new Date(startDateMsExample),
                new Date(endDateMsExample),
                new Date(creationDateMsExample),
                new Date(updatedDateMsExample)
        );
    }


    public static List<InsurancePolicyDto> getExampleInsurancePolicyDtos() {

        return List.of(
                new InsurancePolicyDto(
                        1,
                        "test1",
                        PolicyStatus.ACTIVE,
                        new Date(startDateMsExample),
                        new Date(endDateMsExample),
                        new Date(creationDateMsExample),
                        new Date(creationDateMsExample)),
                new InsurancePolicyDto(
                        2,
                        "test2",
                        PolicyStatus.INACTIVE,
                        new Date(startDateMsExample),
                        new Date(endDateMsExample),
                        new Date(creationDateMsExample),
                        new Date(creationDateMsExample)));
    }

    public static List<InsurancePolicyCreationDto> getExampleInsurancePolicyCreateDtos() {

        return List.of(
                new InsurancePolicyCreationDto(
                        "test1",
                        PolicyStatus.ACTIVE,
                        new Date(startDateMsExample),
                        new Date(endDateMsExample)
                ),
                new InsurancePolicyCreationDto(
                        "test2",
                        PolicyStatus.INACTIVE,
                        new Date(startDateMsExample),
                        new Date(endDateMsExample)
                ));
    }

    public static InsurancePolicyUpdateDto getExampleInsurancePolicyUpdateDto() {
        return new InsurancePolicyUpdateDto(
                "test1",
                PolicyStatus.ACTIVE,
                new Date(startDateMsExample),
                new Date(endDateMsExample),
                new Date(creationDateMsExample)
        );
    }

    public static InsurancePolicyDto getExampleInsurancePolicyUpdatedDto() {
        return new InsurancePolicyDto(
                1,
                "test1",
                PolicyStatus.ACTIVE,
                new Date(startDateMsExample),
                new Date(endDateMsExample),
                new Date(creationDateMsExample),
                new Date(updatedDateMsExample)
        );
    }
}
