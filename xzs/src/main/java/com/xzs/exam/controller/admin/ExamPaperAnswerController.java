package com.xzs.exam.controller.admin;

import com.github.pagehelper.PageInfo;
import com.xzs.exam.base.BaseApiController;
import com.xzs.exam.base.RestResponse;
import com.xzs.exam.domain.ExamPaperAnswer;
import com.xzs.exam.domain.Subject;
import com.xzs.exam.domain.User;
import com.xzs.exam.service.ExamPaperAnswerService;
import com.xzs.exam.service.SubjectService;
import com.xzs.exam.service.UserService;
import com.xzs.exam.utility.DateTimeUtil;
import com.xzs.exam.utility.ExamUtil;
import com.xzs.exam.utility.PageInfoHelper;
import com.xzs.exam.viewmodel.admin.paper.ExamPaperAnswerPageRequestVM;
import com.xzs.exam.viewmodel.student.exampaper.ExamPaperAnswerPageResponseVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController("AdminExamPaperAnswerController")   // 试卷答案相关管理
@RequestMapping(value = "/api/admin/examPaperAnswer")   // 路由
public class ExamPaperAnswerController extends BaseApiController {

    private final ExamPaperAnswerService examPaperAnswerService;
    private final SubjectService subjectService;
    private final UserService userService;

    @Autowired
    public ExamPaperAnswerController(ExamPaperAnswerService examPaperAnswerService, SubjectService subjectService, UserService userService) {
        this.examPaperAnswerService = examPaperAnswerService;
        this.subjectService = subjectService;
        this.userService = userService;
    }


    @RequestMapping(value = "/page", method = RequestMethod.POST)   // 分页
    public RestResponse<PageInfo<ExamPaperAnswerPageResponseVM>> pageJudgeList(@RequestBody ExamPaperAnswerPageRequestVM model) {   //
        PageInfo<ExamPaperAnswer> pageInfo = examPaperAnswerService.adminPage(model);
        PageInfo<ExamPaperAnswerPageResponseVM> page = PageInfoHelper.copyMap(pageInfo, e -> {
            ExamPaperAnswerPageResponseVM vm = modelMapper.map(e, ExamPaperAnswerPageResponseVM.class);
            Subject subject = subjectService.selectById(vm.getSubjectId());
            vm.setDoTime(ExamUtil.secondToVM(e.getDoTime()));   // 试卷时长
            vm.setSystemScore(ExamUtil.scoreToVM(e.getSystemScore()));  // 总分
            vm.setUserScore(ExamUtil.scoreToVM(e.getUserScore()));  // 得分
            vm.setPaperScore(ExamUtil.scoreToVM(e.getPaperScore()));    // 分页后的对应分数
            vm.setSubjectName(subject.getName());   // 科目
            vm.setCreateTime(DateTimeUtil.dateFormat(e.getCreateTime()));   // 创建时间
            User user = userService.selectById(e.getCreateUser());
            vm.setUserName(user.getUserName());
            System.out.println("++++");
            return vm;
        });
        return RestResponse.ok(page);
    }


}
