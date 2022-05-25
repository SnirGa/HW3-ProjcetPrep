package Domain.ManagementSystem;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

public class League {
    Hashtable <Integer, LeagueSeason> leagueSeasonDict;
    String name;
    UnionRepresentive unionRepresentive;
    public League(String name, UnionRepresentive ur) {
        leagueSeasonDict = new Hashtable<>();
        this.name = name;
        this.unionRepresentive= ur;
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



