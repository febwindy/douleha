package com.douleha.www.controller.shared.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.validation.BindingResult;

/**
 * Created by ivan_ on 2015/8/21.
 */
public abstract class BaseController {

    @Autowired
    protected MessageSource messageResource;

}
