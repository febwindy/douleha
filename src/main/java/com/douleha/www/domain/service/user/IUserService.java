package com.douleha.www.domain.service.user;

import com.douleha.www.application.admin.user.command.AdminUserCommand;
import com.douleha.www.domain.model.user.User;

/**
 * Created by ivan_ on 2015/8/13.
 */
public interface IUserService {

    int add(AdminUserCommand command);

    int delete(Integer id);

    int update(AdminUserCommand command);

    User findById(int id);

    User findByUsername(String username);

}
