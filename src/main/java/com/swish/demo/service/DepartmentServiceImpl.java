package com.swish.demo.service;

import com.swish.demo.entity.DepartmentEntity;
import com.swish.demo.error.DepartmentNotFoundException;
import com.swish.demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public DepartmentEntity saveDepartment(DepartmentEntity department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<DepartmentEntity> fetchDepartmentsList() {
        return departmentRepository.findAll();
    }

    @Override
    public DepartmentEntity fetchDepartmentById(Long id) throws DepartmentNotFoundException {

        Optional<DepartmentEntity> departmentEntity= departmentRepository.findById(id);
        if(!departmentEntity.isPresent()){
            throw new DepartmentNotFoundException("Department not Available!");
        }
        return departmentEntity.get();
    }

    @Override
    public void deleteDepartmentById(Long id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public DepartmentEntity updateDepartment(Long id, DepartmentEntity department) {
        DepartmentEntity depDb=departmentRepository.findById(id).get();

        if(Objects.nonNull(department.getDepartmentName()) &&
        !"".equalsIgnoreCase(department.getDepartmentName())){
            depDb.setDepartmentName(department.getDepartmentName());
        }
        if(Objects.nonNull(department.getDepartmentAddress()) &&
                !"".equalsIgnoreCase(department.getDepartmentAddress())){
            depDb.setDepartmentAddress(department.getDepartmentAddress());
        }
        if(Objects.nonNull(department.getDepartmentCode()) &&
                !"".equalsIgnoreCase(department.getDepartmentCode())){
            depDb.setDepartmentCode(department.getDepartmentCode());
        }
        return departmentRepository.save(depDb);
    }

    @Override
    public DepartmentEntity findByName(String name) {
            return departmentRepository.findByDepartmentName(name);
    }
}
