package com.xzs.exam.viewmodel.admin.major;

import com.xzs.exam.domain.Major;
import com.xzs.exam.utility.DateTimeUtil;
import com.xzs.exam.viewmodel.BaseVM;


public class MajorResponseVM extends BaseVM {

    private Integer id;

    private String name;

    public static MajorResponseVM from(Major major) {
        MajorResponseVM vm = modelMapper.map(major, MajorResponseVM.class);
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
