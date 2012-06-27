package net.therap.controller;

import net.therap.domain.User;
import net.therap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: sazzadur
 * Date: 6/26/12
 * Time: 3:52 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@SessionAttributes("userCommand")
@RequestMapping("/register.htm")
public class RegistrationController {

    @Autowired
    UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String userRegAction(Map<String, Object> model) {
        model.put("title", "User Registration Form");
        model.put("userCommand", new User());
        return "register";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveUserAction(@Valid @ModelAttribute("userCommand") User user, BindingResult bindingResult) {

        if (userService.isEmailExists(user.getEmail()) == true) {
            bindingResult.rejectValue("user.email", "email.exists");
        }

        if (!user.getPassword().equals(user.getConfirmPassword())) {
            bindingResult.rejectValue("user.confirmPassword", "password.mismatch");
        }

        if (bindingResult.hasErrors()) {
            return "register";
        }
        else {
           userService.saveUser(user);
           return "redirect:/app/login.htm";
        }

    }
}
