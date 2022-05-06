package Domain.ManagementSystem;



public class GameEvent {
    EventType type;
    Time time;
    int minute;
    String description;
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
}
