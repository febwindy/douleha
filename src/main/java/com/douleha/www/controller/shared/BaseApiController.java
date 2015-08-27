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

    protected String getMessage(String code, Object[] params, Locale locale) {
        return messageSource.getMessage(code, params, locale);
    }

    protected void convertToReadableForApiResponse(ApiResponse response) {
        String message = response.getMessage();
        try {
            response.setMessage(this.getMessage(message, Locale.SIMPLIFIED_CHINESE));
        } catch (Exception e) {
            response.setMessage(message);
        }
    }

}
