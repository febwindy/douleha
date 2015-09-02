package com.douleha.www.domain.model.role;

import com.douleha.www.persistence.mybatis.repository.general.IRepository;

import java.util.List;
import java.util.Map;

/**
 * Created by ivan_ on 2015/8/14.
 */
public interface IRoleRepository<T, ID> extends IRepository<T, ID> {

    List<Role> pagination(Map paramsMap);

}
