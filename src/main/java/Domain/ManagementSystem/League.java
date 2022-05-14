package Domain.ManagementSystem;

import java.util.ArrayList;
    public class League {

        ArrayList<LeagueSeason> lstLeagueSeason;
        public League() { lstLeagueSeason = new ArrayList<>(); }

        public void addLstLeagueSeason(LeagueSeason leagueSeason) {
            this.lstLeagueSeason.add(leagueSeason);
        }
        public ArrayList<LeagueSeason> getLstLeagueSeason() {
            return this.lstLeagueSeason;
        }
    }
