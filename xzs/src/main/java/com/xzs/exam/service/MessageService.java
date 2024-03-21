package com.xzs.exam.service;

import com.github.pagehelper.PageInfo;
import com.xzs.exam.domain.Message;
import com.xzs.exam.domain.MessageUser;
import com.xzs.exam.viewmodel.admin.message.MessagePageRequestVM;
import com.xzs.exam.viewmodel.student.user.MessageRequestVM;

import java.util.List;

public interface MessageService {

    List<Message> selectMessageByIds(List<Integer> ids);

    PageInfo<MessageUser> studentPage(MessageRequestVM requestVM);

    PageInfo<Message> page(MessagePageRequestVM requestVM);

    List<MessageUser> selectByMessageIds(List<Integer> ids);

    void sendMessage(Message message, List<MessageUser> messageUsers);

    void read(Integer id);

    Integer unReadCount(Integer userId);

    Message messageDetail(Integer id);
}
