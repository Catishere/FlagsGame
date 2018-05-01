package org.elsys.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "user_achievement")
public class UserAchievement {

    @Id
    @Column(name = "user_achievement_id")
    private long id;

    @Column(name = "user_id")
    private long userId;

    @Column(name = "achievement_id")
    private long achievementId;

    @Column(name = "unlocked_on")
    private Date unlocked_on;

    public UserAchievement() {
    }

    public UserAchievement(long userId, long achievementId, Date unlocked_on) {
        this.userId = userId;
        this.achievementId = achievementId;
        this.unlocked_on = unlocked_on;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getAchievementId() {
        return achievementId;
    }

    public void setAchievementId(long achievementId) {
        this.achievementId = achievementId;
    }

    public Date getUnlocked_on() {
        return unlocked_on;
    }

    public void setUnlocked_on(Date unlocked_on) {
        this.unlocked_on = unlocked_on;
    }
}