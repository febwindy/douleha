package com.douleha.www.persistence.mybatis.repository;

import com.douleha.www.application.admin.user.command.AdminUserPaginationCommand;
import com.douleha.www.domain.model.user.IUserRepository;
import com.douleha.www.persistence.mybatis.mapper.IMapper;
import com.douleha.www.persistence.mybatis.mapper.IUserMapper;
import com.douleha.www.persistence.mybatis.repository.general.AbstractRepository;
import com.douleha.www.utils.type.api.SqlOperator;
import com.douleha.www.utils.type.model.Sex;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ivan_ on 2015/8/13.
 */
@Repository("userRepository")
public class UserRepository<User, Integer> extends AbstractRepository<User, Integer> implements IUserRepository<User, Integer> {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    protected IMapper getMapper() {
        return sqlSessionTemplate.getMapper(IUserMapper.class);
    }

    @Override
    public User findByUsername(String username) {
        return (User) ((IUserMapper)getMapper()).findByUsername(username);
    }

    @Override
    public List<User> pagination(AdminUserPaginationCommand command) {

        int limitPage = (command.getPage() - 1) * command.getPageSize();
        int limitPageSize = command.getPageSize() * command.getPage();

        Map<String, Object> paramsMap = new HashMap<String, Object>();

        if (null != command.getSex() && !StringUtils.isEmpty(command.getSex())) {
            paramsMap.put("sex", Sex.valueOf(command.getSex()));
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

        return ((IUserMapper)getMapper()).pagination(paramsMap);
    }
}
