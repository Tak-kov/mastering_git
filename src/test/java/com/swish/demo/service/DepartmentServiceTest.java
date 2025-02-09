package com.swish.demo.service;

import com.swish.demo.entity.DepartmentEntity;
import com.swish.demo.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DepartmentServiceTest {
    @Autowired
    DepartmentService departmentService;
    @MockitoBean
    DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        DepartmentEntity department=
                DepartmentEntity.builder()
                        .departmentId(1L)
                        .departmentCode("IT-06")
                        .departmentAddress("Delhi")
                        .departmentName("IT")
                        .build();
        Mockito.when(departmentRepository.findByDepartmentName("IT")).thenReturn(department);
    }

    @Test
    @Disabled
    public void whenValidDepartmentName_thenDepartmentShouldFound(){
        String departmentName="IT";
        DepartmentEntity found=
                    departmentService.findByName(departmentName);
        assertEquals(departmentName,found.getDepartmentName());
    }
}