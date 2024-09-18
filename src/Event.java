import java.time.*;

abstract class Event implements Comparable<Event> {

    String name;                            //name of the event
    LocalDateTime dateTime;                 //time and date that the event starts

    //String methods are abstract because they will have unique implementations, where implementation of LocalDateTime should be the same.

    public abstract String getName();                   //getter for name of the event
    public LocalDateTime getDateTime(){                 //getter for dateTime
        return dateTime;
    }
    public void setDateTime(LocalDateTime dateTime) {   //sets the dateTime
    this.dateTime = dateTime;
    }
    public abstract void setName(String name);          //sets name of the event

    @Override
    public int compareTo(Event o) {
        return 0;
    }
}
