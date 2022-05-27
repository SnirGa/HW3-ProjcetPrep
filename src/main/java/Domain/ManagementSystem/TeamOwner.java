package Domain.ManagementSystem;

public class TeamOwner extends EnrolledUser {
    private Team team;

    public TeamOwner(String userName, String password, String name) {
        super(userName, password, name);
    }

    public void appointOwner(EnrolledUser user){
    }

    public void removeOwner(TeamOwner owner){
    }

    public void appointManager(EnrolledUser user) {
    }

    public void removeManager(TeamManager manager){
    }

    public void closeTeam(){
        this.team.closeTeam();
    }

    public void openTeam(){
        this.team.openTeam();
    }

    public void addAsset(){
    }

    public void removeAsset(){
    }

    public void reportIncome(){
    }

    public void reportExpense(){
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
