package com.xzs.exam.configuration.spring.security;

public class AuthenticationBean {
    private String userName;
    private String password;
    private boolean remember;

    /**
     * @return userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the boolean
     */
    public boolean isRemember() {
        return remember;
    }

    /**
     * @param remember 记住用户
     */
    public void setRemember(boolean remember) {
        this.remember = remember;
    }

}
