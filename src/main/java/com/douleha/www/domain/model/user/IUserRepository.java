package com.douleha.www.domain.model.user;

import com.douleha.www.application.admin.user.command.AdminUserPaginationCommand;
import com.douleha.www.persistence.mybatis.repository.general.IRepository;

import java.util.List;
import java.util.Map;

/**
 * Created by ivan_ on 2015/8/13.
 */
public interface IUserRepository<T, ID> extends IRepository<T, ID> {

    T findByUsername(String username);

    List<T> pagination(Map paramsMap);

}
