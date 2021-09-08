package com.cr.crud.bean;

import javax.validation.constraints.Pattern;

public class Employee {
    private int id;

    @Pattern(regexp = "(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})",
            message = "用户名不合法")
    private String name;

    private char gender;

    @Pattern(regexp = "^([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})$",
    message = "邮箱地址不合法")
    private String email;

    private int deptId;

    private String deptName;

    public Employee(){

    }

    public Employee(String name, char gender, String email, int deptId, String deptName){
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.deptId = deptId;
        this.deptName = deptName;
    }

    public Employee(int id, String name, char gender, String email, int deptId, String deptName) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.deptId = deptId;
        this.deptName = deptName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
