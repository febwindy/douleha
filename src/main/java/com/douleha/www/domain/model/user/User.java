package com.douleha.www.domain.model.user;

import com.douleha.www.domain.model.role.Role;
import com.douleha.www.utils.type.model.AbstractId;
import com.douleha.www.utils.type.model.Sex;

import java.util.Date;
import java.util.List;

/**
 * Created by ivan_ on 2015/8/14.
 */
public class User extends AbstractId {

    private String username;
    private String password;
    private String nickname;
    private String realName;
    private String salt;
    private Sex sex;
    private String lastLoginIp;
    private Date lastLoginTime;
    private Date createdTime;
    private String remark;

    private List<Role> roles;

    public User() {
        super();
    }

    public User(String username, String password, String nickname, String realName, String salt, Sex sex, String lastLoginIp, Date lastLoginTime, Date createdTime, String remark) {
        this();
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.realName = realName;
        this.salt = salt;
        this.sex = sex;
        this.lastLoginIp = lastLoginIp;
        this.lastLoginTime = lastLoginTime;
        this.createdTime = createdTime;
        this.remark = remark;
    }

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

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
