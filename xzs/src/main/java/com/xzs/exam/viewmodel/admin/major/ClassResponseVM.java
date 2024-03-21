package com.xzs.exam.viewmodel.admin.major;

import com.xzs.exam.domain.Class;
import com.xzs.exam.utility.DateTimeUtil;
import com.xzs.exam.viewmodel.BaseVM;


public class ClassResponseVM extends BaseVM {

    private Integer id;

    private String name;

    public static ClassResponseVM from(Class class1) {
        ClassResponseVM vm = modelMapper.map(class1, ClassResponseVM.class);
        return vm;
    }

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
