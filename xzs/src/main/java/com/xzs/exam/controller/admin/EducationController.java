package com.xzs.exam.controller.admin;


import com.github.pagehelper.PageInfo;
import com.xzs.exam.base.BaseApiController;
import com.xzs.exam.base.RestResponse;
import com.xzs.exam.domain.Subject;
import com.xzs.exam.service.SubjectService;
import com.xzs.exam.utility.PageInfoHelper;
import com.xzs.exam.viewmodel.admin.education.SubjectEditRequestVM;
import com.xzs.exam.viewmodel.admin.education.SubjectPageRequestVM;
import com.xzs.exam.viewmodel.admin.education.SubjectResponseVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController("AdminEducationController")     //科目管理
@RequestMapping(value = "/api/admin/education")     //路由
public class EducationController extends BaseApiController {
    private final SubjectService subjectService;
    @Autowired
    public EducationController(SubjectService subjectService) {     // 初始化 Education
        this.subjectService = subjectService;
    }

    @RequestMapping(value = "/subject/list", method = RequestMethod.POST)   // 响应前端请求
    public RestResponse<List<Subject>> list() {
        List<Subject> subjects = subjectService.allSubject();
        return RestResponse.ok(subjects);
    }

    @RequestMapping(value = "/subject/page", method = RequestMethod.POST)   // 分页查询科目信息
    public RestResponse<PageInfo<SubjectResponseVM>> pageList(@RequestBody SubjectPageRequestVM model) {
        PageInfo<Subject> pageInfo = subjectService.page(model);
        PageInfo<SubjectResponseVM> page = PageInfoHelper.copyMap(pageInfo, e -> modelMapper.map(e, SubjectResponseVM.class));
        return RestResponse.ok(page);
    }

    @RequestMapping(value = "/subject/edit", method = RequestMethod.POST)   // 编辑或新增一个科目
    public RestResponse edit(@RequestBody @Valid SubjectEditRequestVM model) {
        Subject subject = modelMapper.map(model, Subject.class);
        if (model.getId() == null) {        // 如果没有对应id则说明是添加科目
            subject.setDeleted(false);
            subjectService.insertByFilter(subject);
        } else {
            subjectService.updateByIdFilter(subject);
        }
        return RestResponse.ok();
    }

    @RequestMapping(value = "/subject/select/{id}", method = RequestMethod.POST)    // 查找对应科目
    public RestResponse<SubjectEditRequestVM> select(@PathVariable Integer id) {
        Subject subject = subjectService.selectById(id);
        SubjectEditRequestVM vm = modelMapper.map(subject, SubjectEditRequestVM.class);
        return RestResponse.ok(vm);
    }

    @RequestMapping(value = "/subject/delete/{id}", method = RequestMethod.POST)    //删除对应科目
    public RestResponse delete(@PathVariable Integer id) {
        Subject subject = subjectService.selectById(id);
        subject.setDeleted(true);
        subjectService.updateByIdFilter(subject);
        return RestResponse.ok();
    }
}
