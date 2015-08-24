package com.douleha.www.domain.model.role;

import com.douleha.www.application.commons.enumtype.Disabled;
import com.douleha.www.domain.model.authority.Authority;

import java.util.List;

/**
 * Created by ivan_ on 2015/8/14.
 */
public class Role {

    private Integer roleId;
    private String roleName;
    private String description;
    private Integer listOrder;
    private Disabled disabled;

    private List<Authority> authorities;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getListOrder() {
        return listOrder;
    }

    public void setListOrder(Integer listOrder) {
        this.listOrder = listOrder;
    }

    public Disabled getDisabled() {
        return disabled;
    }

    public void setDisabled(Disabled disabled) {
        this.disabled = disabled;
    }

    public List<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }
}
