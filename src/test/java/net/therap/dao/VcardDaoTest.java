package net.therap.dao;

import net.therap.domain.Vcard;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.unitils.UnitilsTestNG;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.dbunit.annotation.ExpectedDataSet;
import org.unitils.orm.hibernate.HibernateUnitils;
import org.unitils.spring.annotation.SpringApplicationContext;
import org.unitils.spring.annotation.SpringBean;

/**
 * Created by IntelliJ IDEA.
 * User: sazzadur
 * Date: 6/27/12
 * Time: 5:03 PM
 * To change this template use File | Settings | File Templates.
 */
@DataSet
@SpringApplicationContext(value = {"classpath:test-applicationContext.xml"})
public class VcardDaoTest extends UnitilsTestNG {

    @SpringBean("vcardDao")
    private VcardDao vcardDao;

    @Test
    public void testMappingToDatabase() {
        HibernateUnitils.assertMappingWithDatabaseConsistent();
    }

    @Test
    public void testGetVcardById(){
        Vcard vcard = vcardDao.getVcardById(1L);
        Assert.assertEquals(1L, vcard.getVcardId());
    }
  @Test
  @ExpectedDataSet("VcardDaoTest-expected-dataset.xml")
   public void testUpdateVcardById(){

      Vcard vcard = vcardDao.getVcardById(1L);
      vcard.setEmail("sazzad14@yahoo.com");
      vcardDao.updateVcardByUser(vcard);

  }

}
