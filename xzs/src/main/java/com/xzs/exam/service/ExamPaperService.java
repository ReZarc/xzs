package com.xzs.exam.service;

import com.github.pagehelper.PageInfo;
import com.xzs.exam.domain.ExamPaper;
import com.xzs.exam.domain.User;
import com.xzs.exam.viewmodel.admin.exam.ExamPaperEditRequestVM;
import com.xzs.exam.viewmodel.admin.exam.ExamPaperPageRequestVM;
import com.xzs.exam.viewmodel.student.dashboard.PaperFilter;
import com.xzs.exam.viewmodel.student.dashboard.PaperInfo;
import com.xzs.exam.viewmodel.student.exam.ExamPaperPageVM;

import java.util.List;

public interface ExamPaperService extends BaseService<ExamPaper> {

    PageInfo<ExamPaper> page(ExamPaperPageRequestVM requestVM);

    PageInfo<ExamPaper> taskExamPage(ExamPaperPageRequestVM requestVM);

    PageInfo<ExamPaper> studentPage(ExamPaperPageVM requestVM);

    ExamPaper savePaperFromVM(ExamPaperEditRequestVM examPaperEditRequestVM, User user);

    ExamPaperEditRequestVM examPaperToVM(Integer id);

    List<PaperInfo> indexPaper(PaperFilter paperFilter);

    Integer selectAllCount();

    List<Integer> selectMothCount();
}
