package com.swish.demo.repository;

import com.swish.demo.entity.DepartmentEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class DepartmentRepositoryTest {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        DepartmentEntity department=
                DepartmentEntity.builder()

                        .departmentAddress("Delhi")
                        .departmentCode("ME-1")
                        .departmentName("Mech")
                        .build();
            entityManager.persist(department);
    }

    @Test
    public void whenFindById_thenReturnDepartment(){
        DepartmentEntity departmentEntity=departmentRepository.findById(1L).get();
        assertEquals(departmentEntity.getDepartmentName(),"Mech");
    }
}