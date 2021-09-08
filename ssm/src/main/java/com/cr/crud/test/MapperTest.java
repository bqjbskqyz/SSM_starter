package com.cr.crud.test;

import com.cr.crud.bean.Department;
import com.cr.crud.bean.Employee;
import com.cr.crud.dao.DepartmentMapper;
import com.cr.crud.dao.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {
    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    SqlSession batchSqlSession;

    @Test
    public void testCrud(){
//        插入、查询部门表
//        System.out.println(departmentMapper);
//        int ret = departmentMapper.insertDept(new Department("研发部"));
//        int ret = departmentMapper.insertDept(new Department("销售部"));
//        System.out.println(ret);
//        List<Department> departments = departmentMapper.getDeptById(2);
//        for (Department dept:departments){
//            System.out.println(dept);
//            System.out.println(dept.getId());
//            System.out.println(dept.getName());
//        }
//        插入员工表
//        System.out.println(employeeMapper);
//        int ret = employeeMapper.insertEmployee(new Employee("张三",'1',"123@cr.com",1,null));
//        System.out.println(ret);
//        查询员工表
//        List<Employee> employees=employeeMapper.getStuByIdWithoutDept(1);
//        for (Employee emp:employees){
//            System.out.println(emp);
//            System.out.println(emp.getId());
//            System.out.println(emp.getName());
//            System.out.println(emp.getGender());
//            System.out.println(emp.getEmail());
//            System.out.println(emp.getDeptId());
//            System.out.println(emp.getDeptName());
//        }
//        批量插入
//        EmployeeMapper batchMapper = batchSqlSession.getMapper(EmployeeMapper.class);
//        for(int i=0;i<1000;i++){
//            String name = UUID.randomUUID().toString().substring(0, 6)+i;
//            batchMapper.insertEmployee(new Employee(name,'1',name+"@cr.com",1,"研发部"));
//        }
//        System.out.println("done");
    }
}
