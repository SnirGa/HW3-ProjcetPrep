package Domain.ManagementSystem;

import java.util.ArrayList;

public class TeamManager extends EnrolledUser {
    ArrayList<String>Permissions;
    private Team team;

    public TeamManager(int userId, String userName, String password, String name, ArrayList<String> permissions) {
        super(userId, userName, password, name);
        Permissions = permissions;
    }

    public ArrayList<String> getPermissions() {
        return Permissions;
    }

    public void setPermissions(ArrayList<String> permissions) {
        Permissions = permissions;
    }

    public void addPermission(String permission){
        Permissions.add(permission);
    }

    public void deletePermission(String permission){
        Permissions.remove(permission);
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
