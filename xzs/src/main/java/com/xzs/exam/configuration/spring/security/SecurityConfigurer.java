package com.xzs.exam.configuration.spring.security;

import com.xzs.exam.configuration.property.CookieConfig;
import com.xzs.exam.configuration.property.SystemConfig;
import com.xzs.exam.domain.enums.RoleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Collections;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfigurer {
    /**
     * 表单登录配置
     */
    @Configuration
    public static class FormLoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
        private final SystemConfig systemConfig;    // 系统配置
        private final LoginAuthenticationEntryPoint restAuthenticationEntryPoint;   // 登录验证入口
        private final RestAuthenticationProvider restAuthenticationProvider;    // 登录验证
        private final RestDetailsServiceImpl formDetailsService;    // 表单信息详情
        private final RestAuthenticationSuccessHandler restAuthenticationSuccessHandler;    // 认证成功
        private final RestAuthenticationFailureHandler restAuthenticationFailureHandler;    // 认证失败
        private final RestLogoutSuccessHandler restLogoutSuccessHandler;    // 登出成功处理
        private final RestAccessDeniedHandler restAccessDeniedHandler;  // 访问拒绝处理
        // 初始化表单
        @Autowired
        public FormLoginWebSecurityConfigurerAdapter(SystemConfig systemConfig,
                                                     LoginAuthenticationEntryPoint restAuthenticationEntryPoint,
                                                     RestAuthenticationProvider restAuthenticationProvider,
                                                     RestDetailsServiceImpl formDetailsService,
                                                     RestAuthenticationSuccessHandler restAuthenticationSuccessHandler,
                                                     RestAuthenticationFailureHandler restAuthenticationFailureHandler,
                                                     RestLogoutSuccessHandler restLogoutSuccessHandler,
                                                     RestAccessDeniedHandler restAccessDeniedHandler) {
            this.systemConfig = systemConfig;
            this.restAuthenticationEntryPoint = restAuthenticationEntryPoint;
            this.restAuthenticationProvider = restAuthenticationProvider;
            this.formDetailsService = formDetailsService;
            this.restAuthenticationSuccessHandler = restAuthenticationSuccessHandler;
            this.restAuthenticationFailureHandler = restAuthenticationFailureHandler;
            this.restLogoutSuccessHandler = restLogoutSuccessHandler;
            this.restAccessDeniedHandler = restAccessDeniedHandler;
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.headers().frameOptions().disable();    //禁用frameOptions，允许嵌入页面

            List<String> securityIgnoreUrls = systemConfig.getSecurityIgnoreUrls(); //  获取不需要进行检查的url
            String[] ignores = new String[securityIgnoreUrls.size()];
            http
                    .addFilterAt(authenticationFilter(), UsernamePasswordAuthenticationFilter.class)    //处理登录验证
                    .exceptionHandling().authenticationEntryPoint(restAuthenticationEntryPoint) //  验证失败入口
                    .and().authenticationProvider(restAuthenticationProvider)   //  验证成功
                    .authorizeRequests()    //控制不同url所需不同权限
                    .antMatchers(securityIgnoreUrls.toArray(ignores)).permitAll()
                    .antMatchers("/api/admin/**").hasRole(RoleEnum.ADMIN.getName())
                    .antMatchers("/api/student/**").hasRole(RoleEnum.STUDENT.getName())
                    .anyRequest().permitAll()
                    .and().exceptionHandling().accessDeniedHandler(restAccessDeniedHandler) // 访问被拒绝处理
                    .and().formLogin().successHandler(restAuthenticationSuccessHandler).failureHandler(restAuthenticationFailureHandler)    // 登录处理
                    .and().logout().logoutUrl("/api/user/logout").logoutSuccessHandler(restLogoutSuccessHandler).invalidateHttpSession(true)    // 设置注销相关
                    .and().rememberMe().key(CookieConfig.getName()).tokenValiditySeconds(CookieConfig.getInterval()).userDetailsService(formDetailsService) // 自动登录
                    .and().csrf().disable() // 不启用跨站请求伪造的防护
                    .cors();    // 跨域资源共享
        }

        /**
         * 设置 CORS 的配置
         * @return
         */
        @Bean
        public CorsConfigurationSource corsConfigurationSource() {
            final CorsConfiguration configuration = new CorsConfiguration();
            configuration.setMaxAge(3600L); // CORS 预检请求的有效期
            configuration.setAllowedOrigins(Collections.singletonList("*"));    // 允许任何来源的请求
            configuration.setAllowedMethods(Collections.singletonList("*"));    // 允许任何方法的请求
            configuration.setAllowCredentials(true);                            // 允许请求携带 cookie
            configuration.setAllowedHeaders(Collections.singletonList("*"));    // 允许任何头部的请求
            final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();    // 注册 CORS 的配置源
            source.registerCorsConfiguration("/api/**", configuration);   // 进行 CORS 配置的 URL 模式
            return source;
        }

        /**
         * 自定义用户的登录认证过滤器
         */
        @Bean
        public RestLoginAuthenticationFilter authenticationFilter() throws Exception {
            RestLoginAuthenticationFilter authenticationFilter = new RestLoginAuthenticationFilter();
            authenticationFilter.setAuthenticationSuccessHandler(restAuthenticationSuccessHandler);
            authenticationFilter.setAuthenticationFailureHandler(restAuthenticationFailureHandler);
            authenticationFilter.setAuthenticationManager(authenticationManagerBean());
            authenticationFilter.setUserDetailsService(formDetailsService);
            return authenticationFilter;
        }


    }
}
