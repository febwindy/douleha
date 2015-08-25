package com.douleha.www.controller.shared.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Created by ivan_ on 2015/8/21.
 */
public abstract class BaseController {

    @Autowired
    protected MessageSource messageResource;

    protected Map<String, String> getErrorInfo(BindingResult bindingResult, Locale locale) {
        Map<String, String> result = new HashMap<String, String>(bindingResult.getErrorCount()*2);
        List<ObjectError> errors = bindingResult.getAllErrors();
        for (ObjectError error : errors) {
            FieldError fieldError = (FieldError) error;
            String message = this.messageResource.getMessage(error.getDefaultMessage(), null, locale);
            String filed = fieldError.getField() + "Error";
            result.put(filed, message);
        }
        return result;
    }

    protected String getMessage(String code, Locale locale) {
        return this.getMessage(code, null, locale);
    }

    protected String getMessage(String code, Object[] objArr, Locale locale) {
        return this.messageResource.getMessage(code, objArr, locale);
    }

}
