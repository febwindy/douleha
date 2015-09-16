package com.douleha.www.application.admin.url;

import com.douleha.www.application.admin.url.command.AdminUrlCommand;
import com.douleha.www.application.admin.url.command.AdminUrlPaginationCommand;
import com.douleha.www.application.admin.url.representation.AdminUrlRepresentation;
import com.douleha.www.controller.exception.InternalServerException;
import com.douleha.www.controller.exception.InvalidRequestException;
import com.douleha.www.controller.exception.NotFoundException;
import com.douleha.www.domain.model.url.Url;
import com.douleha.www.domain.service.url.IUrlService;
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
 * Created by ivan_ on 2015/9/16.
 */
@Service("adminUrlAppService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class AdminUrlAppService implements IAdminUrlAppService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private IUrlService urlService;

    @Autowired
    private IMappingService mappingService;

    @Override
    public ApiResponse add(AdminUrlCommand command) {

        if (StringUtils.isEmpty(command.getName())) {
            throw new InvalidRequestException(new ApiResponse(ApiReturnCode.ERROR_50000, ApiReturnCode.ERROR_50000.getName()));
        }

        if (StringUtils.isEmpty(command.getDisabled())) {
            throw new InvalidRequestException(new ApiResponse(ApiReturnCode.ERROR_50001, ApiReturnCode.ERROR_50001.getName()));
        } else {
            try {
                Disabled.valueOf(command.getDisabled());
            } catch (IllegalArgumentException e) {
                throw new InvalidRequestException(new ApiResponse(ApiReturnCode.ERROR_50002, ApiReturnCode.ERROR_50002.getName()));
            }
        }

        try {
            urlService.add(command);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new InvalidRequestException(new ApiResponse(ApiReturnCode.ERROR, ApiReturnCode.ERROR.getName()));
        }

        return new ApiResponse(ApiReturnCode.SUCCESS, ApiReturnCode.SUCCESS.getName());
    }

    @Override
    public ApiResponse delete(Integer id) {

        try {
            urlService.delete(id);
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
    public ApiResponse update(AdminUrlCommand command) {

        if (!StringUtils.isEmpty(command.getDisabled())) {
            try {
                Disabled.valueOf(command.getDisabled());
            } catch (IllegalArgumentException e) {
                throw new InvalidRequestException(new ApiResponse(ApiReturnCode.ERROR_50002, ApiReturnCode.ERROR_50002.getName()));
            }
        }

        try {
            urlService.update(command);
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
            Url url = urlService.findById(id);

            AdminUrlRepresentation representation = mappingService.map(url, AdminUrlRepresentation.class, false);
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
    public ApiResponse selects(AdminUrlPaginationCommand command) {

        ApiResponse apiResponse;

        if (!StringUtils.isEmpty(command.getDisabled())) {
            try {
                Disabled.valueOf(command.getDisabled());
            } catch (IllegalArgumentException e) {
                throw new InvalidRequestException(new ApiResponse(ApiReturnCode.ERROR_30002, ApiReturnCode.ERROR_30002.getName()));
            }
        }

        try {
            List<Url> urls = urlService.pagination(command);

            List<AdminUrlRepresentation> representations = mappingService.mapAsList(urls, AdminUrlRepresentation.class);
            apiResponse = new ApiResponse(ApiReturnCode.SUCCESS, ApiReturnCode.SUCCESS.getName(),
                    new ApiPagination<AdminUrlRepresentation>(command.getPageSize(), command.getPage(), representations));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new NotFoundException(new ApiResponse(ApiReturnCode.ERROR_404, ApiReturnCode.ERROR_404.getName()));
        }

        return apiResponse;
    }

}
