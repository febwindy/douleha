package com.douleha.www.controller.api.v1.admin;

import com.douleha.www.application.admin.role.IAdminRoleAppService;
import com.douleha.www.application.admin.role.command.AdminRoleCommand;
import com.douleha.www.application.admin.role.command.AdminRolePaginationCommand;
import com.douleha.www.controller.shared.BaseApiController;
import com.douleha.www.utils.type.api.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by ivan_ on 2015/9/1.
 */
@Controller
@RequestMapping("/v1/admin")
public class AdminRoleController extends BaseApiController {

    @Autowired
    private IAdminRoleAppService adminRoleAppService;

    @RequestMapping(value = "/roles", method = RequestMethod.POST)
    @ResponseBody
    public ApiResponse add(AdminRoleCommand command) throws Exception {
        ApiResponse apiResponse = adminRoleAppService.add(command);
        convertToReadableForApiResponse(apiResponse);
        return apiResponse;
    }

    @RequestMapping(value = "/roles/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ApiResponse delete(@PathVariable Integer id) throws Exception {
        ApiResponse apiResponse = adminRoleAppService.delete(id);
        convertToReadableForApiResponse(apiResponse);
        return apiResponse;
    }

    @RequestMapping(value = "/roles/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ApiResponse update(@PathVariable Integer id, AdminRoleCommand command) throws Exception {
        ApiResponse apiResponse = adminRoleAppService.update(command);
        convertToReadableForApiResponse(apiResponse);
        return apiResponse;
    }

    @RequestMapping(value = "/roles/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse select(@PathVariable Integer id) throws Exception {
        ApiResponse apiResponse = adminRoleAppService.select(id);
        convertToReadableForApiResponse(apiResponse);
        return apiResponse;
    }

    @RequestMapping(value = "/roles", method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse selects(AdminRolePaginationCommand command) throws Exception {
        ApiResponse apiResponse = adminRoleAppService.selects(command);
        convertToReadableForApiResponse(apiResponse);
        return apiResponse;
    }
}
