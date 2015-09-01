package com.douleha.www.application.auth.command;

import com.douleha.www.utils.type.command.AbstractCommand;

/**
 * Created by ivan_ on 2015/8/27.
 */
public class LoginCommand extends AbstractCommand {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
