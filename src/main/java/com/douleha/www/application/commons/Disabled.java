package com.douleha.www.application.commons;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ivan_ on 2015/8/17.
 */
public enum Disabled {

    ALL("全部", 0, true),
    ENABLED("启用", 1, false),
    DISABLED("禁用", 2, false);

    private String name;
    private int value;
    private boolean onlyQuery;

     Disabled(String name, int value, boolean onlyQuery) {
         this.name = name;
         this.value = value;
         this.onlyQuery = onlyQuery;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public boolean isOnlyQuery() {
        return onlyQuery;
    }

    private static Map<Integer, Disabled> CACHE = new HashMap<Integer, Disabled>(Disabled.values().length * 2);
    static {
        for (Disabled disabled : Disabled.values()) {
            CACHE.put(disabled.getValue(), disabled);
        }
    }
}
