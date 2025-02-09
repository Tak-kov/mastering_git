package com.swish.demo.controller;

import com.jayway.jsonpath.JsonPath;
import com.swish.demo.entity.DepartmentEntity;
import com.swish.demo.error.DepartmentNotFoundException;
import com.swish.demo.service.DepartmentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.assertj.MockMvcTester;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;
@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {
    @MockitoBean
    private DepartmentServiceImpl departmentService;
    @Autowired
    private MockMvc mockMvc;


    private DepartmentEntity department;
    @BeforeEach
    void setUp() {
        department=DepartmentEntity.builder()
                .departmentName("Mech").departmentCode("02").departmentAddress("Dehli").departmentId(1L)
                .build();

    }

    @Test
    void department() throws Exception {
        DepartmentEntity inputDepartment=DepartmentEntity.builder()
                .departmentName("Mech").departmentCode("02").departmentAddress("Dehli")
                .build();
        Mockito.when(departmentService.saveDepartment(inputDepartment)).thenReturn(department);
        mockMvc.perform(MockMvcRequestBuilders.post("/department")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"departmentName\":\"Mech\",\n" +
                        "    \"departmentCode\":\"02\",\n" +
                        "    \"departmentAddress\":\"Delhi\"\n" +
                        "}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void fetchDepartmentById() throws Exception {
        Mockito.when(departmentService.fetchDepartmentById(1L)).thenReturn(department);
        mockMvc.perform(MockMvcRequestBuilders.get("/department/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}