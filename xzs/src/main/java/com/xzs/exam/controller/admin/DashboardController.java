package com.xzs.exam.controller.admin;

import com.xzs.exam.base.BaseApiController;
import com.xzs.exam.base.RestResponse;
import com.xzs.exam.service.*;
import com.xzs.exam.utility.DateTimeUtil;
import com.xzs.exam.viewmodel.admin.dashboard.IndexVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("AdminDashboardController")     //将返回值转为JSON格式
@RequestMapping(value = "/api/admin/dashboard")     //
public class DashboardController extends BaseApiController {

    private final ExamPaperService examPaperService;    //处理试卷相关的业务逻辑
    private final QuestionService questionService;  //处理题目相关的业务逻辑
    private final ExamPaperAnswerService examPaperAnswerService;    //处理试卷答案相关的业务逻辑
    private final ExamPaperQuestionCustomerAnswerService examPaperQuestionCustomerAnswerService;
    private final UserEventLogService userEventLogService;

    @Autowired
    public DashboardController(ExamPaperService examPaperService, QuestionService questionService, ExamPaperAnswerService examPaperAnswerService, ExamPaperQuestionCustomerAnswerService examPaperQuestionCustomerAnswerService, UserEventLogService userEventLogService) {
        this.examPaperService = examPaperService;
        this.questionService = questionService;
        this.examPaperAnswerService = examPaperAnswerService;
        this.examPaperQuestionCustomerAnswerService = examPaperQuestionCustomerAnswerService;
        this.userEventLogService = userEventLogService;
    }

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public RestResponse<IndexVM> Index() {
        IndexVM vm = new IndexVM();

        Integer examPaperCount = examPaperService.selectAllCount();     // 试卷总数
        Integer questionCount = questionService.selectAllCount();       // 问题总数
        Integer doExamPaperCount = examPaperAnswerService.selectAllCount(); // 做过的试卷总数
        Integer doQuestionCount = examPaperQuestionCustomerAnswerService.selectAllCount();  // 回答的问题总数

        vm.setExamPaperCount(examPaperCount);
        vm.setQuestionCount(questionCount);
        vm.setDoExamPaperCount(doExamPaperCount);
        vm.setDoQuestionCount(doQuestionCount);

        List<Integer> mothDayUserActionValue = userEventLogService.selectMothCount();   // 获取日志记录
        List<Integer> mothDayDoExamQuestionValue = examPaperQuestionCustomerAnswerService.selectMothCount();    //获取错题记录
        vm.setMothDayUserActionValue(mothDayUserActionValue);
        vm.setMothDayDoExamQuestionValue(mothDayDoExamQuestionValue);

        vm.setMothDayText(DateTimeUtil.MothDay());
        return RestResponse.ok(vm);
    }
}
