package Domain.ManagementSystem;

public class GameEvent {
    EventType type;
    Time time;
    int minute;
    String description;

    public GameEvent(EventType type, Time time, int minute, String description) {
        this.type = type;
        this.time = time;
        this.minute = minute;
        this.description = description;
    }

    public Time getTime() {
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

    public void setTime(Time time) {
        this.time = time;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
