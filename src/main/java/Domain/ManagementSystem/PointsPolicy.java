package Domain.ManagementSystem;

import java.io.Serializable;
import java.util.*;

public class PointsPolicy implements Serializable {
    private Hashtable<String, HashSet<Integer>> leagueSeasonDict;
//    ArrayList<LeagueSeason> lstLeagueSeason;

    public PointsPolicy() {
        this.leagueSeasonDict = new Hashtable<>();
//        lstLeagueSeason = new ArrayList<>();
    }

    public void addLeagueSeason(LeagueSeason leagueSeason) {
        String leagueName = leagueSeason.getLeagueName();
        Integer leagueSeasonYear = leagueSeason.getYear();
        Set<Integer> leagueSeasons = this.leagueSeasonDict.get(leagueName);
        if (leagueSeasons!=null)
            leagueSeasons.add(leagueSeasonYear);
        else
            this.leagueSeasonDict.put(leagueName, new HashSet<>(Arrays.asList(leagueSeasonYear)));
    }

    public void removeLeagueSeason(LeagueSeason leagueSeason) {
        String leagueName = leagueSeason.getLeagueName();
        Integer leagueSeasonYear = leagueSeason.getYear();
        Set<Integer> leagueSeasons = this.leagueSeasonDict.get(leagueName);
        if (leagueSeasons!=null && leagueSeasons.contains(leagueSeasonYear))
            leagueSeasons.remove(leagueSeasonYear);
    }

    public Hashtable<String, HashSet<Integer>> getLeagueSeasonDict() {
        return leagueSeasonDict;
    }

    public void setLeagueSeasonDict(Hashtable<String, HashSet<Integer>>leagueSeasonDict) {
        this.leagueSeasonDict = leagueSeasonDict;
    }

//    public void addLstLeagueSeason(LeagueSeason leagueSeason) { this.lstLeagueSeason.add(leagueSeason); }
//
//    public ArrayList<LeagueSeason> getLstLeagueSeason() { return this.lstLeagueSeason; }
}
