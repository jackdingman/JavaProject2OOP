import java.time.*;

public class Meeting extends Event implements Completable {
    LocalDateTime endDateTime; // the time the meeting is over
    //LocalDateTime startDateTime; // the time the meeting is starting
    String location;           //represents the location of the event
    String name;               //name of the event
    int duration;              //length of the meeting. Will be equivalent to dateTime-endDateTime
    private boolean complete;

    public Meeting(String name, LocalDateTime startDateTime, LocalDateTime endDateTime, String location) {
        this.name = name;
        this.endDateTime = endDateTime;
        this.location = location;
        //this.startDateTime = startDateTime;
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

    public int getDuration(){
        return duration;
    }

    public String getLocation(){            //Returns the location of the meeting
        return location;
    }

}
