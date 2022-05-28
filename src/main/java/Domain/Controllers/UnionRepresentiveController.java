package Domain.Controllers;

import DataAccess.Dao;
import DataAccess.LeagueDaoMongoDB;
import DataAccess.RefereeDaoMongoDB;
import Domain.ManagementSystem.*;

public class UnionRepresentiveController {
    private final Dao<Referee> rMDB;
    private final Dao<League> leagueMDB;

    public UnionRepresentiveController() {
        rMDB = RefereeDaoMongoDB.getInstance();
        leagueMDB = LeagueDaoMongoDB.getInstance();
    }

    // For test only
    public UnionRepresentiveController(Dao lc, Dao rmdb) {
        this.rMDB = rmdb;
        this.leagueMDB = lc;
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
        if (leagueMDB.get(leagueName).isPresent()) { // If found league
            League league = leagueMDB.get(leagueName).get();
                LeagueSeason leagueSeason = league.getLeagueSeasonByYear(year);
                if (leagueSeason != null){
                    if (rMDB.get(refereeUserName).isPresent()){
                        Referee referee = rMDB.get(refereeUserName).get();
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
                    else
                        throw new Exception("Referee does not exist in DB");
                }
                else
                    throw new Exception("LeagueSeason does not exist in DB");
            }
        return false;
    }

    public boolean ApplySchedulingPolicy(String leagueName, int year, GameSchedulingPolicy gameSchedulingPolicy) throws Exception {
        // check all arguments are not null throw Exception if yes
        if(leagueName == null)
            throw new Exception("LeagueName have to be entered");
        if(year < 1)
            throw new Exception("Year can't be 0");
        if(gameSchedulingPolicy == null)
            throw new Exception("gameSchedulingPolicy have to be entered");
        // Apply Game Scheduling Policy on League Season
        // league exist
        if (leagueMDB.get(leagueName).isPresent()) {
            League league = leagueMDB.get(leagueName).get();
            LeagueSeason leagueSeason = league.getLeagueSeasonByYear(year);
            if (leagueSeason != null) {
                if (leagueSeason.setGameSchedulingPolicy(gameSchedulingPolicy)) {
                    if (gameSchedulingPolicy.ApplyGamePolicy(leagueSeason)) {
                        leagueMDB.update(league);
                        return true;
                    }
                    else
                        throw new Exception("LeagueSeason must have teams and startDate");
                }
                else
                    throw new Exception("LeagueSeason already have applied Game Scheduling Policy");
            }
            else
                throw new Exception("LeagueSeason does not exist in DB");
        }
        return false;
    }
}
