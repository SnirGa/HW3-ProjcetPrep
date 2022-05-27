package Domain.ManagementSystem;

import java.io.Serializable;
import java.util.*;

public class Team implements Serializable {
    private Boolean isActive;
    private String stadium;
    private ArrayList<TeamOwner> teamOwners;
    private ArrayList<TeamManager> teamManagers;
    private ArrayList<Coach> coaches;
    private ArrayList<Player> players;
    private ArrayList<Game> homeGames;
    private ArrayList<Game> awayGames;
    private Hashtable<String, HashSet<Integer>> leagueSeasonDict;

    public Team(Boolean isActive, String stadium, ArrayList<TeamOwner> teamOwner) {
        this.isActive = isActive;
        this.stadium = stadium;
        this.teamOwners = teamOwner;
        this.teamManagers = new ArrayList<>();
        this.coaches = new ArrayList<>();
        this.players = new ArrayList<>();
        this.homeGames = new ArrayList<>();
        this.awayGames = new ArrayList<>();
        this.leagueSeasonDict = new Hashtable<>();
    }

    public String getStatus(){
        if (this.isActive){
            return "Active";
        }
        return "notActive";
    }

    public String getStadium() {
        return stadium;
    }

    public ArrayList<TeamOwner> getTeamOwners() {
        return teamOwners;
    }

    public ArrayList<TeamManager> getTeamManagers() {
        return teamManagers;
    }

    public ArrayList<Coach> getCoaches() {
        return coaches;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public ArrayList<Game> getHomeGames() {
        return homeGames;
    }

    public ArrayList<Game> getAwayGames() {
        return awayGames;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public void setTeamOwners(ArrayList<TeamOwner> teamOwners) {
        this.teamOwners = teamOwners;
    }

    public void setTeamManagers(ArrayList<TeamManager> teamManagers) {
        this.teamManagers = teamManagers;
    }

    public void setCoaches(ArrayList<Coach> coaches) {
        this.coaches = coaches;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public void setHomeGames(ArrayList<Game> homeGames) {
        this.homeGames = homeGames;
    }

    public void setAwayGames(ArrayList<Game> awayGames) {
        this.awayGames = awayGames;
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

    public void openTeam(){}

    public void closeTeam(){}

}
