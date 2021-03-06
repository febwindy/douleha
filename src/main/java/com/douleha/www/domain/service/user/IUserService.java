package com.douleha.www.domain.service.user;

import com.douleha.www.application.admin.user.command.AdminUserCommand;
import com.douleha.www.application.admin.user.command.AdminUserPaginationCommand;
import com.douleha.www.domain.model.user.User;

import java.util.List;

/**
 * Created by ivan_ on 2015/8/13.
 */
public interface IUserService {

    void add(AdminUserCommand command);

    void delete(Integer id);

    void update(AdminUserCommand command);

    List<User> pagination(AdminUserPaginationCommand command);

    User findById(int id);

    User findByUsername(String username);

}
