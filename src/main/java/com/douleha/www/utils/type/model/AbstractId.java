package com.douleha.www.utils.type.model;

import java.io.Serializable;

/**
 * Created by ivan_ on 2015/8/28.
 */
public abstract class AbstractId implements Serializable {

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
