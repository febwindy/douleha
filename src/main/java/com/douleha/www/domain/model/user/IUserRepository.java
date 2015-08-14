package com.douleha.www.domain.model.user;

import com.douleha.www.persistence.mybatis.repository.general.IRepository;

import java.util.List;

/**
 * Created by ivan_ on 2015/8/13.
 */
public interface IUserRepository<T, ID> extends IRepository<T, ID> {

    List<T> listUserByUsername(String username);

}
