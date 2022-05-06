package Domain.ManagementSystem;

import java.util.ArrayList;

public class GameEventSet {
    public Referee getReferee() {
        //Should return the referee object
        return new Referee(1,"dsc","csdc","dcsc");
    }

    public ArrayList<GameEvent> getGameEvents() {
        //should return the gameEvents (list)
        return new ArrayList<>();
    }
}
