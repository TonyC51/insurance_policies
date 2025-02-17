package org.example.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dto.InsurancePolicyBrowse;
import org.example.dto.InsurancePolicyCreationDto;
import org.example.dto.InsurancePolicyDto;
import org.example.service.InsurancePolicyService;
import org.example.utils.TestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@ContextConfiguration(classes = {InsurancePolicyController.class})
class InsurancePolicyControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper = new ObjectMapper();

    @MockitoBean
    InsurancePolicyService insurancePolicyService;

    private List<InsurancePolicyDto> outputs;


    @BeforeEach
    void setUp() {
        outputs = TestUtils.getExampleInsurancePolicyDtos();
    }

    @Test
    void createInsurancePolicy() throws Exception {
        InsurancePolicyCreationDto input = TestUtils.getExampleInsurancePolicyCreateDtos().getFirst();
        InsurancePolicyDto expected = outputs.getFirst();
        when(insurancePolicyService.createInsurancePolicy(any())).thenReturn(expected);
        mockMvc.perform(
                        post("/policies/")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON)
                                .content(mapper.writeValueAsString(input))
                )
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(mapper.writeValueAsString(expected), true));
    }

    @Test
    void findAllInsurancePolicies() throws Exception {
        List<InsurancePolicyDto> expected = TestUtils.getExampleInsurancePolicyDtos();
        when(insurancePolicyService.findAllInsurancePolicies(PageRequest.of(0,2))).thenReturn(expected);
        mockMvc
                .perform(
                        get("/policies/")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON)
                                .content(mapper.writeValueAsString(new InsurancePolicyBrowse(0,2))
                                ))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(mapper.writeValueAsString(expected), true));
    }

    @Test
    void findInsurancePolicy() throws Exception {
        InsurancePolicyDto expected = outputs.getFirst();
        when(insurancePolicyService.findById(1)).thenReturn(expected);
        mockMvc
                .perform(
                        get("/policies/1")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(mapper.writeValueAsString(expected), true));
    }

    @Test
    void updateInsurancePolicy() throws Exception {
        InsurancePolicyDto expected = TestUtils.getExampleInsurancePolicyUpdatedDto();
        when(insurancePolicyService.updateInsurancePolicy(any(), any())).thenReturn(expected);
        mockMvc
                .perform(
                        put("/policies/1")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON)
                                .content(mapper.writeValueAsString(TestUtils.getExampleInsurancePolicyUpdateDto()))
                )
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(mapper.writeValueAsString(expected), true));
    }
}