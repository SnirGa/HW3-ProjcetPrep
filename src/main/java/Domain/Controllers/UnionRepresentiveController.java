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
        // check all arguments are not null throw Exception if yes
        if(leagueName == null)
            throw new Exception("LeagueName have to be entered");
        if(year < 1)
            throw new Exception("Year can't be 0");
        if(refereeUserName == null)
            throw new Exception("refereeUserName have to be entered");
        // add ref to league season
        if (!leagueMDB.get(leagueName).isEmpty()) { // If found league
            League league = (League)leagueMDB.get(leagueName).get();
            try {
                LeagueSeason leagueSeason = league.getLeagueSeasonByYear(year);
                if (leagueSeason != null){
                    if (rMDB.get(refereeUserName).isPresent()){
                        Referee referee = (Referee)rMDB.get(refereeUserName).get();
                        for (int i=0;i<leagueSeason.getLstReferee().size();i++){ //Check if referee already exist
                            if (leagueSeason.getLstReferee().get(i).getUserName().equals(refereeUserName)){
                                throw new Exception("Referee already exist in this LeagueSeason");
                            }
                        }
                        leagueSeason.addReferee(referee);
                        rMDB.update(referee);
                        leagueMDB.update(league);
                        return true;
                    }
                    else{
                        throw new Exception("Referee does not exist in DB");
                    }
                }
                else{
                    throw new Exception("LeagueSeason does not exist in DB");
                }
            }
            catch (Exception e){
                throw new Exception(e.getMessage());
            }
        }
        return false;
    }

    public boolean ApplySchedulingPolicy(String leagueName, int year, GameSchedulingPolicy gameSchedulingPolicy) throws Exception {
        // check all arguments are not null throw Exception if yes
        if(leagueName == null)
            throw new Exception("LeagueName have to be entered");
        if(year <= 0)
            throw new Exception("Year can't be 0");
        if(gameSchedulingPolicy == null)
            throw new Exception("gameSchedulingPolicy have to be entered");
        // Apply Game Scheduling Policy on League Season
        if (!leagueMDB.get(leagueName).isEmpty()) { // If found league
            League league = (League)leagueMDB.get(leagueName).get();
            LeagueSeason leagueSeason = league.getLeagueSeasonByYear(year);
            if (leagueSeason != null) {
                if (gameSchedulingPolicy.ApplyGamePolicy(leagueSeason)) {
                    leagueSeason.setGameSchedulingPolicy(gameSchedulingPolicy);
                    leagueMDB.update(league);
                    return true;
                }
            }
            else{
                throw new Exception("LeagueSeason does not exist in DB");
            }
        }
        return false;
    }
}
