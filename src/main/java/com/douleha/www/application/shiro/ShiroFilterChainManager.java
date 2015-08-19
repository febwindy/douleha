package com.douleha.www.application.shiro;

import com.douleha.www.application.commons.Disabled;
import com.douleha.www.application.util.DoulehaStringUtils;
import com.douleha.www.domain.model.authority.Authority;
import com.douleha.www.domain.model.menu.Menu;
import com.douleha.www.domain.model.role.Role;
import com.douleha.www.domain.service.authority.IAuthorityService;
import org.apache.shiro.web.filter.mgt.NamedFilterList;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.*;

/**
 * Author: FuChuan <332553703@qq.com>
 * Date: 2015/2/2
 * Time: 20:47
 */
public class ShiroFilterChainManager {

    @Autowired
    private CustomDefaultFilterChainManager filterChainManager;

    @Autowired
    private IAuthorityService authorityService;

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

        List<Authority> authorityList = authorityService.findAll();

        //2、循环URL Filter 注册filter chain
        for (Authority authority : authorityList) {
            String authorityName = authority.getAuthorityName();
            Menu menu = authority.getMenu();
            List<Role> roles = authority.getRoles();
            StringBuilder sb = new StringBuilder();
            for (int i=0; i < roles.size(); i++) {
                if (roles.get(i).getDisabled() == Disabled.ENABLED) {
                    sb.append(roles.get(i).getRoleName());
                    if (i != roles.size() - 1) {
                        sb.append(",");
                    }
                }
            }
            if (!DoulehaStringUtils.isEmpty(sb.toString())) {
                filterChainManager.addToChain(menu.getMenuUrl(), "customRole", sb.toString());
            }
            if (authority.getDisabled() == Disabled.ENABLED) {
                if (!DoulehaStringUtils.isEmpty(authorityName) && null != menu) {
                    filterChainManager.addToChain(menu.getMenuUrl(), "perms", authorityName);
                }
            }
        }
    }

}
