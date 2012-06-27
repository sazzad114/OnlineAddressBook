package net.therap.dao;

import net.therap.domain.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.orm.hibernate.HibernateUnitils;
import org.unitils.spring.annotation.SpringApplicationContext;
import org.unitils.spring.annotation.SpringBean;

/**
 * Created by IntelliJ IDEA.
 * User: sazzadur
 * Date: 6/27/12
 * Time: 4:49 PM
 * To change this template use File | Settings | File Templates.
 */

@DataSet
@SpringApplicationContext(value = {"classpath:test-applicationContext.xml"})
public class UserDaoTest extends UnitilsTestNG {
    @SpringBean("userDao")
    private UserDao userDao;

     @Test
    public void testMappingToDatabase() {
        HibernateUnitils.assertMappingWithDatabaseConsistent();
    }
     @Test
     public void testGetUserById(){
         User user = userDao.getUserById(1L);
         Assert.assertEquals(1L,user.getUserId());
     }

    @Test
    public void testGetUserByEmail(){
        User user = userDao.getUserByEmail("sazzad@yahoo.com");
        Assert.assertEquals(1L,user.getUserId());
    }



}
