package com.douleha.www.domain.service.user;

import com.douleha.www.domain.model.user.User;

/**
 * Created by ivan_ on 2015/8/13.
 */
public interface IUserService {

    User findById(int id);

    int save();

}
