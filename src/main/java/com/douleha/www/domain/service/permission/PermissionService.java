package com.douleha.www.domain.service.permission;

import com.douleha.www.application.admin.permission.command.AdminPermissionCommand;
import com.douleha.www.application.admin.permission.command.AdminPermissionPaginationCommand;
import com.douleha.www.controller.exception.NotFoundException;
import com.douleha.www.domain.model.permission.IPermissionRepository;
import com.douleha.www.domain.model.permission.Permission;
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
@Service("permissionService")
public class PermissionService implements IPermissionService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private IPermissionRepository permissionRepository;

    @Override
    public void add(AdminPermissionCommand command) {

        logger.info("创建权限");

        Disabled disabled = null;
        if (!StringUtils.isEmpty(command.getDisabled())) {
            disabled = Disabled.valueOf(command.getDisabled());
        }

        Permission permission = new Permission(
                command.getName(),
                command.getDescription(),
                disabled,
                command.getSort()
        );

        permissionRepository.add(permission);
    }

    @Override
    public void delete(Integer id) {
        if (0 == permissionRepository.delete(id)) {
            throw new NotFoundException("权限id=[" + id + "]的记录不存在");
        }
    }

    @Override
    public void update(AdminPermissionCommand command) {

        logger.info("更新权限");

        Disabled disabled = null;
        if (!StringUtils.isEmpty(command.getDisabled())) {
            disabled = Disabled.valueOf(command.getDisabled());
        }

        Permission permission = this.findById(command.getId());
        permission.setName(command.getName());
        permission.setDescription(command.getDescription());
        permission.setDisabled(disabled);
        permission.setSort(command.getSort());

        permissionRepository.update(permission);
    }

    @Override
    public Permission findById(Integer id) {
        Permission permission = (Permission) permissionRepository.findById(id);
        if (null == permission) {
            throw new NotFoundException("权限id=[" + id + "]的记录不存在");
        }
        return permission;
    }

    @Override
    public List<Permission> pagination(AdminPermissionPaginationCommand command) {

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

        return permissionRepository.pagination(paramsMap);
    }

    @Override
    public List<Permission> findAll() {
        return permissionRepository.findAll();
    }
}
