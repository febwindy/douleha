package com.douleha.www.domain.model.url;

import com.douleha.www.utils.type.model.AbstractId;
import com.douleha.www.utils.type.model.Disabled;

/**
 * Created by ivan_ on 2015/8/28.
 */
public class Url extends AbstractId {

    private String name;
    private String description;
    private Disabled disabled;
    private Integer sort;

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
