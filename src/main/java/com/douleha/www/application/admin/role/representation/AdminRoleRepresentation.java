package com.douleha.www.application.admin.role.representation;

import com.douleha.www.utils.type.model.Disabled;

/**
 * Created by ivan_ on 2015/9/2.
 */
public class AdminRoleRepresentation {

    private Integer id;
    private String name;
    private String description;
    private Disabled disabled;
    private Integer sort;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}
