import java.time.*;

public class Meeting extends Event implements Completable {
    LocalDateTime endDateTime; // the time the meeting is over
    String location;           //represents the location of the event
    String name;               //name of the event
    private boolean complete;

    public Meeting(String name, LocalDateTime dateTime, LocalDateTime endDateTime, String location) {
        this.name = name;                   //saving all the parameters as instance variables.
        this.endDateTime = endDateTime;
        this.location = location;
        this.dateTime = dateTime;
    }

    @Override
    public void complete(){                 // sets the complete boolean to true;
        complete = true;
    }

    public boolean isComplete(){            // returns the complete boolean.
        return complete;
    }

    public LocalDateTime getEndTime(){      //endDateTime getter
        return endDateTime;
    }

    public Duration getDuration(){
        /*int timeMinute = getDateTime().getMinute();
        int timeSecond = getDateTime().getSecond();

        int endTimeMinute = getEndTime().getMinute();
        int endTimeSecond = getEndTime().getSecond();

        int durationMinute = timeMinute - endTimeMinute;
        int durationSecond = timeSecond - endTimeSecond;*/

        return Duration.between(dateTime, endDateTime);
    }

    public String getLocation(){            //Returns the location of the meeting
        return location;
    }
    public void setEndTime(LocalDateTime endDateTime){  //sets the end of the meeting
        this.endDateTime = endDateTime;                 //this instance's endDateTime variable is now equivalent to the passed parameter
    }
    public void setLocation(String location){           //sets location of the meeting
        this.location = location;
    }

}
