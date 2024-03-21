package com.xzs.exam.configuration.spring.security;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;

import javax.servlet.http.HttpServletRequest;


/**
 * 记住我，Cookie
 */
public class RestTokenBasedRememberMeServices extends TokenBasedRememberMeServices {
    /**
     * 基于 Token 的记住我功能
     * @param key
     * @param userDetailsService
     */
    public RestTokenBasedRememberMeServices(String key, UserDetailsService userDetailsService) {
        super(key, userDetailsService);
    }

    @Override
    protected boolean rememberMeRequested(HttpServletRequest request, String parameter) {
        return (boolean) request.getAttribute(DEFAULT_PARAMETER);
    }

}
