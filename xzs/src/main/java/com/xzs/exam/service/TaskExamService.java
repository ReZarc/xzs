package com.xzs.exam.service;

import com.github.pagehelper.PageInfo;
import com.xzs.exam.domain.TaskExam;
import com.xzs.exam.domain.User;
import com.xzs.exam.viewmodel.admin.task.TaskPageRequestVM;
import com.xzs.exam.viewmodel.admin.task.TaskRequestVM;

import java.util.List;

public interface TaskExamService extends BaseService<TaskExam> {

    PageInfo<TaskExam> page(TaskPageRequestVM requestVM);

    void edit(TaskRequestVM model, User user);

    TaskRequestVM taskExamToVM(Integer id);

    List<TaskExam> getByGradeLevel(Integer gradeLevel);
}
