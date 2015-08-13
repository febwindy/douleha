package com.douleha.www.domain.service.user;

import com.douleha.www.domain.model.User;
import com.douleha.www.persistence.mybatis.repository.user.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ivan_ on 2015/8/13.
 */
@Service("userService")
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public User findById(int id) {
        return (User) userRepository.findById(id);
    }

    @Override
    public int save() {
        User user = new User();
        user.setId(222);
        user.setName("bbb");
        user.setAge(12);
        return userRepository.save(user);
    }
}
