package org.elsys.dao;

import org.elsys.entity.Theme;

public interface ThemeDao {
    void insert(Theme theme);
    void update(Theme theme);
    void delete(long id);
    Theme findById(long id);
    Theme findByName(String name);
}
