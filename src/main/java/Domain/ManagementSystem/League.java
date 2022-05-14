package Domain.ManagementSystem;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

public class League {
    Hashtable <Integer, LeagueSeason> leagueSeasonDict;
        public League() {
            leagueSeasonDict = new Hashtable<>();
        }


        public void addLeagueSeason(LeagueSeason leagueSeason){
            leagueSeasonDict.put(leagueSeason.getYear(), leagueSeason);
        }

        public LeagueSeason getLeagueSeasonByYear(int year){
            return leagueSeasonDict.get(year);
        }
    }
