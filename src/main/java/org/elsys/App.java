package org.elsys;

import org.elsys.entity.Achievement;
import org.elsys.service.AchievementService;

public class App {
    public static void main( String[] args )
    {
        System.out.println("Maven + Hibernate + MySQL");
        AchievementService achievementService = new AchievementService();
        Achievement achievement = new Achievement("Win 10 games", "Win 10 Games");
        achievementService.addAchievement(achievement);
    }
}
