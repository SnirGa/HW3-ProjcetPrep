package Domain.ManagementSystem;

import Domain.RecommendationSystem.RecommendationSystem;

import java.time.LocalDate;
import java.util.ArrayList;

public class LeagueSeason {
    private League league;
    private int year;
    private LocalDate startDate;
    private LocalDate finishDate;
    private UnionRepresentive unionRepresentive;
    private ArrayList<Game> lstGame;
    private ArrayList<Referee> lstReferee;
    private ArrayList<Team> lstTeam;
    private PointsPolicy pointsPolicy;
    private GameSchedulingPolicy gameSchedulingPolicy;
    private RecommendationSystem recommendationSystem;

    public LeagueSeason(League l, int y, LocalDate startdate, LocalDate finishdate) {
        league = l;
        year = y;
        startDate = startdate;
        finishDate = finishdate;
        lstGame = new ArrayList<>();
        lstReferee = new ArrayList<>();
        lstTeam = new ArrayList<>();
        pointsPolicy = new PointsPolicy();
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

    public void addReferee(Referee referee)
    {
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

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    public UnionRepresentive getUnionRepresentive() {
        return unionRepresentive;
    }

    public void setUnionRepresentive(UnionRepresentive unionRepresentive) {
        this.unionRepresentive = unionRepresentive;
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

    public GameSchedulingPolicy getGameSchedulingPolicy() {
        return gameSchedulingPolicy;
    }

    public void setGameSchedulingPolicy(GameSchedulingPolicy gameSchedulingPolicy) {
        this.gameSchedulingPolicy = gameSchedulingPolicy;

    }

    public RecommendationSystem getRecommendationSystem() {
        return recommendationSystem;
    }

    public void setRecommendationSystem(RecommendationSystem recommendationSystem) {
        this.recommendationSystem = recommendationSystem;
    }

}