package com.cr.crud.controller;

import com.cr.crud.bean.Employee;
import com.cr.crud.bean.Msg;
import com.cr.crud.service.EmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 处理员工表crud请求
 */
@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/emps")
    @ResponseBody
    public Msg getEmps(@RequestParam(value="pn",defaultValue = "1")Integer pageNum){
        PageHelper.startPage(pageNum,5);
        List<Employee> employees = employeeService.getAll();
        PageInfo page =new PageInfo(employees,5);
        return Msg.success().add("pageInfo",page);
    }

    @RequestMapping(value="/emp",method = RequestMethod.POST)
    @ResponseBody
    public Msg saveEmp(Employee emp, BindingResult result){
        Map<String,Object> map = new HashMap<>();
        if(result.hasErrors()){
            List<FieldError> fieldErrors = result.getFieldErrors();
            for (FieldError error:fieldErrors){
                map.put(error.getField(),error.getDefaultMessage());
            }
            return Msg.fail().add("errorFields",map);
        }else {
            employeeService.saveEmp(emp);
            return Msg.success();
        }
    }

    @RequestMapping("/checkuser")
    @ResponseBody
    public Msg checkUser(@RequestParam(value="empName")String name){
        //先判断用户名是否是合法的表达式;
        String regx = "(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})";
        if(!name.matches(regx)){
            return Msg.fail().add("va_msg", "用户名必须是6-16位数字和字母的组合或者2-5位中文");
        }

        //判断数据库是否相同的用户名
        Integer existedId = employeeService.isEmpNameExisted(name);
        if(existedId==null){
            return Msg.success();
        }else {
            return Msg.fail().add("va_msg","用户名已存在");
        }
    }

    @ResponseBody
    @RequestMapping("checkemail")
    public Msg checkEmail(@RequestParam(value="empEmail")String email){
        //先判断邮箱是否是合法的表达式;
        String regex="^([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})$";
        if(!email.matches(regex)){
            return Msg.fail().add("va_msg","邮箱不合法");
        }

        //判断数据库是否存在该email
        Integer existedEmail = employeeService.isEmpEmailExisted(email);
        if(existedEmail==null){
            return Msg.success();
        }else {
            return Msg.fail().add("va_msg","邮箱已存在");
        }
    }

    @ResponseBody
    @RequestMapping(value="/emp/{id}",method=RequestMethod.GET)
    public Msg getEmpByid(@PathVariable("id")Integer id){
        Employee employee = employeeService.getEmpById(id);
        int queryEmpId = employee.getId();
        if(queryEmpId==id){
            return Msg.success().add("emp",employee);
        }else {
            return Msg.fail();
        }
    }

    @ResponseBody
    @RequestMapping(value = "/emp/{id}",method = RequestMethod.PUT)
    public Msg putEmp(Employee employee, HttpServletRequest request){
        System.out.println(request.getParameter("gender"));
        System.out.println(request.getParameter("email"));
        System.out.println(request.getParameter("deptId"));
        int ret = employeeService.updateEmp(employee);
        if(ret==1){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }

    @ResponseBody
    @RequestMapping(value="/emp/{ids}",method = RequestMethod.DELETE)
    public Msg deleteEmp(@PathVariable("ids")String ids){
        List<Integer> idList =new ArrayList<>();
        if(ids.contains("-")){
            String[] strs = ids.split("-");
            for (String s: strs){
                idList.add(Integer.parseInt(s));
            }
        }else {
            Integer id = Integer.parseInt(ids);
            idList.add(id);
        }
        int ret = employeeService.deleteEmp(idList);
        if(ret==0){
            return Msg.fail();
        }else{
            return Msg.success();
        }
    }

//    @RequestMapping("/emps")
//    public String getEmps(@RequestParam(value="pn",defaultValue = "1")Integer pn, Model model){
//        PageHelper.startPage(pn,5);
//        List<Employee> employees = employeeService.getAll();
//        PageInfo page =new PageInfo(employees,5);
//        model.addAttribute("pageInfo",page);
//        return "list";
//    }
}
