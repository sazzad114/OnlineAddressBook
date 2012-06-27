package net.therap.dao;

import net.therap.domain.User;

/**
 * Created by IntelliJ IDEA.
 * User: sazzadur
 * Date: 6/26/12
 * Time: 3:05 PM
 * To change this template use File | Settings | File Templates.
 */
public interface UserDao {
    public User getUserByEmail(String email);

    public void saveUser(User user);

    public User getUserById(long id);
}
