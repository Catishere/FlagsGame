package org.elsys.entity;

import javax.persistence.*;

@Entity
@Table(name = "theme")
public class Theme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "theme_id")
    private long id;

    @Column(name = "theme_name")
    private long themeName;

    @Column(name = "theme_chosen_count")
    private long themeChosenCount;

    public Theme() {
    }

    public Theme(long themeName, long themeChosenCount) {
        this.themeName = themeName;
        this.themeChosenCount = themeChosenCount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getThemeName() {
        return themeName;
    }

    public void setThemeName(long themeName) {
        this.themeName = themeName;
    }

    public long getThemeChosenCount() {
        return themeChosenCount;
    }

    public void setThemeChosenCount(long themeChosenCount) {
        this.themeChosenCount = themeChosenCount;
    }
}
