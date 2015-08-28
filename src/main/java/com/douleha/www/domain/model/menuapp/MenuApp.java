package com.douleha.www.domain.model.menuapp;

import com.douleha.www.domain.model.menugroup.MenuGroup;
import com.douleha.www.utils.type.model.AbstractId;

/**
 * Created by ivan_ on 2015/8/28.
 */
public class MenuApp extends AbstractId {

    private String name;
    private String url;
    private Integer disabled;
    private Integer sort;
    private MenuGroup group;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getDisabled() {
        return disabled;
    }

    public void setDisabled(Integer disabled) {
        this.disabled = disabled;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public MenuGroup getGroup() {
        return group;
    }

    public void setGroup(MenuGroup group) {
        this.group = group;
    }
}
