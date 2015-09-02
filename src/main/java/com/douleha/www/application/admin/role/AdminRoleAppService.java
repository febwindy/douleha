package com.douleha.www.application.admin.role;

import com.douleha.www.application.admin.role.command.AdminRoleCommand;
import com.douleha.www.application.admin.role.command.AdminRolePaginationCommand;
import com.douleha.www.application.admin.role.representation.AdminRoleRepresentation;
import com.douleha.www.controller.exception.InternalServerException;
import com.douleha.www.controller.exception.InvalidRequestException;
import com.douleha.www.controller.exception.NotFoundException;
import com.douleha.www.domain.model.role.Role;
import com.douleha.www.domain.service.role.IRoleService;
import com.douleha.www.utils.mapping.IMappingService;
import com.douleha.www.utils.type.api.ApiPagination;
import com.douleha.www.utils.type.api.ApiResponse;
import com.douleha.www.utils.type.api.ApiReturnCode;
import com.douleha.www.utils.type.model.Disabled;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ivan_ on 2015/9/1.
 */
@Service("adminRoleAppService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class AdminRoleAppService implements IAdminRoleAppService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IMappingService mappingService;

    @Override
    public ApiResponse add(AdminRoleCommand command) {

        if (StringUtils.isEmpty(command.getName())) {
            throw new InvalidRequestException(new ApiResponse(ApiReturnCode.ERROR_30000, ApiReturnCode.ERROR_30000.getName()));
        }

        if (StringUtils.isEmpty(command.getDisabled())) {
            throw new InvalidRequestException(new ApiResponse(ApiReturnCode.ERROR_30001, ApiReturnCode.ERROR_30001.getName()));
        } else {
            try {
                Disabled.valueOf(command.getDisabled());
            } catch (IllegalArgumentException e) {
                throw new InvalidRequestException(new ApiResponse(ApiReturnCode.ERROR_30002, ApiReturnCode.ERROR_30002.getName()));
            }
        }

        try {
            roleService.add(command);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new InvalidRequestException(new ApiResponse(ApiReturnCode.ERROR, ApiReturnCode.ERROR.getName()));
        }

        return new ApiResponse(ApiReturnCode.SUCCESS, ApiReturnCode.SUCCESS.getName());
    }

    @Override
    public ApiResponse delete(Integer id) {

        try {
            roleService.delete(id);
        } catch (NotFoundException e) {
            logger.warn(e.getMessage(), e);
            throw new NotFoundException(new ApiResponse(ApiReturnCode.ERROR_404, ApiReturnCode.ERROR_404.getName()));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new InternalServerException(new ApiResponse(ApiReturnCode.ERROR_500, ApiReturnCode.ERROR_500.getName()));
        }

        return new ApiResponse(ApiReturnCode.SUCCESS, ApiReturnCode.SUCCESS.getName());
    }

    @Override
    public ApiResponse update(AdminRoleCommand command) {

        if (!StringUtils.isEmpty(command.getDisabled())) {
            try {
                Disabled.valueOf(command.getDisabled());
            } catch (IllegalArgumentException e) {
                throw new InvalidRequestException(new ApiResponse(ApiReturnCode.ERROR_30002, ApiReturnCode.ERROR_30002.getName()));
            }
        }

        try {
            roleService.update(command);
        } catch (NotFoundException e) {
            logger.warn(e.getMessage(), e);
            throw new NotFoundException(new ApiResponse(ApiReturnCode.ERROR_404, ApiReturnCode.ERROR_404.getName()));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new InvalidRequestException(new ApiResponse(ApiReturnCode.ERROR, ApiReturnCode.ERROR.getName()));
        }

        return new ApiResponse(ApiReturnCode.SUCCESS, ApiReturnCode.SUCCESS.getName());
    }

    @Override
    public ApiResponse select(Integer id) {

        ApiResponse apiResponse;
        try {
            Role role = roleService.findById(id);

            AdminRoleRepresentation representation = mappingService.map(role, AdminRoleRepresentation.class, false);
            apiResponse = new ApiResponse(ApiReturnCode.SUCCESS, ApiReturnCode.SUCCESS.getName(), representation);
        } catch (NotFoundException e) {
            logger.warn(e.getMessage(), e);
            throw new NotFoundException(new ApiResponse(ApiReturnCode.ERROR_404, ApiReturnCode.ERROR_404.getName()));
        } catch(Exception e) {
            logger.error(e.getMessage(), e);
            throw new InternalServerException(new ApiResponse(ApiReturnCode.ERROR_500, ApiReturnCode.ERROR_500.getName()));
        }

        return apiResponse;
    }

    @Override
    public ApiResponse selects(AdminRolePaginationCommand command) {

        ApiResponse apiResponse;

        if (!StringUtils.isEmpty(command.getDisabled())) {
            try {
                Disabled.valueOf(command.getDisabled());
            } catch (IllegalArgumentException e) {
                throw new InvalidRequestException(new ApiResponse(ApiReturnCode.ERROR_30002, ApiReturnCode.ERROR_30002.getName()));
            }
        }

        try {
            List<Role> roles = roleService.pagination(command);

            List<AdminRoleRepresentation> representations = mappingService.mapAsList(roles, AdminRoleRepresentation.class);
            apiResponse = new ApiResponse(ApiReturnCode.SUCCESS, ApiReturnCode.SUCCESS.getName(),
                    new ApiPagination<AdminRoleRepresentation>(command.getPageSize(), command.getPage(), representations));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new NotFoundException(new ApiResponse(ApiReturnCode.ERROR_404, ApiReturnCode.ERROR_404.getName()));
        }

        return apiResponse;
    }
}
