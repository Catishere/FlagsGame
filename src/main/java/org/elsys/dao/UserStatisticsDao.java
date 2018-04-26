package org.elsys.dao;

import org.elsys.entity.UserAchievement;
import org.elsys.entity.UserStatistics;

import java.util.List;

public interface UserStatisticsDao {
    void insert(UserStatistics userStatistics);
    void update(UserStatistics userStatistics);
    void delete(long id);
    List<UserStatistics> findByUserId(long id);
}
