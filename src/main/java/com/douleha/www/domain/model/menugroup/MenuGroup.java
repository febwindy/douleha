package com.douleha.www.domain.model.menugroup;

import com.douleha.www.domain.model.menutype.MenuType;
import com.douleha.www.utils.type.model.AbstractId;

/**
 * Created by ivan_ on 2015/8/28.
 */
public class MenuGroup extends AbstractId {

    private String name;
    private Integer disabled;
    private Integer sort;
    private MenuType type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public MenuType getType() {
        return type;
    }

    public void setType(MenuType type) {
        this.type = type;
    }
}
