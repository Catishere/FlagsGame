package org.elsys.entity;

import javax.persistence.*;

@Entity
@Table(name = "roomUser")
public class RoomUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roomUser_id")
    private long id;

    @Column(name = "user_id")
    private long userId;

    @Column(name = "room_id")
    private long sessionId;

    @Column(name = "role")
    private String role;

    public RoomUser(long userId, long sessionId, String role) {
        this.userId = userId;
        this.sessionId = sessionId;
        this.role = role;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}