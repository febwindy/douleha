package com.douleha.www.controller.view;

import com.douleha.www.domain.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by ivan_ on 2015/8/12.
 */
@Controller
public class IndexController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/")
    public ModelAndView index() throws Exception {
        return new ModelAndView("/index");
    }


}
