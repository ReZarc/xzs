package com.xzs.exam.configuration.spring.security;

import com.xzs.exam.configuration.property.CookieConfig;
import com.xzs.exam.utility.JsonUtil;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;


/**
 * 处理用户验证
 */
public class RestLoginAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
    private final org.slf4j.Logger logger = LoggerFactory.getLogger(RestLoginAuthenticationFilter.class);

    /**
     * 路由重定向
     */
    public RestLoginAuthenticationFilter() {
        super(new AntPathRequestMatcher("/api/user/login", "POST"));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        UsernamePasswordAuthenticationToken authRequest;    //封装用户名和密码
        try (InputStream is = request.getInputStream()) {

            AuthenticationBean authenticationBean = JsonUtil.toJsonObject(is, AuthenticationBean.class);
            //将 is 中 json 数据转为 Authentication 类型的对象
            request.setAttribute(TokenBasedRememberMeServices.DEFAULT_PARAMETER, authenticationBean.isRemember());
            authRequest = new UsernamePasswordAuthenticationToken(authenticationBean.getUserName(), authenticationBean.getPassword());
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            authRequest = new UsernamePasswordAuthenticationToken("", "");
        }
        setDetails(request, authRequest);
        return this.getAuthenticationManager().authenticate(authRequest);

    }

    /**
     * 加载用户信息
     * @param userDetailsService
     */
    void setUserDetailsService(UserDetailsService userDetailsService) {
        RestTokenBasedRememberMeServices tokenBasedRememberMeServices =
                new RestTokenBasedRememberMeServices(CookieConfig.getName(), userDetailsService);
        tokenBasedRememberMeServices.setTokenValiditySeconds(CookieConfig.getInterval());
        setRememberMeServices(tokenBasedRememberMeServices);
    }

    /**
     * 更改用户信息
     * @param request
     * @param authRequest
     */
    private void setDetails(HttpServletRequest request, UsernamePasswordAuthenticationToken authRequest) {
        authRequest.setDetails(authenticationDetailsSource.buildDetails(request));
    }
}
