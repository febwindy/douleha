package com.douleha.www.controller.api.v1.admin;

import com.douleha.www.application.admin.user.IAdminUserAppService;
import com.douleha.www.application.admin.user.command.AdminUserCommand;
import com.douleha.www.controller.shared.BaseApiController;
import com.douleha.www.utils.type.api.ApiResponse;
import com.douleha.www.utils.type.api.ApiReturnCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by ivan_ on 2015/8/31.
 */
@Controller
@RequestMapping("/v1/admin")
public class AdminUserController extends BaseApiController {

    @Autowired
    private IAdminUserAppService adminUserAppService;

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    @ResponseBody
    public ApiResponse add(AdminUserCommand command) throws Exception {
        ApiResponse apiResponse = adminUserAppService.add(command);
        convertToReadableForApiResponse(apiResponse);
        return apiResponse;
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ApiResponse delete(@PathVariable Integer id) throws Exception {
        ApiResponse apiResponse = adminUserAppService.delete(id);
        convertToReadableForApiResponse(apiResponse);
        return apiResponse;
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ApiResponse update(@PathVariable Integer id, AdminUserCommand command) throws Exception {
        ApiResponse apiResponse = adminUserAppService.update(command);
        convertToReadableForApiResponse(apiResponse);
        return apiResponse;
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse select(@PathVariable Integer id) throws Exception {
        ApiResponse apiResponse = adminUserAppService.select(id);
        convertToReadableForApiResponse(apiResponse);
        return apiResponse;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse selects() throws Exception {
        return new ApiResponse(ApiReturnCode.ERROR_10000, "查询所有成功");
    }

}
