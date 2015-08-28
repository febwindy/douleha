package com.douleha.www.domain.service.authority;

import com.douleha.www.domain.model.permission.Permission;

import java.util.List;

/**
 * Created by ivan_ on 2015/8/14.
 */
public interface IAuthorityService {

    List<Permission> findAll();

}
