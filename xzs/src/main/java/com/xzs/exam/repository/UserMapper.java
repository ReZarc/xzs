package com.xzs.exam.repository;

import com.xzs.exam.domain.User;
import com.xzs.exam.domain.other.KeyValue;
import com.xzs.exam.viewmodel.admin.user.UserPageRequestVM;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


@Mapper
public interface UserMapper extends BaseMapper<User> {

    List<User> getAllUser();
    User getUserById(Integer id);
    User getUserByUserName(String username);
    User getUserByUserNamePwd(@Param("username") String username, @Param("pwd") String pwd);
    User getUserByUuid(String uuid);
    List<User> userPageList(Map<String, Object> map);
    Integer userPageCount(Map<String, Object> map);
    List<User> userPage(UserPageRequestVM requestVM);
    void insertUser(User user);
    void insertUsers(List<User> users);
    void updateUser(User user);
    void updateUsersAge(Map<String, Object> map);
    void deleteUsersByIds(List<Integer> ids);
    void insertUserSql(User user);

    Integer selectAllCount();

    List<KeyValue> selectByUserName(String userName);

    List<User> selectByIds(List<Integer> ids);
    User selectByWxOpenId(@Param("wxOpenId") String wxOpenId);

    List<User> selectByMajor(String majorName);
}