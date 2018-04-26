package org.elsys.dao;

import org.elsys.entity.User;

public interface UserDao {
    void insert(UserDao user);
    void update(UserDao user);
    void delete(long id);
    User findById(long id);
    User findByUsername(String name);
}
