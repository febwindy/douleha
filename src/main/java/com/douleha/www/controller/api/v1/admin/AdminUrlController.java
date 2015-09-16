package com.douleha.www.controller.api.v1.admin;

import com.douleha.www.application.admin.url.IAdminUrlAppService;
import com.douleha.www.application.admin.url.command.AdminUrlCommand;
import com.douleha.www.application.admin.url.command.AdminUrlPaginationCommand;
import com.douleha.www.controller.shared.BaseApiController;
import com.douleha.www.utils.type.api.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by ivan_ on 2015/9/16.
 */
@Controller
@RequestMapping("/v1/admin")
public class AdminUrlController extends BaseApiController {

    @Autowired
    private IAdminUrlAppService adminUrlAppService;

    @RequestMapping(value = "/urls", method = RequestMethod.POST)
    @ResponseBody
    public ApiResponse add(AdminUrlCommand command) throws Exception {
        ApiResponse apiResponse = adminUrlAppService.add(command);
        convertToReadableForApiResponse(apiResponse);
        return apiResponse;
    }

    @RequestMapping(value = "/urls/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ApiResponse delete(@PathVariable Integer id) throws Exception {
        ApiResponse apiResponse = adminUrlAppService.delete(id);
        convertToReadableForApiResponse(apiResponse);
        return apiResponse;
    }

    @RequestMapping(value = "/urls/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ApiResponse update(@PathVariable Integer id, AdminUrlCommand command) throws Exception {
        ApiResponse apiResponse = adminUrlAppService.update(command);
        convertToReadableForApiResponse(apiResponse);
        return apiResponse;
    }

    @RequestMapping(value = "/urls/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse select(@PathVariable Integer id) throws Exception {
        ApiResponse apiResponse = adminUrlAppService.select(id);
        convertToReadableForApiResponse(apiResponse);
        return apiResponse;
    }

    @RequestMapping(value = "/urls", method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse selects(AdminUrlPaginationCommand command) throws Exception {
        ApiResponse apiResponse = adminUrlAppService.selects(command);
        convertToReadableForApiResponse(apiResponse);
        return apiResponse;
    }

}
