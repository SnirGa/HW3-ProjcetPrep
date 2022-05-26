package DataAccess;

import Domain.ManagementSystem.League;
import Domain.ManagementSystem.LeagueSeason;
import Domain.ManagementSystem.Referee;
import Domain.ManagementSystem.UnionRepresentative;

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
        else if (username.equals("ChampionWithOutLeagueSeason")){
            UnionRepresentative ur = new UnionRepresentative("SnirTheKing", "123456", "SnirGa");
            League leagueWithOutLeagueSeason = new League("ChampionWithOutLeagueSeason", ur);
            return Optional.of(leagueWithOutLeagueSeason);
        }
        return Optional.empty();
//        return null;
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
