package com.swish.demo.controller;

import java.util.List;
import com.swish.demo.entity.DepartmentEntity;
import com.swish.demo.error.DepartmentNotFoundException;
import com.swish.demo.service.DepartmentServiceImpl;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentServiceImpl departmentService;

    private final Logger LOGGER= LoggerFactory.getLogger(DepartmentController.class);
    @PostMapping("/department")
    public String department(@Valid @RequestBody DepartmentEntity department){
        LOGGER.info("inside saveDepartment");
        departmentService.saveDepartment(department);
        return "Department is saved";
    }

    @GetMapping("/department")
    public List<DepartmentEntity> departmentEntityLIST(){
        LOGGER.info("inside fetchDepartment");
        return departmentService.fetchDepartmentsList();
    }

    @GetMapping("/department/{id}")
    public DepartmentEntity fetchDepartmentById(@PathVariable("id") Long id) throws DepartmentNotFoundException {
        return departmentService.fetchDepartmentById(id);
    }

    @DeleteMapping("/department/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long id){
        departmentService.deleteDepartmentById(id);
        return "Department deleted successfully!";
    }
    @PutMapping("/department/{id}")
    public DepartmentEntity updateDepartment(@PathVariable("id")Long id,@RequestBody DepartmentEntity department){
        return departmentService.updateDepartment(id,department);
    }
    @GetMapping("/department/name/{name}")
    public DepartmentEntity findByName(@PathVariable("name")String name){
        return departmentService.findByName(name);
    }
}
