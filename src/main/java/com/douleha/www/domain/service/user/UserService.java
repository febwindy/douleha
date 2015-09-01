package com.douleha.www.domain.service.user;

import com.douleha.www.application.admin.user.command.AdminUserCommand;
import com.douleha.www.application.admin.user.command.AdminUserPaginationCommand;
import com.douleha.www.domain.model.user.IUserRepository;
import com.douleha.www.domain.model.user.User;
import com.douleha.www.utils.type.model.Sex;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
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

        Sex sex = null;
        if (null != command.getSex() && !StringUtils.isEmpty(command.getSex())) {
            sex = Sex.valueOf(command.getSex());
        }

        User user = new User(
                command.getUsername(),
                password,
                command.getNickname(),
                command.getRealName(),
                salt,
                sex,
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

        Sex sex = null;
        if (null != command.getSex() && !StringUtils.isEmpty(command.getSex())) {
            sex = Sex.valueOf(command.getSex());
        }

        User user = this.findById(command.getId());
        user.setNickname(command.getNickname());
        user.setRealName(command.getRealName());
        user.setSex(sex);
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
    public List<User> pagination(AdminUserPaginationCommand command) {
        return userRepository.pagination(command);
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
