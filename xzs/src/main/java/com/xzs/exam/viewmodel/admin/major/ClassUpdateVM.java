package com.xzs.exam.viewmodel.admin.major;

import com.xzs.exam.domain.Class;

import javax.validation.constraints.NotBlank;

public class ClassUpdateVM {
    private Integer id;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

