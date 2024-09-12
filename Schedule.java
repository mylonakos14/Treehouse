import java.time.LocalTime;

class Schedule {
    private String day; 
    private LocalTime startTime; 
    private LocalTime endTime; 

    //constructor
    public Schedule(String day,LocalTime startTime,LocalTime endTime){
        this.day=day;
        this.startTime=startTime;
        this.endTime=endTime;
    }


    //getters and setters
    public String getDay(){
        return day;
    }

    public void setDay(String day){
        this.day=day;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public boolean isEqual(Schedule otherSchedule) {
        if (otherSchedule == null) {
            return false;
        }
        return this.day.equals(otherSchedule.getDay()) &&
               this.startTime.equals(otherSchedule.getStartTime()) &&
               this.endTime.equals(otherSchedule.getEndTime());
    }

}
