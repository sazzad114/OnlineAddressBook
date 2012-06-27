package net.therap.controller;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: sazzadur
 * Date: 6/11/12
 * Time: 9:28 AM
 * To change this template use File | Settings | File Templates.
 */

public class HomeControllerTest extends TestCase {

    private HomeController homeController;

    @Before
    public void setUp() {
       homeController = new HomeController();
    }

    @Test
    public void testWelcomeAction(){
         assertEquals("home",homeController.welcomeAction());
     }

}