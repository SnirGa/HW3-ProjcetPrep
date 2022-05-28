package DataAccess;

import Domain.ManagementSystem.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

public class LeagueDaoMongoDBStub extends Dao {

    private static final LeagueDaoMongoDBStub instance = new LeagueDaoMongoDBStub();

    private LeagueDaoMongoDBStub(){}

    public static LeagueDaoMongoDBStub getInstance(){ return instance;}


    @Override
    public Optional get(String username) {
        RefereeDaoMongoDBStub refereeDaoMongoDBStub = RefereeDaoMongoDBStub.getInstance();

        if (username.equals("Champion")){
            UnionRepresentative ur = new UnionRepresentative("SnirTheKing", "123456", "SnirGa");
            League league = new League("Champion", ur);
            LocalDate startDate = LocalDate.of(2022,1,1);
            LocalDate endDate = LocalDate.of(2022,12,1);
            LeagueSeason leagueSeason = new LeagueSeason(league, 2022, startDate, endDate);
            Referee refereeYossi = new Referee("Yossi", "Yossi1", "yossi","1");
            refereeDaoMongoDBStub.addReferee(refereeYossi);
            leagueSeason.addReferee(refereeYossi);
            league.addLeagueSeason(leagueSeason);
            //return league("Champion"), that contain 1 leagueSeason (with 1 referee:"Yossi")
            return Optional.of(league);
        }
        else if (username.equals("ChampionWithGameSchedulingPolicy")){
            UnionRepresentative ur = new UnionRepresentative("SnirTheKing", "123456", "SnirGa");
            League leagueWithGameSchedulingPolicy = new League("ChampionWithGameSchedulingPolicy", ur);
            LocalDate startDate = LocalDate.of(2022,1,1);
            LocalDate endDate = LocalDate.of(2022,12,1);
            LeagueSeason leagueSeason = new LeagueSeason(leagueWithGameSchedulingPolicy, 2022, startDate, endDate);
            leagueSeason.addTeam(new Team(true,"Team1",null));
            leagueSeason.addTeam(new Team(true,"Team2",null));
            GameSchedulingPolicy1Game gameSchedulingPolicy = new GameSchedulingPolicy1Game();
            leagueSeason.setGameSchedulingPolicy(gameSchedulingPolicy);
            gameSchedulingPolicy.ApplyGamePolicy(leagueSeason);
            leagueWithGameSchedulingPolicy.addLeagueSeason(leagueSeason);
            return Optional.of(leagueWithGameSchedulingPolicy);
        }
        else if (username.equals("ChampionWithOutTeamsAndStartDate")) {
            UnionRepresentative ur = new UnionRepresentative("SnirTheKing", "123456", "SnirGa");
            League leagueWithOutTeamsAndStartDate = new League("ChampionWithOutTeamsAndStartDate", ur);
            LocalDate endDate = LocalDate.of(2022,12,1);
            LeagueSeason leagueSeason = new LeagueSeason(leagueWithOutTeamsAndStartDate, 2022, null, endDate);
            leagueWithOutTeamsAndStartDate.addLeagueSeason(leagueSeason);
            return Optional.of(leagueWithOutTeamsAndStartDate);
        }
        else if (username.equals("ChampionWithOutTeams")) {
            UnionRepresentative ur = new UnionRepresentative("SnirTheKing", "123456", "SnirGa");
            League leagueWithOutTeams = new League("ChampionWithOutTeams", ur);
            LocalDate startDate = LocalDate.of(2022,1,1);
            LocalDate endDate = LocalDate.of(2022,12,1);
            LeagueSeason leagueSeason = new LeagueSeason(leagueWithOutTeams, 2022, startDate, endDate);
            leagueWithOutTeams.addLeagueSeason(leagueSeason);
            return Optional.of(leagueWithOutTeams);
        }
        else if (username.equals("ChampionWithOutStartDate")) {
            UnionRepresentative ur = new UnionRepresentative("SnirTheKing", "123456", "SnirGa");
            League leagueWithOutStartDate = new League("ChampionWithOutStartDate", ur);
            LocalDate endDate = LocalDate.of(2022,12,1);
            LeagueSeason leagueSeason = new LeagueSeason(leagueWithOutStartDate, 2022, null, endDate);
            leagueSeason.addTeam(new Team(true,"Team1",null));
            leagueSeason.addTeam(new Team(true,"Team2",null));
            leagueWithOutStartDate.addLeagueSeason(leagueSeason);
            return Optional.of(leagueWithOutStartDate);
        }
        else if (username.equals("ChampionWithOutLeagueSeason")){
            UnionRepresentative ur = new UnionRepresentative("SnirTheKing", "123456", "SnirGa");
            League leagueWithOutLeagueSeason = new League("ChampionWithOutLeagueSeason", ur);
            return Optional.of(leagueWithOutLeagueSeason);
        }
        return Optional.empty();
    }

    @Override
    public ArrayList getAll() {
        return null;
    }

    @Override
    public void save(Object o) {

    }

    @Override
    public void update(Object o) {

    }

    @Override
    public void delete(Object o) {

    }
}
