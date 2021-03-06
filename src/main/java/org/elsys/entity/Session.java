package org.elsys.entity;

import javax.persistence.*;

@Entity
@Table(name = "session")
public class Session {
    @Id
    @Column(name = "session_id")
    private long id;

    @Column(name = "player_count")
    private int playerCount;

    @Column(name = "points")
    private int points;

    public Session() {
    }

    public Session(int playerCount) {
        this.playerCount = playerCount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public void setPlayerCount(int playerCount) {
        this.playerCount = playerCount;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
