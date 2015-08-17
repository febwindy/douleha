package com.douleha.www.domain.service.user;

import com.douleha.www.domain.model.user.IUserRepository;
import com.douleha.www.domain.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public User findByUsername(String username) {
        return (User) userRepository.findByUsername(username);
    }

    @Override
    public int insert(User user) {
        return userRepository.save(user);
    }
}
