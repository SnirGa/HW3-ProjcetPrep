package Domain.ManagementSystem;

import java.io.Serializable;
import java.util.Hashtable;

public class League implements Serializable {
    Hashtable <Integer, LeagueSeason> leagueSeasonDict;
    String name;
    UnionRepresentative unionRepresentative;

    public League(String name, UnionRepresentative ur) {
        leagueSeasonDict = new Hashtable<>();
        this.name = name;
        this.unionRepresentative = ur;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addLeagueSeason(LeagueSeason leagueSeason){
        leagueSeasonDict.put(leagueSeason.getYear(), leagueSeason);
    }

    public LeagueSeason getLeagueSeasonByYear(int year){
            return leagueSeasonDict.get(year);
        }

}



