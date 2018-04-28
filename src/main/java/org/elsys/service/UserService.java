package org.elsys.service;

import org.elsys.dao.Impl.UserDaoImpl;
import org.elsys.entity.User;

public class UserService {

    private UserDaoImpl userDao;

    public UserService() {
        userDao = new UserDaoImpl();
    }

    public void register(String name, String password, String facebook_token, String google_token) {

    }

    public void login() {
    }

    public User getUserByName(String name) {
        userDao.openCurrentSession();
        User user = userDao.findByUsername(name);
        userDao.closeCurrentSession();
        return user;
    }
}
