package Domain.ManagementSystem;
import java.util.Date;

public class Player {
    private Date birthday;
    private FilledRole filledRole;

    public Player(Date birthday, FilledRole filledRole) {
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
