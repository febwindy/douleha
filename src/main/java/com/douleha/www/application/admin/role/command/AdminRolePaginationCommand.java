package com.douleha.www.application.admin.role.command;

import com.douleha.www.utils.type.command.PaginationCommand;

/**
 * Created by ivan_ on 2015/9/2.
 */
public class AdminRolePaginationCommand extends PaginationCommand {

    private String name;
    private String disabled;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisabled() {
        return disabled;
    }

    public void setDisabled(String disabled) {
        this.disabled = disabled;
    }
}
