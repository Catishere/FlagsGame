package org.elsys.service;

import org.elsys.dao.Impl.AchievementDaoImpl;
import org.elsys.dao.Impl.UserAchievementDaoImpl;
import org.elsys.entity.Achievement;
import org.elsys.entity.UserAchievement;

import java.util.Date;
import java.util.List;

public class AchievementService {

    private static AchievementDaoImpl achievementDao;
    private static UserAchievementDaoImpl userAchievementDao;

    public AchievementService() {
        achievementDao = new AchievementDaoImpl();
        userAchievementDao = new UserAchievementDaoImpl();
    }

    public void addAchievement(String name, String description) {
        achievementDao.openCurrentSessionWithTransaction();
        achievementDao.insert(new Achievement(name, description));
        achievementDao.closeCurrentSessionWithTransaction();
    }

    public void awardUser(long userId, long achievementId) {
        userAchievementDao.openCurrentSessionWithTransaction();
        userAchievementDao.insert(new UserAchievement(userId, achievementId, new Date()));
        userAchievementDao.closeCurrentSessionWithTransaction();
    }

    public List<UserAchievement> getAllAchievementsForUser(long userId) {
        userAchievementDao.openCurrentSession();
        List<UserAchievement> userAchievements = userAchievementDao.findByUserId(userId);
        userAchievementDao.closeCurrentSession();
        return userAchievements;
    }
}
