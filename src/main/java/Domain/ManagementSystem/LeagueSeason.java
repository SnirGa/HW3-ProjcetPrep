package Domain.ManagementSystem;

import Domain.RecommendationSystem.RecommendationSystem;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class LeagueSeason implements Serializable {
    private String leagueName;
    private int year;
    private LocalDate startDate;
    private LocalDate finishDate;
    private ArrayList<Game> lstGame;
    private ArrayList<Referee> lstReferee;
    private ArrayList<Team> lstTeam;
    private PointsPolicy pointsPolicy;
    private String gameSchedulingPolicy;
    private RecommendationSystem recommendationSystem;

    public LeagueSeason(League l, int y, LocalDate startdate, LocalDate finishdate) {
        leagueName = l.getName();
        year = y;
        startDate = startdate;
        finishDate = finishdate;
        lstGame = new ArrayList<>();
        lstReferee = new ArrayList<>();
        lstTeam = new ArrayList<>();
        pointsPolicy = new PointsPolicy();
        gameSchedulingPolicy = null;
        recommendationSystem = new RecommendationSystem();
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return this.year;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(LocalDate finishDate) {
        this.finishDate = finishDate;
    }

    public void addGame(Game game)
    {
        this.lstGame.add(game);
    }

    public ArrayList<Game> getLstGame()
    {
        return this.lstGame;
    }

    public void addReferee(Referee referee) {
        referee.addLeagueSeason(this);
        this.lstReferee.add(referee);
    }

    public ArrayList<Referee> getLstReferee()
    {
        return this.lstReferee;
    }

    public void addTeam(Team team)
    {
        this.lstTeam.add(team);
    }

    public ArrayList<Team> getLstTeam()
    {
        return this.lstTeam;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public void setLstGame(ArrayList<Game> lstGame) {
        this.lstGame = lstGame;
    }

    public void setLstReferee(ArrayList<Referee> lstReferee) {
        this.lstReferee = lstReferee;
    }

    public void setLstTeam(ArrayList<Team> lstTeam) {
        this.lstTeam = lstTeam;
    }

    public PointsPolicy getPointsPolicy() {
        return pointsPolicy;
    }

    public void setPointsPolicy(PointsPolicy pointsPolicy) {
        this.pointsPolicy = pointsPolicy;
    }

    public String getGameSchedulingPolicy() {
        return gameSchedulingPolicy;
    }

    public Boolean setGameSchedulingPolicy(GameSchedulingPolicy gameSchedulingPolicy) {
        if (this.gameSchedulingPolicy == null && this.lstGame.isEmpty()) {
            this.gameSchedulingPolicy = gameSchedulingPolicy.getClass().getName();
            return true;
        }
        return false;
    }

    public RecommendationSystem getRecommendationSystem() {
        return recommendationSystem;
    }

    public void setRecommendationSystem(RecommendationSystem recommendationSystem) {
        this.recommendationSystem = recommendationSystem;
    }

}