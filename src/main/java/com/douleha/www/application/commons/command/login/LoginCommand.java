package com.douleha.www.application.commons.command.login;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;

/**
 * Created by ivan_ on 2015/8/21.
 */
public class LoginCommand {

    @NotBlank(message = "LoginCommand.username.NotBlank")
    @Pattern(regexp = "^(13\\d|14[57]|15[^4,\\D]|17[678]|18\\d|170)\\d{8}$", message="LoginCommand.username.Format.error")
    private String username;

    @NotBlank(message = "LoginCommand.password.NotBlank")
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
