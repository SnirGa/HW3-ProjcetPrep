package Domain.ManagementSystem;

import java.util.ArrayList;

public class Referee extends EnrolledUser {
    private String qualification;
    private ArrayList<Game> games;
    private ArrayList<GameEventSet> gameEventSets;
    private ArrayList<LeagueSeason> leagueSeasons;


    public Referee(String userName, String password, String name, String qualification) {
        super(userName, password, name);
        this.qualification = qualification;
        this.games = new ArrayList<>();
        this.gameEventSets = new ArrayList<>();
        this.leagueSeasons = new ArrayList<>();
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

    public ArrayList<LeagueSeason> getLeagueSeasons() {
        return leagueSeasons;
    }

    public void setGameEventSets(ArrayList<GameEventSet> gameEventSets) {
        this.gameEventSets = gameEventSets;
    }

    public void setLeagueSeasons(ArrayList<LeagueSeason> leagueSeasons) {
        this.leagueSeasons = leagueSeasons;
    }

    private void setQualification(String Qualification) {
        this.qualification = Qualification;
    }
}
