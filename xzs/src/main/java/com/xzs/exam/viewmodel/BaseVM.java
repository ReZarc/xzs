package com.xzs.exam.viewmodel;

import com.xzs.exam.utility.ModelMapperSingle;
import org.modelmapper.ModelMapper;

public class BaseVM {
    /**
     */
    protected static ModelMapper modelMapper = ModelMapperSingle.Instance();


    /**
     * 获取 model mapper
     *
     * @return the model mapper
     */
    public static ModelMapper getModelMapper() {
        return modelMapper;
    }

    /**
     * 设定 model mapper.
     *
     */
    public static void setModelMapper(ModelMapper modelMapper) {
        BaseVM.modelMapper = modelMapper;
    }
}
