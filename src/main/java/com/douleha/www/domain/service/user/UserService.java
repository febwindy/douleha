package com.douleha.www.domain.service.user;

import com.douleha.www.application.admin.user.command.AdminUserCommand;
import com.douleha.www.domain.model.user.IUserRepository;
import com.douleha.www.domain.model.user.User;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * Created by ivan_ on 2015/8/13.
 */
@Service("userService")
public class UserService implements IUserService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private IUserRepository userRepository;

    @Override
    public int add(AdminUserCommand command) {

        logger.info("创建用户");

        String salt = UUID.randomUUID().toString().replaceAll("-", "");
        String password = new Md5Hash(command.getPassword(), salt).toString();

        User user = new User(
                command.getUsername(),
                password,
                command.getNickname(),
                command.getRealName(),
                salt,
                command.getSex(),
                null,
                null,
                new Date(),
                command.getRemark()
        );

        return userRepository.add(user);
    }

    @Override
    public int delete(Integer id) {

        logger.info("删除用户");

        return userRepository.delete(id);
    }

    @Override
    public int update(AdminUserCommand command) {

        logger.info("更新用户");

        User user = this.findById(command.getId());
        user.setNickname(command.getNickname());
        user.setRealName(command.getRealName());
        user.setSex(command.getSex());
        user.setLastLoginIp(command.getLastLoginIp());
        user.setLastLoginTime(command.getLastLoginTime());
        user.setRemark(command.getRemark());

        if (null != command.getPassword() && !StringUtils.isEmpty(command.getPassword())) {

            logger.info("更新用户密码");

            String salt = UUID.randomUUID().toString().replaceAll("-", "");
            String password = new Md5Hash(command.getPassword(), salt).toString();

            user.setPassword(password);
            user.setSalt(salt);
        } else {
            user.setPassword(null);
            user.setSalt(null);
        }

        return userRepository.update(user);
    }

    @Override
    public User findById(int id) {
        return (User) userRepository.findById(id);
    }

    @Override
    public User findByUsername(String username) {
        return (User) userRepository.findByUsername(username);
    }

}
