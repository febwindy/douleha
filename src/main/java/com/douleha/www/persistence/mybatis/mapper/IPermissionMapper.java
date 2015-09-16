package com.douleha.www.persistence.mybatis.mapper;

import com.douleha.www.domain.model.permission.Permission;

import java.util.List;
import java.util.Map;

/**
 * Created by ivan_ on 2015/8/14.
 */
public interface IPermissionMapper<Authority, Integer> extends IMapper<Authority, Integer> {

    List<Permission> pagination(Map<String, Object> params);

}
