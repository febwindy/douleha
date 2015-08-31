package com.douleha.www.controller.shared;

import com.douleha.www.utils.type.api.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import java.util.Locale;

/**
 * Created by ivan_ on 2015/8/27.
 */
public abstract class BaseApiController {

    @Autowired
    private MessageSource messageSource;

    protected String getMessage(String code, Locale locale) {
        return this.getMessage(code, null, locale);
    }

    /**
     * 通过code解析message.properties中的内容
     * @param code
     * @param params
     * @param locale
     * @return
     */
    protected String getMessage(String code, Object[] params, Locale locale) {
        return messageSource.getMessage(code, params, locale);
    }

    protected void convertToReadableForApiResponse(ApiResponse response) {
        this.convertToReadableForApiResponse(response, null);
    }

    /**
     * 由于ApiResponse中的name值配置在message.properties中,因此通过此方法可解析出用记可以理解的内容
     * @param response
     */
    protected void convertToReadableForApiResponse(ApiResponse response, Object[] params) {
        String message = response.getMessage();
        try {
            if (null == params) {
                response.setMessage(this.getMessage(message, Locale.SIMPLIFIED_CHINESE));
            } else {
                response.setMessage(this.getMessage(message, params, Locale.SIMPLIFIED_CHINESE));
            }
        } catch (Exception e) {
            response.setMessage(message);
        }
    }

}
