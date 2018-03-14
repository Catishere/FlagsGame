package org.elsys.common.entity;

import javax.persistence.*;

@Entity
@Table(name = "sessionUser")
public class SessionUser {
    @Id
    @Column(name = "sessionUser_id")
    private long id;

    @Column(name = "user_id")
    private long userId;

    @Column(name = "session_id")
    private long sessionId;

    @Column(name = "user_score")
    private int userScore;

    public SessionUser() {
    }

    public SessionUser(long userId, long sessionId, int userScore) {
        this.userId = userId;
        this.sessionId = sessionId;
        this.userScore = userScore;
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

    public long getSessionId() {
        return sessionId;
    }

    public void setSessionId(long sessionId) {
        this.sessionId = sessionId;
    }

    public int getUserScore() {
        return userScore;
    }

    public void setUserScore(int userScore) {
        this.userScore = userScore;
    }
}