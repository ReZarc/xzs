package com.xzs.exam.configuration.spring.security;

import com.xzs.exam.domain.enums.RoleEnum;
import com.xzs.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * 获取用户详细信息组件
 */
@Component
public class RestDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;

    /**
     * REST的实例化
     * @param userService the user service
     */
    @Autowired
    public RestDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    /**
     * 封装用户信息
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        com.xzs.exam.domain.User user = userService.getUserByUserName(username);

        if (user == null) {
            throw new UsernameNotFoundException("Username not found.");
        }

        ArrayList<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(RoleEnum.fromCode(user.getRole()).getRoleName()));

        return new User(user.getUserName(), user.getPassword(), grantedAuthorities);
    }
}
