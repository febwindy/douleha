package com.douleha.www.utils.type.model;

/**
 * Created by ivan_ on 2015/8/31.
 */
public enum  Sex {

    MALE("男", 0),
    FEMALE("女", 1),
    PRIVACY("保密", 2);

    Sex(String name, int value) {
        this.name = name;
        this.value = value;
    }

    private String name;
    private int value;

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }
}
