package Domain.ManagementSystem;

import java.io.Serializable;
import java.util.ArrayList;

public class PointsPolicy implements Serializable {
    ArrayList<LeagueSeason> lstLeagueSeason;

    public PointsPolicy() { lstLeagueSeason = new ArrayList<>(); }

    public void addLstLeagueSeason(LeagueSeason leagueSeason) { this.lstLeagueSeason.add(leagueSeason); }
    
    public ArrayList<LeagueSeason> getLstLeagueSeason() { return this.lstLeagueSeason; }
}
