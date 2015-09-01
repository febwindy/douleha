package com.douleha.www.controller.api.v1.error;

import com.douleha.www.controller.exception.InternalServerException;
import com.douleha.www.controller.exception.MethodNotAllowedException;
import com.douleha.www.controller.exception.NotFoundException;
import com.douleha.www.utils.type.api.ApiResponse;
import com.douleha.www.utils.type.api.ApiReturnCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by ivan_ on 2015/8/27.
 */
@Controller
@RequestMapping("/v1/error")
public class ErrorHandleController {

    @RequestMapping(value = "/404")
    @ResponseBody
    public void ERROR_404() throws Exception {
        throw new NotFoundException(new ApiResponse(ApiReturnCode.ERROR_404, ApiReturnCode.ERROR_404.getName()));
    }

    @RequestMapping(value = "/405")
    @ResponseBody
    public void ERROR_405() throws Exception {
        throw new MethodNotAllowedException(new ApiResponse(ApiReturnCode.ERROR_405, ApiReturnCode.ERROR_405.getName()));
    }

    @RequestMapping(value = "/500")
    @ResponseBody
    public void ERROR_500() throws Exception {
        throw new InternalServerException(new ApiResponse(ApiReturnCode.ERROR_500, ApiReturnCode.ERROR_500.getName()));
    }

}
