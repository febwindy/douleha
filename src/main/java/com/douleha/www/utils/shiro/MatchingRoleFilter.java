package com.douleha.www.utils.shiro;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.douleha.www.utils.type.api.ApiResponse;
import com.douleha.www.utils.type.api.ApiReturnCode;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.CollectionUtils;
import org.apache.shiro.util.StringUtils;
import org.apache.shiro.web.filter.authz.RolesAuthorizationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.Locale;
import java.util.Set;

/**
 * Created by ivan_ on 2015/8/19.
 */
public class MatchingRoleFilter extends RolesAuthorizationFilter {

    @Autowired
    private MessageSource messageSource;

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

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {

        ApiResponse apiResponse = new ApiResponse(ApiReturnCode.ERROR_10003,
                messageSource.getMessage(ApiReturnCode.ERROR_10003.getName(), null, Locale.SIMPLIFIED_CHINESE));

        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
        httpServletResponse.setHeader("Content-Type", "application/json;charset=UTF-8");
        Writer writer = httpServletResponse.getWriter();

        String content = JSON.toJSONString(apiResponse, SerializerFeature.PrettyFormat, SerializerFeature.WriteDateUseDateFormat);
        writer.write(content);

        return false;
    }
}
