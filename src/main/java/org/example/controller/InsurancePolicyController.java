package org.example.controller;

import jakarta.validation.Valid;
import org.example.dto.InsurancePolicyBrowse;
import org.example.dto.InsurancePolicyCreationDto;
import org.example.dto.InsurancePolicyDto;
import org.example.dto.InsurancePolicyUpdateDto;
import org.example.service.InsurancePolicyService;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/policies/")
@CrossOrigin(origins = "http://localhost:8080")
public class InsurancePolicyController {

    private final InsurancePolicyService insurancePolicyService;

    public InsurancePolicyController(InsurancePolicyService insurancePolicyService) {
        this.insurancePolicyService = insurancePolicyService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public InsurancePolicyDto createInsurancePolicy(@Valid @RequestBody InsurancePolicyCreationDto insurancePolicyDto ) {
        return insurancePolicyService.createInsurancePolicy(insurancePolicyDto);
    }

    @GetMapping("{id}")
    public InsurancePolicyDto findInsurancePolicy(@PathVariable("id") Integer id) {
        return insurancePolicyService.findById(id);
    }

    @PutMapping("{id}")
    public InsurancePolicyDto updateInsurancePolicy(@PathVariable("id") Integer id, @Valid @RequestBody InsurancePolicyUpdateDto insurancePolicyUpdateDto) {
        return insurancePolicyService.updateInsurancePolicy(id, insurancePolicyUpdateDto);
    }

    @GetMapping()
    public List<InsurancePolicyDto> findAllInsurancePolicies(@Valid @RequestBody InsurancePolicyBrowse pageable) {
        return insurancePolicyService.findAllInsurancePolicies(
                PageRequest.of(
                        pageable.from(),
                        pageable.pageSize())
        );
    }
}
