package com.cr.crud.dao;

import com.cr.crud.bean.Employee;

import java.util.List;

public interface EmployeeMapper {
    /**
     *
     * 获取学生信息，不带部门name
     * @param id 学生id
     * @return employee对象 list
     */
    List<Employee> getStuByIdWithoutDept(int id);

    /**
     * 获取带部门name的学生信息
     * @return employee对象list
     */
    List<Employee> getEmpByIdWithDept();

    /**
     * 插入学生信息
     * @param employee 学生对象
     * @return 插入成功返回的条数
     */
    int insertEmployee(Employee employee);

    /**
     * 查询是否有相同name的记录
     * @param name emp name
     * @return 存在返回true
     */
    Integer isEmpNameExisted(String name);

    /**
     * 查询是否有相同email的记录
     * @param email emp email
     * @return 存在返回true
     */
    Integer isEmpEmailExisted(String email);

    /**
     * 更新emp记录
     * @param emp emp对象
     * @return 修改记录数
     */
    int updateByPrimaryKeySelective(Employee emp);

    /**
     * in ids的所有id 删除
     * @param ids
     * @return 删除记录数
     */
    int deleteByIdsIn(List<Integer> ids);
}
