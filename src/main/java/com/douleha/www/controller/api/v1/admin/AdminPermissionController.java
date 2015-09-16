package com.douleha.www.controller.api.v1.admin;

import com.douleha.www.application.admin.permission.IAdminPermissionAppService;
import com.douleha.www.application.admin.permission.command.AdminPermissionCommand;
import com.douleha.www.application.admin.permission.command.AdminPermissionPaginationCommand;
import com.douleha.www.controller.shared.BaseApiController;
import com.douleha.www.utils.type.api.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by ivan_ on 2015/9/9.
 */
@Controller
@RequestMapping("/v1/admin")
public class AdminPermissionController extends BaseApiController {

    @Autowired
    private IAdminPermissionAppService adminPermissionAppService;

    @RequestMapping(value = "/permissions", method = RequestMethod.POST)
    @ResponseBody
    public ApiResponse add(AdminPermissionCommand command) throws Exception {
        ApiResponse apiResponse = adminPermissionAppService.add(command);
        convertToReadableForApiResponse(apiResponse);
        return apiResponse;
    }

    @RequestMapping(value = "/permissions/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ApiResponse delete(@PathVariable Integer id) throws Exception {
        ApiResponse apiResponse = adminPermissionAppService.delete(id);
        convertToReadableForApiResponse(apiResponse);
        return apiResponse;
    }

    @RequestMapping(value = "/permissions/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ApiResponse update(@PathVariable Integer id, AdminPermissionCommand command) throws Exception {
        ApiResponse apiResponse = adminPermissionAppService.update(command);
        convertToReadableForApiResponse(apiResponse);
        return apiResponse;
    }

    @RequestMapping(value = "/permissions/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse select(@PathVariable Integer id) throws Exception {
        ApiResponse apiResponse = adminPermissionAppService.select(id);
        convertToReadableForApiResponse(apiResponse);
        return apiResponse;
    }

    @RequestMapping(value = "/permissions", method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse selects(AdminPermissionPaginationCommand command) throws Exception {
        ApiResponse apiResponse = adminPermissionAppService.selects(command);
        convertToReadableForApiResponse(apiResponse);
        return apiResponse;
    }

}
