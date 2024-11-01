package org.example.backend.service;

import lombok.RequiredArgsConstructor;
import org.example.backend.dox.Department;
import org.example.backend.repository.DepartmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class AdminService {
    private final DepartmentRepository departmentRepository;

    //添加专业
    @Transactional
    public Department addDepartment(Department department){
        return departmentRepository.save(department);
    }
    //查看所有的专业
    public List<Department> listDepartment(){
        return departmentRepository.showAll();
    }

}
