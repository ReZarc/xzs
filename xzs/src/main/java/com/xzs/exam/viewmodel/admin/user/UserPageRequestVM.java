package com.xzs.exam.viewmodel.admin.user;

import com.xzs.exam.base.BasePage;


public class UserPageRequestVM extends BasePage {

    private String userName;
    private Integer role;
    private Integer userLevel;
    private String majorName;
    private String className;

    public Integer getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(Integer userLevel) {
        this.userLevel = userLevel;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getMajorName() {
        return majorName;
    }
    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }
    public String className() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
