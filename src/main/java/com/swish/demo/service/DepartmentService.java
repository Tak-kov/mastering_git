package com.swish.demo.service;

import com.swish.demo.entity.DepartmentEntity;
import com.swish.demo.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    public DepartmentEntity saveDepartment(DepartmentEntity department);

    public List<DepartmentEntity> fetchDepartmentsList();

    public DepartmentEntity fetchDepartmentById(Long id) throws DepartmentNotFoundException;

    public void deleteDepartmentById(Long id);

    public DepartmentEntity updateDepartment(Long id, DepartmentEntity department);

    public DepartmentEntity findByName(String name);
}
