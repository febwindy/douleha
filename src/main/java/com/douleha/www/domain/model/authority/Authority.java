package com.douleha.www.domain.model.authority;

import com.douleha.www.application.commons.Disabled;
import com.douleha.www.domain.model.menu.Menu;
import com.douleha.www.domain.model.role.Role;

import java.util.List;

/**
 * Created by ivan_ on 2015/8/14.
 */
public class Authority {

    private Integer authorityId;
    private String authorityName;
    private String description;
    private Integer listOrder;
    private Disabled disabled;

    private Menu menu;

    private List<Role> roles;

    public Integer getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(Integer authorityId) {
        this.authorityId = authorityId;
    }

    public String getAuthorityName() {
        return authorityName;
    }

    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName;
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

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
