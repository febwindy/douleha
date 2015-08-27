package com.douleha.www.utils.shiro;

import com.douleha.www.domain.model.authority.Authority;
import com.douleha.www.domain.model.role.Role;
import com.douleha.www.domain.model.user.User;
import com.douleha.www.domain.service.user.IUserService;
import com.douleha.www.utils.type.model.Disabled;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by ivan_ on 2015/8/17.
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private IUserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        String username = ((User) principals.getPrimaryPrincipal()).getUsername();
        User user = userService.findByUsername(username);

        if (null == user) {
            throw new UnauthenticatedException();
        }

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(getAllRoles(user));
        authorizationInfo.setStringPermissions(getAllAuthorities(user));

        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        String username = token.getPrincipal().toString();
        User user = userService.findByUsername(username);

        if (null == user) {
            throw new UnknownAccountException();
        }

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user,
                user.getPassword(),
                new SerializableByteSource(user.getSalt()),
                user.getNickname());

        return authenticationInfo;
    }

    private Set<String> getAllRoles(User user) {
        Set<String> roles = new HashSet<String>();
        List<Role> roleList = user.getRoles();
        for (Role role : roleList) {
            if (role.getDisabled() == Disabled.ENABLED) {
                roles.add(role.getRoleName());
            }
        }
        return roles;
    }

    private Set<String> getAllAuthorities(User user) {
        Set<String> authorities = new HashSet<String>();
        List<Role> roleList = user.getRoles();
        for (Role role : roleList) {
            if (role.getDisabled() == Disabled.ENABLED) {
                List<Authority> authorityList = role.getAuthorities();
                for (Authority authority : authorityList) {
                    if (authority.getDisabled() == Disabled.ENABLED) {
                        authorities.add(authority.getAuthorityName());
                    }
                }
            }
        }
        return authorities;
    }

}
