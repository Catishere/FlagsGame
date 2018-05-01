package org.elsys.service;

import org.elsys.dao.Impl.UserDaoImpl;
import org.elsys.entity.User;

import java.util.Date;

public class UserService {

    private UserDaoImpl userDao;

    public UserService() {
        userDao = new UserDaoImpl();
    }
    public User register(String name, String password, String facebook_token, String google_token, String email, String picture) {
        User user = new User(name, password, email, picture, new java.util.Date(), facebook_token, google_token);
        userDao.openCurrentSessionWithTransaction();
        userDao.insert(user);
        userDao.closeCurrentSessionWithTransaction();
        return user;
    }

    public void login() {
    }

    public User getUserByName(String name) {
        userDao.openCurrentSession();
        User user = userDao.findByUsername(name);
        userDao.closeCurrentSession();
        return user;
    }

    public User getUserByGoogleID(String googleId) {
        userDao.openCurrentSession();
        User user = userDao.findByGoogleId(googleId);
        userDao.closeCurrentSession();
        return user;
    }
}
