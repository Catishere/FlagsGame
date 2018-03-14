package org.elsys.common.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private long id;

    @Column(name = "name")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "created_on")
    private Date createdDate;

    @Column(name = "total_games")
    private int totalGames;

    @Column(name = "total_score")
    private int totalScore;

    @Column(name = "fb_id")
    private String facebookId;

    @Column(name = "google_id")
    private String googleId;

    public User() {
    }

    public User(String username, String password, Date createdDate, int totalGames, int totalScore, String facebookId, String googleId) {
        this.username = username;
        this.password = password;
        this.createdDate = createdDate;
        this.totalGames = totalGames;
        this.totalScore = totalScore;
        this.facebookId = facebookId;
        this.googleId = googleId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public int getTotalGames() {
        return totalGames;
    }

    public void setTotalGames(int totalGames) {
        this.totalGames = totalGames;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public String getFacebookId() {
        return facebookId;
    }

    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId;
    }

    public String getGoogleId() {
        return googleId;
    }

    public void setGoogleId(String googleId) {
        this.googleId = googleId;
    }
}