package net.therap.service;

import net.therap.domain.User;

/**
 * Created by IntelliJ IDEA.
 * User: sazzadur
 * Date: 6/26/12
 * Time: 3:05 PM
 * To change this template use File | Settings | File Templates.
 */
public interface UserService {

    public User authenticateUser(String email,String password);

    public boolean isEmailExists(String email);

    public void saveUser(User user);
}
