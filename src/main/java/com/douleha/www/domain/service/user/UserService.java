package com.douleha.www.domain.service.user;

import com.douleha.www.application.admin.user.command.AdminUserCommand;
import com.douleha.www.application.admin.user.command.AdminUserPaginationCommand;
import com.douleha.www.controller.exception.NotFoundException;
import com.douleha.www.domain.model.user.IUserRepository;
import com.douleha.www.domain.model.user.User;
import com.douleha.www.utils.type.api.SqlOperator;
import com.douleha.www.utils.type.model.Sex;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by ivan_ on 2015/8/13.
 */
@Service("userService")
public class UserService implements IUserService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private IUserRepository userRepository;

    @Override
    public void add(AdminUserCommand command) {

        logger.info("创建用户");

        String salt = UUID.randomUUID().toString().replaceAll("-", "");
        String password = new Md5Hash(command.getPassword(), salt).toString();

        Sex sex = null;
        if (!StringUtils.isEmpty(command.getSex())) {
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

        userRepository.add(user);
    }

    @Override
    public void delete(Integer id) {

        logger.info("删除用户, id=[{}]", id);

        if (0 == userRepository.delete(id)) {
            throw new NotFoundException("用户id=[" + id + "]的记录不存在");
        }

    }

    @Override
    public void update(AdminUserCommand command) {

        logger.info("更新用户, id=[{}]", command.getId());

        Sex sex = null;
        if (!StringUtils.isEmpty(command.getSex())) {
            sex = Sex.valueOf(command.getSex());
        }

        User user = this.findById(command.getId());
        user.setNickname(command.getNickname());
        user.setRealName(command.getRealName());
        user.setSex(sex);
        user.setLastLoginIp(command.getLastLoginIp());
        user.setLastLoginTime(command.getLastLoginTime());
        user.setRemark(command.getRemark());

        if (!StringUtils.isEmpty(command.getPassword())) {

            logger.info("更新用户密码");

            String salt = UUID.randomUUID().toString().replaceAll("-", "");
            String password = new Md5Hash(command.getPassword(), salt).toString();

            user.setPassword(password);
            user.setSalt(salt);
        } else {
            user.setPassword(null);
            user.setSalt(null);
        }

        userRepository.update(user);
    }

    @Override
    public List<User> pagination(AdminUserPaginationCommand command) {

        int limitPage = (command.getPage() - 1) * command.getPageSize();
        int limitPageSize = command.getPageSize() * command.getPage();

        Map<String, Object> paramsMap = new HashMap<String, Object>();

        if (null != command.getSex() && !StringUtils.isEmpty(command.getSex())) {
            paramsMap.put("sex", Sex.valueOf(command.getSex()).getValue());
        }
        if (null != command.getUsername() && !StringUtils.isEmpty(command.getUsername())) {
            paramsMap.put("username",
                    SqlOperator.like(command.getUsername(), SqlOperator.Like.ANYWHERE));
        }
        if (null != command.getNickname() && !StringUtils.isEmpty(command.getNickname())) {
            paramsMap.put("nickname",
                    SqlOperator.like(command.getNickname(), SqlOperator.Like.ANYWHERE));
        }

        paramsMap.put("page", limitPage);
        paramsMap.put("pageSize", limitPageSize);

        return userRepository.pagination(paramsMap);
    }

    @Override
    public User findById(int id) {
        User user = (User) userRepository.findById(id);
        if (null == user) {
            throw new NotFoundException("用户id=[" + id + "]的记录不存在");
        }
        return user;
    }

    @Override
    public User findByUsername(String username) {
        return (User) userRepository.findByUsername(username);
    }

}
