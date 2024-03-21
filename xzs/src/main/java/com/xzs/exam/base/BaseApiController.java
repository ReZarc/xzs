package com.xzs.exam.base;

import com.xzs.exam.context.WebContext;
import com.xzs.exam.domain.User;
import com.xzs.exam.utility.ModelMapperSingle;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
/**
 用户基础类
 */
public class BaseApiController {
    // 常量
    protected final static ModelMapper modelMapper = ModelMapperSingle.Instance();
    @Autowired
    protected WebContext webContext;
    /**
     获取当前用户
     */
    protected User getCurrentUser() {
        return webContext.getCurrentUser();
    }
}
