package Domain.ManagementSystem;

import java.util.ArrayList;
    public class GameSchedulingPolicy {


        ArrayList<LeagueSeason> lstLeagueSeason;
        public GameSchedulingPolicy() { lstLeagueSeason = new ArrayList<>(); }

        public void addLstLeagueSeason(LeagueSeason leagueSeason) { this.lstLeagueSeason.add(leagueSeason); }
        public ArrayList<LeagueSeason> getLstLeagueSeason() { return this.lstLeagueSeason; }

}
