package net.therap.controller;

import junit.framework.TestCase;
import net.therap.domain.User;
import net.therap.service.UserService;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: sazzadur
 * Date: 6/27/12
 * Time: 3:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class RegisterControllerTest extends TestCase {
    private RegistrationController registrationController;

    private UserService userService;
    private User user;
    Errors bindingResult;

    @Before
    public void setUp() {
      registrationController = new RegistrationController();
      userService = EasyMock.createMock(UserService.class);
      bindingResult = EasyMock.createMock(BindingResult.class);
      registrationController.setUserService(userService);
      user = new User();


    }

    @Test
    public void testGetLoginAction(){
        Map<String,Object> map = new HashMap();
        assertEquals("register",registrationController.userRegAction(map));
    }

    @Test
    public void testRegisterAction_withoutBindingError(){
        user.setEmail("sazzad14@yahoo.com");
        user.setPassword("123456789");
        user.setConfirmPassword("123456789");

        EasyMock.expect(userService.isEmailExists("sazzad14@yahoo.com")).andReturn(false);
        EasyMock.expect(bindingResult.hasErrors()).andReturn(false);
        userService.saveUser(user);
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(userService);
        EasyMock.replay(bindingResult);


        String actualView = registrationController.saveUserAction(user,(BindingResult)bindingResult);
        assertEquals("redirect:/app/login.htm", actualView);
    }

    @Test
    public void testRegisterAction_hasBindingError(){
        user.setEmail("sazzad14@yahoo.com");
        user.setPassword("123456789");
        user.setConfirmPassword("123456789");

        EasyMock.expect(userService.isEmailExists("sazzad14@yahoo.com")).andReturn(false);
        EasyMock.expect(bindingResult.hasErrors()).andReturn(true);
        EasyMock.replay(userService);
        EasyMock.replay(bindingResult);


        String actualView = registrationController.saveUserAction(user,(BindingResult)bindingResult);
        assertEquals("register", actualView);
    }

    @Test
    public void testRegisterAction_missMatchPassword(){
        user.setEmail("sazzad14@yahoo.com");
        user.setPassword("123456789");
        user.setConfirmPassword("12345678");

        EasyMock.expect(userService.isEmailExists("sazzad14@yahoo.com")).andReturn(false);
        EasyMock.expect(bindingResult.hasErrors()).andReturn(true);
        bindingResult.rejectValue("user.confirmPassword", "password.mismatch");
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(userService);
        EasyMock.replay(bindingResult);


        String actualView = registrationController.saveUserAction(user,(BindingResult)bindingResult);
        assertEquals("register", actualView);
    }
}
