package com.douleha.www.application.admin.user;

import com.douleha.www.application.admin.user.command.AdminUserCommand;
import com.douleha.www.application.admin.user.command.AdminUserPaginationCommand;
import com.douleha.www.application.admin.user.representation.AdminUserRepresentation;
import com.douleha.www.controller.exception.InvalidRequestException;
import com.douleha.www.controller.exception.NotFoundException;
import com.douleha.www.domain.model.user.User;
import com.douleha.www.domain.service.user.IUserService;
import com.douleha.www.utils.mapping.IMappingService;
import com.douleha.www.utils.type.api.ApiPagination;
import com.douleha.www.utils.type.api.ApiResponse;
import com.douleha.www.utils.type.api.ApiReturnCode;
import com.douleha.www.utils.type.model.Sex;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ivan_ on 2015/8/31.
 */
@Service("adminUserAppService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class AdminUserAppService implements IAdminUserAppService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private IUserService userService;

    @Autowired
    private IMappingService mappingService;

    @Override
    public ApiResponse add(AdminUserCommand command) {

        if (StringUtils.isEmpty(command.getUsername())) {
            throw new InvalidRequestException(new ApiResponse(ApiReturnCode.ERROR_20000, ApiReturnCode.ERROR_20000.getName()));
        }

        if (StringUtils.isEmpty(command.getPassword())) {
            throw new InvalidRequestException(new ApiResponse(ApiReturnCode.ERROR_20001, ApiReturnCode.ERROR_20001.getName()));
        }

        if (StringUtils.isEmpty(command.getNickname())) {
            throw new InvalidRequestException(new ApiResponse(ApiReturnCode.ERROR_20002, ApiReturnCode.ERROR_20002.getName()));
        }

        if (null != command.getSex() && !StringUtils.isEmpty(command.getSex())) {
            try {
                Sex.valueOf(command.getSex());
            } catch (IllegalArgumentException e) {
                throw new InvalidRequestException(new ApiResponse(ApiReturnCode.ERROR_20003, ApiReturnCode.ERROR_20003.getName()));
            }
        }

        try {
            userService.add(command);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new InvalidRequestException(new ApiResponse(ApiReturnCode.ERROR, ApiReturnCode.ERROR.getName()));
        }

        return new ApiResponse(ApiReturnCode.SUCCESS, ApiReturnCode.SUCCESS.getName());
    }

    @Override
    public ApiResponse delete(Integer id) {

        try {
            userService.delete(id);
        } catch (NotFoundException e) {
            logger.warn(e.getMessage(), e);
            throw new NotFoundException(new ApiResponse(ApiReturnCode.ERROR_404, ApiReturnCode.ERROR_404.getName()));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new NotFoundException(new ApiResponse(ApiReturnCode.ERROR_500, ApiReturnCode.ERROR_500.getName()));
        }

        return new ApiResponse(ApiReturnCode.SUCCESS, ApiReturnCode.SUCCESS.getName());
    }

    @Override
    public ApiResponse update(AdminUserCommand command) {

        try {
            userService.update(command);
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
            User user = userService.findById(id);

            AdminUserRepresentation representation = mappingService.map(user, AdminUserRepresentation.class, false);
            apiResponse = new ApiResponse(ApiReturnCode.SUCCESS, ApiReturnCode.SUCCESS.getName(), representation);
        } catch (NotFoundException e) {
            logger.warn(e.getMessage(), e);
            throw new NotFoundException(new ApiResponse(ApiReturnCode.ERROR_404, ApiReturnCode.ERROR_404.getName()));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new NotFoundException(new ApiResponse(ApiReturnCode.ERROR_404, ApiReturnCode.ERROR_404.getName()));
        }

        return apiResponse;
    }

    @Override
    public ApiResponse selects(AdminUserPaginationCommand command) {

        ApiResponse apiResponse;

        if (null != command.getSex() && !StringUtils.isEmpty(command.getSex())) {
            try {
                Sex.valueOf(command.getSex());
            } catch (IllegalArgumentException e) {
                throw new InvalidRequestException(new ApiResponse(ApiReturnCode.ERROR_20003, ApiReturnCode.ERROR_20003.getName()));
            }
        }
        
        try {
            List<User> users = userService.pagination(command);

            List<AdminUserRepresentation> representations = mappingService.mapAsList(users, AdminUserRepresentation.class);
            apiResponse = new ApiResponse(ApiReturnCode.SUCCESS, ApiReturnCode.SUCCESS.getName(),
                    new ApiPagination<AdminUserRepresentation>(command.getPageSize(), command.getPage(), representations));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new NotFoundException(new ApiResponse(ApiReturnCode.ERROR_404, ApiReturnCode.ERROR_404.getName()));
        }

        return apiResponse;
    }
}
