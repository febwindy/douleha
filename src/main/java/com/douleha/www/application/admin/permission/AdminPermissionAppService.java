package com.douleha.www.application.admin.permission;

import com.douleha.www.application.admin.permission.command.AdminPermissionCommand;
import com.douleha.www.application.admin.permission.command.AdminPermissionPaginationCommand;
import com.douleha.www.application.admin.permission.representation.AdminPermissionRepresentation;
import com.douleha.www.controller.exception.InternalServerException;
import com.douleha.www.controller.exception.InvalidRequestException;
import com.douleha.www.controller.exception.NotFoundException;
import com.douleha.www.domain.model.permission.Permission;
import com.douleha.www.domain.service.permission.IPermissionService;
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
 * Created by ivan_ on 2015/9/9.
 */
@Service("adminPermissionAppService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class AdminPermissionAppService implements IAdminPermissionAppService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private IPermissionService permissionService;

    @Autowired
    private IMappingService mappingService;

    @Override
    public ApiResponse add(AdminPermissionCommand command) {

        if (StringUtils.isEmpty(command.getName())) {
            throw new InvalidRequestException(new ApiResponse(ApiReturnCode.ERROR_40000, ApiReturnCode.ERROR_40000.getName()));
        }

        if (StringUtils.isEmpty(command.getDisabled())) {
            throw new InvalidRequestException(new ApiResponse(ApiReturnCode.ERROR_40001, ApiReturnCode.ERROR_40001.getName()));
        } else {
            try {
                Disabled.valueOf(command.getDisabled());
            } catch (IllegalArgumentException e) {
                throw new InvalidRequestException(new ApiResponse(ApiReturnCode.ERROR_40002, ApiReturnCode.ERROR_40002.getName()));
            }
        }

        try {
            permissionService.add(command);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new InvalidRequestException(new ApiResponse(ApiReturnCode.ERROR, ApiReturnCode.ERROR.getName()));
        }

        return new ApiResponse(ApiReturnCode.SUCCESS, ApiReturnCode.SUCCESS.getName());
    }

    @Override
    public ApiResponse delete(Integer id) {

        try {
            permissionService.delete(id);
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
    public ApiResponse update(AdminPermissionCommand command) {

        if (!StringUtils.isEmpty(command.getDisabled())) {
            try {
                Disabled.valueOf(command.getDisabled());
            } catch (IllegalArgumentException e) {
                throw new InvalidRequestException(new ApiResponse(ApiReturnCode.ERROR_40002, ApiReturnCode.ERROR_40002.getName()));
            }
        }

        try {
            permissionService.update(command);
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
            Permission permission = permissionService.findById(id);

            AdminPermissionRepresentation representation = mappingService.map(permission, AdminPermissionRepresentation.class, false);
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
    public ApiResponse selects(AdminPermissionPaginationCommand command) {

        ApiResponse apiResponse;

        if (!StringUtils.isEmpty(command.getDisabled())) {
            try {
                Disabled.valueOf(command.getDisabled());
            } catch (IllegalArgumentException e) {
                throw new InvalidRequestException(new ApiResponse(ApiReturnCode.ERROR_30002, ApiReturnCode.ERROR_30002.getName()));
            }
        }

        try {
            List<Permission> permissions = permissionService.pagination(command);

            List<AdminPermissionRepresentation> representations = mappingService.mapAsList(permissions, AdminPermissionRepresentation.class);
            apiResponse = new ApiResponse(ApiReturnCode.SUCCESS, ApiReturnCode.SUCCESS.getName(),
                    new ApiPagination<AdminPermissionRepresentation>(command.getPageSize(), command.getPage(), representations));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new NotFoundException(new ApiResponse(ApiReturnCode.ERROR_404, ApiReturnCode.ERROR_404.getName()));
        }

        return apiResponse;
    }
}
