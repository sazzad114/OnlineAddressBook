package net.therap.dao;

import net.therap.domain.User;
import net.therap.domain.Vcard;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: sazzadur
 * Date: 6/27/12
 * Time: 9:20 AM
 * To change this template use File | Settings | File Templates.
 */
public class VcardDaoImpl extends HibernateDaoSupport implements VcardDao{

    public void saveVcard(Vcard vcard) {
        Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
        session.saveOrUpdate(vcard);
        session.flush();
    }

    public List<Vcard> getVcardListByUser(User user) {
      return getHibernateTemplate().find("select vcard from Vcard as vcard where vcard.user = ?",new Object[]{user});
    }

    public Vcard getVcardById(long vcardId){
        return getHibernateTemplate().get(Vcard.class,vcardId);
    }

    public void updateVcardByUser(Vcard vcard) {
        Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
        session.update(vcard);
        session.flush();
    }

    public void deleteVcardByUser(User user,Vcard vcard){

        Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
        Query query = session.createQuery("delete Vcard as vcard where vcard.user = :user and vcard = :vcard");
        query.setParameter("user",user);
        query.setParameter("vcard", vcard);
        query.executeUpdate();
        session.flush();
    }
}
