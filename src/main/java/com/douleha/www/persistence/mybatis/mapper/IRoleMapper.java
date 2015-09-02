package com.douleha.www.persistence.mybatis.mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by ivan_ on 2015/8/14.
 */
public interface IRoleMapper<Role, Integer> extends IMapper<Role, Integer> {

    List<Role> pagination(Map<String, Object> params);

}
