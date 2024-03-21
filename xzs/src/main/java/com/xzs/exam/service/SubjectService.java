package com.xzs.exam.service;

import com.github.pagehelper.PageInfo;
import com.xzs.exam.domain.Subject;
import com.xzs.exam.viewmodel.admin.education.SubjectPageRequestVM;

import java.util.List;

public interface SubjectService extends BaseService<Subject> {

    List<Subject> getSubjectByLevel(Integer level);

    List<Subject> allSubject();

    Integer levelBySubjectId(Integer id);

    PageInfo<Subject> page(SubjectPageRequestVM requestVM);
}
