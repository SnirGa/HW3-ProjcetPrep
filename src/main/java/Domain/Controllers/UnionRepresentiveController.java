package Domain.Controllers;

import DataAccess.Dao;
import DataAccess.LeagueDaoMongoDB;
import DataAccess.RefereeDaoMongoDB;
import Domain.ManagementSystem.*;

import java.util.NoSuchElementException;
import java.util.Optional;

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

    public boolean addRefTOSL(String leagueName, int year, String refereeUserName) throws Exception {
        if(leagueName == null)
            throw new Exception("LeagueName have to be entered");
        if(year <= 0)
            throw new Exception("Year can't be 0");
        if(refereeUserName == null)
            throw new Exception("refereeUserName have to be entered");
        // check all arguments are not null throw Exception if yes
        if (!leagueMDB.get(leagueName).isEmpty()) {
            League league = (League)(Object)leagueMDB.get(leagueName).get();
            LeagueSeason leagueSeason = league.getLeagueSeasonByYear(year);
            // LeagueSeason leagueSeason = getLeagueBySeason(League, year);
            try {
                Referee referee = (Referee)(Object)rMDB.get(refereeUserName).get();
                if (leagueSeason != null){
                    if(leagueSeason.getLstReferee().contains(referee)){
                        return false;
                    }
                    leagueSeason.addReferee(referee);
                    rMDB.update(referee);
                    leagueMDB.update(league);
                    return true;
                }
            }
            catch (NoSuchElementException e){
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean ApplySchedulingPolicy(String leagueName, int year, GameSchedulingPolicy gameSchedulingPolicy) throws Exception {
        if(leagueName == null)
            throw new Exception("LeagueName have to be entered");
        if(year <= 0)
            throw new Exception("Year can't be 0");
        if(gameSchedulingPolicy == null)
            throw new Exception("gameSchedulingPolicy have to be entered");

        if (!leagueMDB.get(leagueName).isEmpty()) {
            League league = (League)(Object)leagueMDB.get(leagueName).get();
            LeagueSeason leagueSeason = league.getLeagueSeasonByYear(year);
            if (leagueSeason != null && gameSchedulingPolicy.ApplyGamePolicy(leagueSeason)) {
                leagueMDB.update(league);
                return true;
            }
        }
        return false;
    }
}
