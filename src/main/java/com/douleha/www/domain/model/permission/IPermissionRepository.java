package com.douleha.www.domain.model.permission;

import com.douleha.www.persistence.mybatis.repository.general.IRepository;

import java.util.List;
import java.util.Map;

/**
 * Created by ivan_ on 2015/8/14.
 */
public interface IPermissionRepository<T, ID> extends IRepository<T, ID> {

    List<T> pagination(Map paramsMap);

}
