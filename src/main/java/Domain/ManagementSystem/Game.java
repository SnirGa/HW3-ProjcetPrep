package Domain.ManagementSystem;

import java.time.LocalDate;
import java.util.ArrayList;

public class Game {
    //TODO: check if need to add referees.
    private LocalDate date;
    private Team home;
    private Team away;
    private Time time;
    private String location;
    private GameScore gameScore;
    private ArrayList<GameEventSet> gameEventSets;
    private LeagueSeason leagueSeason;

    public Game(LocalDate date, Team home, Team away, Time time, String location, LeagueSeason leagueSeason) {
        this.date = date;
        this.home = home;
        this.away = away;
        this.time = time;
        this.location = location;
        this.leagueSeason = leagueSeason;
        this.gameScore=new GameScore();
        this.gameEventSets=new ArrayList<>();
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Team getHome() {
        return home;
    }

    public void setHome(Team home) {
        this.home = home;
    }

    public Team getAway() {
        return away;
    }

    public void setAway(Team away) {
        this.away = away;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public LeagueSeason getLeagueSeason() {
        return leagueSeason;
    }

    public void setLeagueSeason(LeagueSeason leagueSeason) {
        this.leagueSeason = leagueSeason;
    }

    public GameScore getGameScore() {
        return gameScore;
    }

    public ArrayList<GameEventSet> getGameEventSets() {
        return gameEventSets;
    }

    public void addGameEventSet(GameEventSet gameEventSet){
        gameEventSets.add(gameEventSet);
    }

    public void  setGameScore(int home_score,int away_score){
        gameScore.setScore(home_score,away_score);
    }

    public String getEventReport(){
        String report="##Event Report##\n";
        for (int i=0;i<gameEventSets.size();i++){
            GameEventSet gameEventSet=gameEventSets.get(i);
            Referee referee=gameEventSet.getReferee();
            String refereeName=referee.getName();
            report=report+"Refree: "+refereeName+":\n";
            ArrayList<GameEvent> gameEvents=gameEventSet.getGameEvents();
            for (int j=0; j<gameEvents.size();j++){
                GameEvent gameEvent=gameEvents.get(i);
                String type=gameEvent.getEventType().toString();
                report=report+"Type: "+ type+"\n";
                String time=String.valueOf(gameEvent.getTime().getHour())+":"+String.valueOf(gameEvent.getTime().getMinute());
                report=report+"Time: "+ time+"\n";
                String minute=String.valueOf(gameEvent.getMinute());
                report=report+"Minute: "+ minute+"\n";
                String description=gameEvent.getDescription();
                report=report+"Description"+description+"\n";
                report=report+"______";

            }
        }
        return report;
    }
}


