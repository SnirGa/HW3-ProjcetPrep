package Domain.ManagementSystem;

public class Coach extends EnrolledUser {
    private String teamRole;
    private String qualification;
    private Team team;
    private PersonalPage personalPage;

    public Coach(String userName, String password, String name,String teamRole,String qualification) {
        super(userName, password, name);
        this.teamRole=teamRole;
        this.qualification=qualification;
        this.personalPage = new PersonalPage(userName);
    }

    public void updatePersonalPage(int age, double height, String city, String aboutMe){

    }

    public String getTeamRole() {
        return teamRole;
    }

    public void setTeamRole(String teamRole) {
        this.teamRole = teamRole;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
