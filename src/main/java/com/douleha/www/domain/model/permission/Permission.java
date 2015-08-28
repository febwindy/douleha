package com.douleha.www.domain.model.permission;

import com.douleha.www.domain.model.role.Role;
import com.douleha.www.domain.model.url.Url;
import com.douleha.www.utils.type.model.AbstractId;
import com.douleha.www.utils.type.model.Disabled;

import java.util.List;

/**
 * Created by ivan_ on 2015/8/14.
 */
public class Permission extends AbstractId {

    private String name;
    private String description;
    private Disabled disabled;
    private Integer sort;
    private List<Role> roles;
    private Url url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Disabled getDisabled() {
        return disabled;
    }

    public void setDisabled(Disabled disabled) {
        this.disabled = disabled;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Url getUrl() {
        return url;
    }

    public void setUrl(Url url) {
        this.url = url;
    }
}
