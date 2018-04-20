package org.elsys.dao;

import org.elsys.entity.RoomUser;
import org.elsys.entity.UserAchievement;

import java.util.List;

public interface UserAchievementDao {
    void insert(UserAchievement userAchievement);
    void update(UserAchievement userAchievement);
    void delete(long id);

    UserAchievement findById(long id);

    List<UserAchievement> findByUserId(long id);
}
