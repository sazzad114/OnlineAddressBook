package net.therap.dao;

import net.therap.domain.User;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: sazzadur
 * Date: 6/26/12
 * Time: 3:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserDaoImpl extends HibernateDaoSupport implements UserDao{

    public void saveUser(User user) {
        Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
        session.save(user);
        session.flush();
    }

    public User getUserByEmail(String email) {
         Object[] objects = new Object[1];
        objects[0] = email;
        List<User> userList = getHibernateTemplate().find(" from User as user where user.email = ? ", objects);

        if (userList.size() == 0) {
            return null;
        } else {
            return userList.get(0);
        }
    }
}
