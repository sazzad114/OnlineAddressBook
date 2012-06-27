package net.therap.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by IntelliJ IDEA.
 * User: sazzadur
 * Date: 6/12/12
 * Time: 4:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class LoginAuthInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String url = request.getRequestURI();

        if ((request.getSession(false) == null || request.getSession().getAttribute("user") == null) && !url.contains("/login") && !url.contains("/register")) {
            response.sendRedirect("/OnlineAddressBook/app/login.htm");
            return false;
        }

        if (request.getSession(false) != null && request.getSession().getAttribute("user") != null && (url.contains("/login") || url.contains("/register"))) {
            response.sendRedirect("/OnlineAddressBook/app/home.htm");
            return false;
        }

        return true;
    }
}
