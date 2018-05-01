package org.elsys.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_statistics")
public class UserStatistics {

    @Id
    @Column(name = "user_statistics_id")
    private long id;

    @Column(name = "user_id")
    private long userId;

    @Column(name = "total_games")
    private long totalGames;

    @Column(name = "total_wins")
    private long totalWins;

    @Column(name = "total_correct_answers")
    private float totalCorrectAnswers;

    public UserStatistics() {
    }

    public UserStatistics(long id, long userId, long totalGames, long totalWins, float totalCorrectAnswers) {
        this.id = id;
        this.userId = userId;
        this.totalGames = totalGames;
        this.totalWins = totalWins;
        this.totalCorrectAnswers = totalCorrectAnswers;
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

    public long getTotalGames() {
        return totalGames;
    }

    public void setTotalGames(long totalGames) {
        this.totalGames = totalGames;
    }

    public long getTotalWins() {
        return totalWins;
    }

    public void setTotalWins(long totalWins) {
        this.totalWins = totalWins;
    }

    public float getTotalCorrectAnswers() {
        return totalCorrectAnswers;
    }

    public void setTotalCorrectAnswers(float totalCorrectAnswers) {
        this.totalCorrectAnswers = totalCorrectAnswers;
    }
}
