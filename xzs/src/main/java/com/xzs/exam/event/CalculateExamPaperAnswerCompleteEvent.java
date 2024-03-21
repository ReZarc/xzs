package com.xzs.exam.event;

import com.xzs.exam.domain.ExamPaperAnswerInfo;
import org.springframework.context.ApplicationEvent;

public class CalculateExamPaperAnswerCompleteEvent extends ApplicationEvent {


    private final ExamPaperAnswerInfo examPaperAnswerInfo;


    /**
     * Instantiates a new Calculate exam paper answer complete event.
     *
     * @param examPaperAnswerInfo the exam paper answer info
     */
    public CalculateExamPaperAnswerCompleteEvent(final ExamPaperAnswerInfo examPaperAnswerInfo) {
        super(examPaperAnswerInfo);
        this.examPaperAnswerInfo = examPaperAnswerInfo;
    }

    /**
     * 试卷回答详情
     *
     * @return the exam paper answer info
     */
    public ExamPaperAnswerInfo getExamPaperAnswerInfo() {
        return examPaperAnswerInfo;
    }

}
