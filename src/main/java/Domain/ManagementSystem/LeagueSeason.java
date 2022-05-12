package Domain.ManagementSystem;

import Domain.RecommendationSystem.RecommendationSystem;

import java.util.ArrayList;

public class LeagueSeason {
    League league;
    UnionRepresentive unionRepresentive;
    ArrayList<Game> lstGame;
    ArrayList<Referee> lstReferee;
    ArrayList<Team> lstTeam;
    PointsPolicy pointsPolicy;
    GameSchedulingPolicy gameSchedulingPolicy;
    RecommendationSystem recommendationSystem;

    public LeagueSeason() {
        league = new League();
        //unionRepresentive = new UnionRepresentive();
        lstGame = new ArrayList<>();
        lstReferee = new ArrayList<>();
        lstTeam = new ArrayList<>();
        pointsPolicy = new PointsPolicy();
        gameSchedulingPolicy = new GameSchedulingPolicy();
        recommendationSystem = new RecommendationSystem();
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
}