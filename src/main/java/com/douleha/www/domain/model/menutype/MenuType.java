package com.douleha.www.domain.model.menutype;

import com.douleha.www.utils.type.model.AbstractId;

/**
 * Created by ivan_ on 2015/8/28.
 */
public class MenuType extends AbstractId {

    private String name;
    private String description;

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
}
