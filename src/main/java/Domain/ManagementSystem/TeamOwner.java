package Domain.ManagementSystem;

public class TeamOwner extends EnrolledUser {
    private Team team;

    public TeamOwner(String userName, String password, String name) {
        super(userName, password, name);
    }

    public void appointOwner(EnrolledUser user){
        //ToDo
    }

    public void removeOwner(TeamOwner owner){
        //ToDo
    }

    public void appointManager(EnrolledUser user) {
        //ToDo
    }

    public void removeManager(TeamManager manager){
        //ToDo
    }

    public void closeTeam(){
        this.team.closeTeam();
    }

    public void openTeam(){
        this.team.openTeam();
    }

    public void addAsset(){
        //Asset object???
        //ToDo
    }

    public void removeAsset(){
        //ToDo
    }

    public void reportIncome(){
        //Income object???
        //ToDo
    }

    public void reportExpense(){
        //Expense object???
        //ToDo
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
