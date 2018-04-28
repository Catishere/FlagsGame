package org.elsys.dao;

import org.elsys.entity.Achievement;

public interface AchievementDao {
    void insert(Achievement achievement);
    void update(Achievement achievement);
    void delete(long id);
    Achievement findById(long id);
    Achievement findByName(String name);
}
