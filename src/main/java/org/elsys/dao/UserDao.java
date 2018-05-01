package org.elsys.dao;

import org.elsys.entity.User;

public interface UserDao {
    void insert(User user);
    void update(User user);
    void delete(long id);
    User findById(long id);
    User findByUsername(String name);
    User findByGoogleId(String googleId);
}
