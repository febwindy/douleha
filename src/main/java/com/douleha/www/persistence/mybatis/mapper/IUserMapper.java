package com.douleha.www.persistence.mybatis.mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by ivan_ on 2015/8/13.
 */
public interface IUserMapper<User, Integer> extends IMapper<User, Integer> {

    User findByUsername(String username);

    List<User> pagination(Map<String, Object> params);

}
