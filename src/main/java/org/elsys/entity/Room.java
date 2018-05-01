package org.elsys.entity;

import javax.persistence.*;

@Entity
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "admin_id")
    private long adminId;

    @Column(name = "creator_id")
    private long creatorId;

    @Column(name = "current_session_id")
    private int currentSession;

    public Room(String name, long adminId, long creatorId, int currentSession) {
        this.name = name;
        this.adminId = adminId;
        this.creatorId = creatorId;
        this.currentSession = currentSession;
    }

    public Room() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getAdminId() {
        return adminId;
    }

    public void setAdminId(long adminId) {
        this.adminId = adminId;
    }

    public long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(long creatorId) {
        this.creatorId = creatorId;
    }

    public int getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(int currentSession) {
        this.currentSession = currentSession;
    }
}
