package org.elsys.common.entity;

import javax.persistence.*;

@Entity
@Table(name="flag")
public class Flag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flag_id")
    private long id;

    @Column(name="flag_code")
    private String flagCode;

    @Column(name="flag_name")
    private String flagName;

    @Column(name="difficulty")
    private int difficulty;

    public Flag() {
    }

    public Flag(String flagCode, String flagName, int difficulty) {
        this.flagCode = flagCode;
        this.flagName = flagName;
        this.difficulty = difficulty;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFlagCode() {
        return flagCode;
    }

    public void setFlagCode(String flagCode) {
        this.flagCode = flagCode;
    }

    public String getFlagName() {
        return flagName;
    }

    public void setFlagName(String flagName) {
        this.flagName = flagName;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }
}
