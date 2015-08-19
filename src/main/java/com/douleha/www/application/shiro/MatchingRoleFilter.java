package com.douleha.www.application.shiro;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.CollectionUtils;
import org.apache.shiro.web.filter.authz.RolesAuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.Set;

/**
 * Created by ivan_ on 2015/8/19.
 */
public class MatchingRoleFilter extends RolesAuthorizationFilter {

    @Override
    public boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws IOException {

        boolean isHasRole = false;
        Subject subject = getSubject(request, response);
        String[] rolesArray = (String[]) mappedValue;

        if (rolesArray == null || rolesArray.length == 0) {
            //no roles specified, so nothing to check - allow access.
            return true;
        }

        Set<String> roles = CollectionUtils.asSet(rolesArray);
        for (String roleStr : roles) {
            if (subject.hasRole(roleStr)) {
                isHasRole = true;
                break;
            }
        }

        return isHasRole;
    }

//    @Override
//    public boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
//
//        String[] roles = (String[])mappedValue;
//
//        List<Authority> authorities = authorityService.findAll();
//        Subject subject = getSubject(request, response);
//
//        if (!subject.isAuthenticated()) {
//            onAccessDenied(request, response);
//        }
//        List<String> list = new ArrayList<String>();
//        for (Authority authority : authorities) {
//            for (Role role : authority.getRoles()) {
//                list.add(role.getRoleName());
//            }
//        }
//        boolean[] booleans = subject.hasRoles(list);
//
//        return super.onPreHandle(request, response, mappedValue);
//    }

}
