package net.therap.controller;

import junit.framework.TestCase;
import net.therap.domain.User;
import net.therap.service.UserService;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by IntelliJ IDEA.
 * User: sazzadur
 * Date: 6/27/12
 * Time: 3:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class LoginControllerTest extends TestCase {
    private LoginController loginController;
    private HttpServletRequest httpServletRequest;
    private HttpServletResponse httpServletResponse;
    private HttpSession httpsession;
    private UserService userService;
    private User user;

    @Before
    public void setUp() {
      loginController = new LoginController();
      httpServletRequest = EasyMock.createMock(HttpServletRequest.class);
      httpServletResponse = EasyMock.createMock(HttpServletResponse.class);
      httpsession = EasyMock.createMock(HttpSession.class);
      userService = EasyMock.createMock(UserService.class);
      user = new User();
      user.setEmail("sazzad14@yahoo.com");
      user.setPassword("123456789");
    }

    @Test
    public void testGetLoginAction(){
        assertEquals("login",loginController.getLoginAction());
    }

    @Test
    public void testLoginAction_parameter(){

       EasyMock.expect(httpServletRequest.getParameter("email")).andReturn("sazzad14@yahoo.com");
       EasyMock.expect(httpServletRequest.getParameter("password")).andReturn("123456789");
       EasyMock.expect(userService.authenticateUser("sazzad14@yahoo.com","123456789")).times(1).andReturn(user);
       EasyMock.expect(httpServletRequest.getSession()).andReturn(httpsession);
       httpsession.setAttribute("user", user);
       EasyMock.expectLastCall().times(1);
       EasyMock.replay(userService);
       EasyMock.replay(httpServletRequest);
       EasyMock.replay(httpsession);
       assertEquals("redirect:/app/home.htm", loginController.loginAction(httpServletRequest, httpServletResponse));
    }
}
