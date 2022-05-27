package Domain.ManagementSystem;

import java.io.Serializable;
import java.time.LocalTime;

public class GameEvent implements Serializable{
    EventType type;
    LocalTime time;
    int minute;
    String description;

    public GameEvent(EventType type, LocalTime time, int minute, String description) {
        this.type = type;
        this.time = time;
        this.minute = minute;
        this.description = description;
    }

    public LocalTime getTime() {
        return time;
    }

    public int getMinute() {
        return minute;
    }

    public String getDescription() {
        return description;
    }

    public EventType getEventType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
