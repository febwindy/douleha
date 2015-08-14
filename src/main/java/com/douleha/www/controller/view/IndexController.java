package com.douleha.www.controller.view;

import com.douleha.www.domain.model.user.User;
import com.douleha.www.domain.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by ivan_ on 2015/8/12.
 */
@Controller
public class IndexController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/")
    public ModelAndView index() throws Exception {
        User user = userService.findById(1);
        List<User> users = userService.listUserByUsername("liwenhe");
        return new ModelAndView("/index");
    }


}
