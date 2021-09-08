package com.cr.crud.service;

import com.cr.crud.bean.Department;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepartmentService {
    List<Department> getAll();
}
