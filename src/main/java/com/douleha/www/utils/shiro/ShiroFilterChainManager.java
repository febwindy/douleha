package com.douleha.www.utils.shiro;

import com.douleha.www.domain.model.permission.Permission;
import com.douleha.www.domain.model.role.Role;
import com.douleha.www.domain.model.url.Url;
import com.douleha.www.domain.service.permission.IPermissionService;
import com.douleha.www.utils.type.model.Disabled;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.web.filter.mgt.NamedFilterList;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ivan_ on 2015/8/18.
 */
public class ShiroFilterChainManager {

    @Autowired
    private CustomDefaultFilterChainManager filterChainManager;

    @Autowired
    private IPermissionService authorityService;

    private Map<String, NamedFilterList> defaultFilterChains;

    @PostConstruct
    public void init() {
        defaultFilterChains = new HashMap<String, NamedFilterList>(filterChainManager.getFilterChains());
        initFilterChains();
    }

    public void initFilterChains() {
        //1、首先删除以前老的filter chain并注册默认的
        filterChainManager.getFilterChains().clear();
        if (defaultFilterChains != null) {
            filterChainManager.getFilterChains().putAll(defaultFilterChains);
        }

        List<Permission> permissionList = authorityService.findAll();

        //2、循环URL Filter 注册filter chain
        for (Permission permission : permissionList) {
            String permissionName = permission.getName();
            Url url = permission.getUrl();
            List<Role> roles = permission.getRoles();
            StringBuilder sb = new StringBuilder();
            for (int i=0; i < roles.size(); i++) {
                if (roles.get(i).getDisabled() == Disabled.ENABLED) {
                    sb.append(roles.get(i).getName());
                    if (i != roles.size() - 1) {
                        sb.append(",");
                    }
                }
            }
            if (!StringUtils.isEmpty(sb.toString())) {
                filterChainManager.addToChain(url.getName(), "customRole", sb.toString());
            }
            if (permission.getDisabled() == Disabled.ENABLED) {
                if (!StringUtils.isEmpty(permissionName) && null != url) {
                    filterChainManager.addToChain(url.getName(), "perms", permissionName);
                }
            }
        }
    }

}
