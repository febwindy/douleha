package com.douleha.www.domain.model.user;

import com.douleha.www.persistence.mybatis.repository.general.IRepository;

/**
 * Created by ivan_ on 2015/8/13.
 */
public interface IUserRepository<T, ID> extends IRepository<T, ID> {

    T findByUsername(String username);

}
