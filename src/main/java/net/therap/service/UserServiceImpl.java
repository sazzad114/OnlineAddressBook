package net.therap.service;

import net.therap.dao.UserDao;
import net.therap.domain.User;

/**
 * Created by IntelliJ IDEA.
 * User: sazzadur
 * Date: 6/26/12
 * Time: 3:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserServiceImpl implements UserService{
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public User authenticateUser(String email, String password) {

        User user = userDao.getUserByEmail(email);

        if(user != null && user.getPassword().equals(password)){
            return user;
        }
        else {
            return null;
        }
    }

    public boolean isEmailExists(String email) {
        User user = userDao.getUserByEmail(email);
        if(user != null){
            return true;
        }
        return false;
    }

    public void saveUser(User user) {
        userDao.saveUser(user);
    }
}
