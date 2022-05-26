package Domain.ManagementSystem;

import java.io.Serializable;
import java.util.ArrayList;

public class GameEventSet implements Serializable {
    private ArrayList<GameEvent> GameEvents;
//    private Referee referee;
    private String refereeName;
    private Game game;

    public GameEventSet(Referee referee, Game game) {
//        this.referee = referee;
        this.refereeName = referee.getName();
        this.game = game;
        this.GameEvents = new ArrayList<>();
    }

    public ArrayList<GameEvent> getGameEvents() {
        return this.GameEvents;
    }

    public void setGameEvents(ArrayList<GameEvent> gameEvents) {
        GameEvents = gameEvents;
    }

//    public Referee getReferee() {
//        return this.referee;
//    }

//    public void setReferee(Referee referee) {
//        this.referee = referee;
//    }

    public String getRefereeName() {
        return refereeName;
    }

    public void setRefereeName(Referee referee) {
        this.refereeName = referee.getName();;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void addGameEvent(GameEvent gameEvent){
        GameEvents.add(gameEvent);
    }

    public void removeGameEvent(GameEvent gameEvent){
        GameEvents.remove(gameEvent);
    }
}
