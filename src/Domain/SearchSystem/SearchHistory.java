package Domain.SearchSystem;

import Domain.ManagementSystem.Fan;

public class SearchHistory {
    private Fan fan;

    public SearchHistory(Fan fan) {
        this.fan = fan;
    }

    public Fan getFan() {
        return fan;
    }

    public void setFan(Fan fan) {
        this.fan = fan;
    }
}
