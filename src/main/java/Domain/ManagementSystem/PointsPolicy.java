package Domain.ManagementSystem;

import java.util.ArrayList;
    public class PointsPolicy {

        ArrayList<LeagueSeason> lstLeagueSeason;
        public PointsPolicy() { lstLeagueSeason = new ArrayList<>(); }

        public void addLstLeagueSeason(LeagueSeason leagueSeason) { this.lstLeagueSeason.add(leagueSeason); }
        public ArrayList<LeagueSeason> getLstLeagueSeason() { return this.lstLeagueSeason; }
    }
