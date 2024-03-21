package com.xzs.exam.configuration.spring.security;

import com.xzs.exam.base.SystemCode;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public final class LoginAuthenticationEntryPoint extends LoginUrlAuthenticationEntryPoint {

    /**
     * 登录验证路由
     */
    public LoginAuthenticationEntryPoint() {
        super("/api/user/login");
    }

    /**
     * 重写commence
     * 返回未授权的响应
     * @param request 获取客户端请求的参数
     * @param response 给客户端响应信息
     * @param authException
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {
        RestUtil.response(response, SystemCode.UNAUTHORIZED);
    }

}
