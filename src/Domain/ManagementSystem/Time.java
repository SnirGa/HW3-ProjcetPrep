package Domain.ManagementSystem;

public class Time {
    private int hour;
    private int minute;

    public Time(int hour, int minute) throws Exception {
        if (hour>23 || hour<0 || minute>59 || minute<0){
            throw new Exception("bad parameters");
        }
        this.hour = hour;
        this.minute = minute;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }


    private String checkTime(Time time){
        if (this.getHour()<time.getHour()){
            return "beforeTime";
        }
        else if (this.getHour()==time.getHour()){
            if (this.getMinute()<time.getMinute()){
                return "beforeTime";
            }
            else if (this.getMinute()==time.getMinute()){
                return "equalTime";
            }

            else{
                return "afterTime";
            }
        }
        else{
            return "afterTime";
        }
    }

    public boolean beforeTime(Time time){
        if (this.checkTime(time)=="beforeTime"){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean afterTime(Time time){
        if (this.checkTime(time)=="afterTime"){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean equalTime(Time time){
        if (this.checkTime(time)=="equalTime"){
            return true;
        }
        else{
            return false;
        }
    }


}
