package com.douleha.www.controller.api.v1.admin;

import com.douleha.www.controller.shared.BaseApiController;
import com.douleha.www.utils.type.api.ApiResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ivan_ on 2015/9/1.
 */
@Controller
@RequestMapping("/v1/admin")
public class AdminRoleController extends BaseApiController {

    @RequestMapping(value = "/roles", method = RequestMethod.POST)
    public ApiResponse add() throws Exception {
        return null;
    }

    @RequestMapping(value = "/roles/{id}", method = RequestMethod.DELETE)
    public ApiResponse delete(@PathVariable Integer id) throws Exception {
        return null;
    }

    @RequestMapping(value = "/roles/{id}", method = RequestMethod.PUT)
    public ApiResponse update(@PathVariable Integer id) throws Exception {
        return null;
    }

    @RequestMapping(value = "/roles/{id}", method = RequestMethod.GET)
    public ApiResponse select(@PathVariable Integer id) throws Exception {
        return null;
    }

    @RequestMapping(value = "/roles", method = RequestMethod.GET)
    public ApiResponse selects() throws Exception {
        return null;
    }
}
