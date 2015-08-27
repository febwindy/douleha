package com.douleha.www.domain.model.menu;

import com.douleha.www.domain.model.authority.Authority;
import com.douleha.www.domain.model.menutype.MenuType;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by ivan_ on 2015/8/14.
 */
public class Menu implements Serializable {

    private Integer menuId;
    private MenuType menuType;
    private String menuName;
    private String menuUrl;
    private Integer listOrder;
    private Date createdTime;
    private String remark;

    private Authority authority;

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public MenuType getMenuType() {
        return menuType;
    }

    public void setMenuType(MenuType menuType) {
        this.menuType = menuType;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public Integer getListOrder() {
        return listOrder;
    }

    public void setListOrder(Integer listOrder) {
        this.listOrder = listOrder;
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

    public Authority getAuthority() {
        return authority;
    }

    public void setAuthority(Authority authority) {
        this.authority = authority;
    }
}
