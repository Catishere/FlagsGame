package org.elsys.entity;

import javax.persistence.*;

@Entity
@Table(name="achievement")
public class Achievement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "achievement_id")
    private long id;

    @Column(name="achievement_name")
    private String achievementName;

    @Column(name="achievement_description")
    private String achievementDescription;

    public Achievement() {
    }

    public Achievement(String achievementName, String achievementDescription) {
        this.achievementName = achievementName;
        this.achievementDescription = achievementDescription;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAchievementName() {
        return achievementName;
    }

    public void setAchievementName(String achievementName) {
        this.achievementName = achievementName;
    }

    public String getAchievementDescription() {
        return achievementDescription;
    }

    public void setAchievementDescription(String achievementDescription) {
        this.achievementDescription = achievementDescription;
    }
}
