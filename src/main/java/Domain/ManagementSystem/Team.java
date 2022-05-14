package Domain.ManagementSystem;

import java.util.ArrayList;
public class Team {
    Boolean isActive;
    String stadium;
    ArrayList<TeamOwner> teamOwners;
    ArrayList<TeamManager> teamManagers;
    ArrayList<Coach> coaches;
    ArrayList<Player> players;
    ArrayList<Game> homeGames;
    ArrayList<Game> awayGames;
    ArrayList<LeagueSeason> leagueSeasons;

    public Team(Boolean isActive, String stadium, ArrayList<TeamOwner> teamOwner) {
        this.isActive = isActive;
        this.stadium = stadium;
        this.teamOwners = teamOwner;
        this.teamManagers = new ArrayList<>();
        this.coaches = new ArrayList<>();
        this.players = new ArrayList<>();
        this.homeGames = new ArrayList<>();
        this.awayGames = new ArrayList<>();
        this.leagueSeasons = new ArrayList<>();
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

    public ArrayList<LeagueSeason> getLeagueSeasons() {
        return leagueSeasons;
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

    public void setLeagueSeasons(ArrayList<LeagueSeason> leagueSeasons) {
        this.leagueSeasons = leagueSeasons;
    }

    public void openTeam(){
        //ToDo
    }

    public void closeTeam(){
        //ToDo
    }
}
