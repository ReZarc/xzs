package com.xzs.exam.viewmodel.admin.major;

import com.xzs.exam.base.BasePage;


public class ClassPageRequestVM extends BasePage {
    private Integer id;
    private String name;
    private Integer role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
