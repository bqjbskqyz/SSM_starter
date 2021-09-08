package com.cr.crud.service;

import com.cr.crud.bean.Employee;
import com.cr.crud.dao.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    EmployeeMapper employeeMapper;

    public List<Employee> getAll(){
        return employeeMapper.getEmpByIdWithDept();
    }

    @Override
    public void saveEmp(Employee emp) {
        employeeMapper.insertEmployee(emp);
    }

    @Override
    public Integer isEmpNameExisted(String name) {
        return employeeMapper.isEmpNameExisted(name);
    }

    @Override
    public Integer isEmpEmailExisted(String email) {
        return employeeMapper.isEmpEmailExisted(email);
    }

    @Override
    public Employee getEmpById(Integer id) {
        List<Employee> emps=employeeMapper.getStuByIdWithoutDept(id);
        if(emps!=null&&!emps.isEmpty()){
            return emps.get(0);
        }
        return new Employee(-1,"null",'0',"null",-1,"null");
    }

    @Override
    public int updateEmp(Employee emp) {
        return employeeMapper.updateByPrimaryKeySelective(emp);
    }

    @Override
    public int deleteEmp(List<Integer> ids) {
       return employeeMapper.deleteByIdsIn(ids);
    }
}
