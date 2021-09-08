package com.cr.crud.dao;

import com.cr.crud.bean.Department;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepartmentMapper {
    /**
     * 通过id获取部门对象
     * @param id 部门id
     * @return 部门对象list
     */
    List<Department> getDeptById(@Param("id") int id);

    /**
     * 插入部门信息
     * @param dept 部门对象
     * @return 插入成功返回的条数
     */
    int insertDept(Department dept);

    List<Department> getAll();
}
