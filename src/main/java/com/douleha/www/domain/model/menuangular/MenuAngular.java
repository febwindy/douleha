package com.douleha.www.domain.model.menuangular;

import com.douleha.www.domain.model.menugroup.MenuGroup;
import com.douleha.www.utils.type.model.AbstractId;

/**
 * Created by ivan_ on 2015/8/28.
 */
public class MenuAngular extends AbstractId {

    private String name;
    private String url;
    private String template_url;
    private String state;
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

    public String getTemplate_url() {
        return template_url;
    }

    public void setTemplate_url(String template_url) {
        this.template_url = template_url;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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
