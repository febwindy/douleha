package com.douleha.www.domain.model.menutype;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by ivan_ on 2015/8/14.
 */
public class MenuType implements Serializable {

    private Integer typeId;
    private String typeName;
    private Integer listOrder;
    private Date createdTime;
    private String remark;

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
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
}
