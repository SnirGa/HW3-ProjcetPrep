package Domain.ManagementSystem;

import java.util.*;

public class Referee extends EnrolledUser {
    private String qualification;
    private ArrayList<Game> games;
    private ArrayList<GameEventSet> gameEventSets;
    private Hashtable<String, HashSet<Integer>> leagueSeasonDict;

    public Referee(String userName, String password, String name, String qualification) {
        super(userName, password, name);
        this.qualification = qualification;
        this.games = new ArrayList<>();
        this.gameEventSets = new ArrayList<>();
        this.leagueSeasonDict = new Hashtable<>();
    }

    public String getQualification() {
        return qualification;
    }

    public ArrayList<Game> getGames() {
        return games;
    }

    public ArrayList<GameEventSet> getGameEventSets() {
        return gameEventSets;
    }

    public void setQualification(String Qualification) {
        this.qualification = Qualification;
    }

    public void setGameEventSets(ArrayList<GameEventSet> gameEventSets) {
        this.gameEventSets = gameEventSets;
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
}
