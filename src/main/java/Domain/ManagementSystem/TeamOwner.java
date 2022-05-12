package Domain.ManagementSystem;

public class TeamOwner extends EnrolledUser {
    private Team team;

    public TeamOwner(int userId, String userName, String password, String name) {
        super(userId, userName, password, name);
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

    //Asset object???
    public void addAsset(){
        //ToDo
    }

    public void removeAsset(){
        //ToDo
    }
    //Income object???
    public void reportIncome(){
        //ToDo
    }
    //Expense object???
    public void reportExpense(){
        //ToDo
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
