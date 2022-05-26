package Domain.ManagementSystem;

import java.io.Serializable;

public class GameScore  implements Serializable {
    private int homeScore;
    private int awayScore;
    private String result;

    public GameScore(){
        this.homeScore = 0;
        this.awayScore = 0;
        this.result = "Draw";
    }

    public void setHomeScore(int homeScore) {
        this.homeScore = homeScore;
    }

    public void setAwayScore(int awayScore) {
        this.awayScore = awayScore;
    }

    public int getAwayScore() {
        return awayScore;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public void setScore(int home_score, int away_score) {
        this.homeScore = home_score;
        this.awayScore = away_score;
    }
}
