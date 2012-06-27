package net.therap.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by IntelliJ IDEA.
 * User: sazzadur
 * Date: 5/29/12
 * Time: 4:57 PM
 * To change this template use File | Settings | File Templates.
 */

@Controller
@RequestMapping({"/home.htm"})
public class HomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String welcomeAction() {
        return "home";
    }

}
