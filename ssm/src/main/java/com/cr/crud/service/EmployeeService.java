package com.cr.crud.service;

import com.cr.crud.bean.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    /**
     * 查询所有员工
     * @return list
     */
    List<Employee> getAll();

    /**
     * 插入单个员工
     * @param employee 员工对象
     */
    void saveEmp(Employee employee);

    /**
     * 查询员工对象用户名是否已存在
     * @param name emp对象name字段
     * @return 存在==true
     */
    Integer isEmpNameExisted(String name);

    /**
     * 查询邮箱是否已存在
     * @param email emp email
     * @return 存在为true
     */
    Integer isEmpEmailExisted(String email);

    /**
     * 根据id查询emp对象信息
     * @param id emp id
     * @return emp对象
     */
    Employee getEmpById(Integer id);

    /**
     * 修改emp
     * @param emp emp对象
     * @return 修改记录数
     */
    int updateEmp(Employee emp);

    /**
     * 删除emp
     * @param ids emp id
     * @return 删除记录数
     */
    int deleteEmp(List<Integer> ids);
}
