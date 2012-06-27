package net.therap.controller;

import net.therap.domain.User;
import net.therap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by IntelliJ IDEA.
 * User: sazzadur
 * Date: 6/4/12
 * Time: 2:17 PM
 * To change this template use File | Settings | File Templates.
 */

@Controller
public class LoginController {

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login.htm", method = RequestMethod.POST)
    public String loginAction(HttpServletRequest request, HttpServletResponse response) {

      User user = userService.authenticateUser(request.getParameter("email"), request.getParameter("password"));
      if (user == null) {
            if (request.getHeader("Referer").contains("errorcode")) {
                return "redirect:" + request.getHeader("Referer");
            }
            return "redirect:" + request.getHeader("Referer") + "?errorcode=1";

        } else {

                request.getSession().setAttribute("user", user);
                return "redirect:" + "/app/home.htm";
      }

    }

    @RequestMapping(value = "/login.htm", method = RequestMethod.GET)
    public String getLoginAction(){
        return "login";
    }

}
