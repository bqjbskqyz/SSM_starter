package com.cr.crud.test;

import com.cr.crud.bean.Employee;
import com.github.pagehelper.PageInfo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:applicationContext.xml","classpath:springMVC.xml"})
public class MvcTest {
    @Autowired
    WebApplicationContext context;

    MockMvc mockMvc;

    @Before
    public void invokeMockMvc(){
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testPageHelper() throws Exception {
        ServletContext servletContext = context.getServletContext();
        Assert.assertNotNull(servletContext);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/emps").param("pn", "1")).andReturn();
        MockHttpServletRequest mvcResultRequest = mvcResult.getRequest();
        Assert.assertNotNull(mvcResultRequest);
        PageInfo pageInfo =(PageInfo) mvcResultRequest.getAttribute("pageInfo");
        Assert.assertNotNull(pageInfo);
        System.out.println("当前页码: "+pageInfo.getPageNum());
        System.out.println("总页码: "+pageInfo.getPages());
        System.out.println("总记录数目: "+pageInfo.getTotal());
        System.out.println("页面连续显示的页码数目:");
        int[] navigatepageNums = pageInfo.getNavigatepageNums();
        for(int i=0;i< navigatepageNums.length;i++){
            System.out.println(navigatepageNums[i]);
        }
        List<Employee> list = pageInfo.getList();
        for(Employee emp:list){
            System.out.println(emp.getId());
            System.out.println(emp.getName());
            System.out.println(emp.getGender());
            System.out.println(emp.getEmail());
            System.out.println(emp.getDeptId());
            System.out.println(emp.getDeptName());
        }

    }
}
