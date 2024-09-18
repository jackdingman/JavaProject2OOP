import java.time.*;

abstract class Event implements Comparable<Event> {

    //Event is the superclass

    String name;                            //name of the event
    LocalDateTime dateTime;                 //time and date that the event starts

    public String getName(){//getter for name of the event
        return name;
    }
    public LocalDateTime getDateTime(){                 //getter for dateTime
        return dateTime;
    }
    public void setDateTime(LocalDateTime dateTime) {   //sets the dateTime
    this.dateTime = dateTime;
    }
    public void setName(String name){                   //sets name of the event
        this.name = name;
    }

    @Override
    public int compareTo(Event e) {
        return this.dateTime.compareTo(e.dateTime);
    }
}
