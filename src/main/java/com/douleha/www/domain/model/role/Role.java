package com.douleha.www.domain.model.role;

import com.douleha.www.domain.model.permission.Permission;
import com.douleha.www.utils.type.model.AbstractId;
import com.douleha.www.utils.type.model.Disabled;

import java.util.List;

/**
 * Created by ivan_ on 2015/8/14.
 */
public class Role extends AbstractId {

    private String name;
    private String description;
    private Disabled disabled;
    private Integer sort;
    private List<Permission> permissions;

    protected Role() {
        super();
    }

    public Role(String name, String description, Disabled disabled, Integer sort) {
        this();
        this.name = name;
        this.description = description;
        this.disabled = disabled;
        this.sort = sort;
    }

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

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}
