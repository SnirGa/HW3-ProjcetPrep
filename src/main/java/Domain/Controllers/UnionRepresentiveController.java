package Domain.Controllers;

import DataAccess.Dao;
import DataAccess.LeagueDaoMongoDB;
//import DataAccess.UnionRepresentiveMongoDB;
import DataAccess.RefereeDaoMongoDB;
import Domain.ManagementSystem.*;

import java.util.NoSuchElementException;

public class UnionRepresentiveController extends EnrollledUserController{
    Dao rMDB;
    Dao leagueMDB;

    public UnionRepresentiveController() {
        rMDB = RefereeDaoMongoDB.getInstance();
        leagueMDB = LeagueDaoMongoDB.getInstance();
    }

    public UnionRepresentiveController(Dao lc, Dao rmdb) {
        if(rmdb == null){
            rMDB = RefereeDaoMongoDB.getInstance();
        }
        else {
            rMDB = rmdb;
        }
        if(lc == null){
            leagueMDB = LeagueDaoMongoDB.getInstance();
        }
        else{
            leagueMDB = lc;
        }
    }

    public boolean addRefTOSL(String league, int year, String refereeUserName) {
        // check all arguments are not null throw Exception if yes
        LeagueSeason leagueSeason = getLeagueBySeason(league, year);
        try {
            Referee referee = (Referee)(Object)rMDB.get(refereeUserName).get();
            if (leagueSeason != null){
                if(leagueSeason.getLstReferee().contains(referee)){
                    return false;
                }
                leagueSeason.addReferee(referee);
                rMDB.update(referee);
                leagueMDB.update(leagueSeason.getLeague());
                return true;
            }
            return false;
        }
        catch (NoSuchElementException e){
            return false;
        }
    }

    public boolean ApplySchedulingPolicy(String League, int year, GameSchedulingPolicy gameSchedulingPolicy) {
        LeagueSeason leagueSeason = getLeagueBySeason(League, year);
        if(gameSchedulingPolicy == null){
            return false;
        }
        if (leagueSeason != null){
            leagueSeason.setGameSchedulingPolicy(gameSchedulingPolicy);
            return gameSchedulingPolicy.ApplyGamePolicy(leagueSeason);
        }
        return false;
    }

    public LeagueSeason getLeagueBySeason(String League, int year){
        if (leagueMDB.get(League).isPresent()){
            League league = (League)(Object)leagueMDB.get(League).get();
            return league.getLeagueSeasonByYear(year);
        }
        return null;
    }

}
