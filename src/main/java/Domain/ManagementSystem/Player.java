package Domain.ManagementSystem;
import java.util.Date;

public class Player extends EnrolledUser {
    private Date birthday;
    private FilledRole filledRole;

    public Player(String userName, String password, String name, Date birthday, FilledRole filledRole) {
        super(userName, password, name);
        this.birthday = birthday;
        this.filledRole = filledRole;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setFilledRole(FilledRole filledRole) {
        this.filledRole = filledRole;
    }

    public Date getBirthday() {
        return birthday;
    }

    public FilledRole getFilledRole() {
        return filledRole;
    }
}
