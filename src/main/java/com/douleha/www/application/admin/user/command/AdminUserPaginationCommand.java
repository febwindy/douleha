package com.douleha.www.application.admin.user.command;

import com.douleha.www.utils.type.command.PaginationCommand;

/**
 * Created by ivan_ on 2015/9/1.
 */
public class AdminUserPaginationCommand extends PaginationCommand {

    private String username;
    private String nickname;
    private String sex;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
