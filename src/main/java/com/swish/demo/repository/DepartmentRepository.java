package com.swish.demo.repository;

import com.swish.demo.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity,Long> {
    public DepartmentEntity findByDepartmentName(String name);
}
