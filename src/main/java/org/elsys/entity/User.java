package org.elsys.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")

    private long id;

    @Column(name = "name")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "created_on")
    private Date createdDate;

    @Column(name = "email")
    private String email;

    @Column(name = "picture")
    private String picture;

    @Column(name = "fb_id", columnDefinition="TEXT")
    private String facebookId;

    @Column(name = "google_id", columnDefinition="TEXT")
    private String googleId;

    public User() {
    }

    public User(String username, String password, String email, String picture, Date createdDate, String facebookId, String googleId) {
        this.username = username;
        this.email = email;
        this.picture = picture;
        this.password = password;
        this.createdDate = createdDate;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}