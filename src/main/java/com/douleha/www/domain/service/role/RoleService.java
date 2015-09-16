package com.douleha.www.domain.service.role;

import com.douleha.www.application.admin.role.command.AdminRoleCommand;
import com.douleha.www.application.admin.role.command.AdminRolePaginationCommand;
import com.douleha.www.controller.exception.NotFoundException;
import com.douleha.www.domain.model.role.IRoleRepository;
import com.douleha.www.domain.model.role.Role;
import com.douleha.www.utils.type.api.ApiResponse;
import com.douleha.www.utils.type.api.ApiReturnCode;
import com.douleha.www.utils.type.api.SqlOperator;
import com.douleha.www.utils.type.model.Disabled;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ivan_ on 2015/8/14.
 */
@Service("roleService")
public class RoleService implements IRoleService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private IRoleRepository roleRepository;

    @Override
    public void add(AdminRoleCommand command) {

        logger.info("创建角色");

        Disabled disabled = null;
        if (!StringUtils.isEmpty(command.getDisabled())) {
            disabled = Disabled.valueOf(command.getDisabled());
        }

        Role role = new Role(
                command.getName(),
                command.getDescription(),
                disabled,
                command.getSort()
        );

        roleRepository.add(role);
    }

    @Override
    public void delete(Integer id) {

        logger.info("删除角色, id=[{}]", id);

        if (0 == roleRepository.delete(id)) {
            throw new NotFoundException("角色id=[" + id + "]的记录不存在");
        }

    }

    @Override
    public void update(AdminRoleCommand command) {

        logger.info("更新角色, id=[{}]", command.getId());

        Disabled disabled = null;
        if (!StringUtils.isEmpty(command.getDisabled())) {
            disabled = Disabled.valueOf(command.getDisabled());
        }

        Role role = this.findById(command.getId());
        role.setName(command.getName());
        role.setDescription(command.getDescription());
        role.setDisabled(disabled);
        role.setSort(command.getSort());

        roleRepository.update(role);
    }

    @Override
    public Role findById(Integer id) {
        Role role = (Role) roleRepository.findById(id);
        if (null == role) {
            throw new NotFoundException("角色id=[" + id + "]的记录不存在");
        }
        return role;
    }

    @Override
    public List<Role> pagination(AdminRolePaginationCommand command) {

        int limitPage = (command.getPage() - 1) * command.getPageSize();
        int limitPageSize = command.getPageSize() * command.getPage();

        Map<String, Object> paramsMap = new HashMap<String, Object>();

        Disabled disabled;
        if (!StringUtils.isEmpty(command.getDisabled())) {
            disabled = Disabled.valueOf(command.getDisabled());
            paramsMap.put("disabled", disabled.getValue());
        }

        if (!StringUtils.isEmpty(command.getName())) {
            paramsMap.put("name", SqlOperator.like(command.getName(), SqlOperator.Like.ANYWHERE));
        }

        paramsMap.put("page", limitPage);
        paramsMap.put("pageSize", limitPageSize);

        return roleRepository.pagination(paramsMap);
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }
}
