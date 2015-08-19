package com.douleha.www.controller.view;

import com.douleha.www.domain.model.user.User;
import com.douleha.www.domain.service.user.IUserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.UUID;

/**
 * Created by ivan_ on 2015/8/12.
 */
@Controller
public class IndexController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/")
    public ModelAndView index() throws Exception {
        Subject subject = SecurityUtils.getSubject();
        String username = subject.getPrincipal().toString();
        return new ModelAndView("/index");
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() throws Exception {
        return new ModelAndView("/login");
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(String username, String password) throws Exception {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        subject.login(token);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register() throws Exception {
        return new ModelAndView("/register");
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView register(String username, String password, String nickname) throws Exception {

        String uuid = UUID.randomUUID().toString().replaceAll("-", "");

        String pwd = new Md5Hash(password, uuid).toString();

        User user = new User();
        user.setUsername(username);
        user.setPassword(pwd);
        user.setNickname(nickname);
        user.setSalt(uuid);

        userService.insert(user);

        return new ModelAndView("redirect:/register");
    }


}
