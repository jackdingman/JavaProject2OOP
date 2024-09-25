import javax.swing.*;
import java.awt.*;
import java.time.*;
import java.awt.event.ActionEvent;

public class EventPanel extends JPanel {

     Event event; // event object for display
     JButton completeButton; //button for expressing completion of event.

     public EventPanel(Event event){
         this.event = event; // makes the parameter event local to this instance

         if(event instanceof Completable){ // checks to see if the event is part of the Completable interface
             completeButton = new JButton("Complete"); //add button for marking of completion
             completeButton.addActionListener((ActionEvent e)->{//when button is clicked...
                 ((Completable)event).complete(); //event instance is casted as Completable, and marked complete

             });
             add(completeButton, BorderLayout.WEST);

         }
         JLabel eventLabel = new JLabel("Event:" + event.getName());
         add(eventLabel, BorderLayout.CENTER);

         JLabel dateTimeLabel = new JLabel(event.getDateTime().toString());
         add(dateTimeLabel, BorderLayout.SOUTH);

         if (event instanceof Meeting){
             Meeting meeting = (Meeting)event; //event casted as meeting
             //Duration duration = Duration.between(event.getDateTime(),meeting.getDateTime()); // calculate duration
             add(new JLabel("Location: " + meeting.getLocation())); //getLocation from meeting class
             add(new JLabel("Duration: " + meeting.getDuration().toHours())); //getDuration from meeting class
         }
         if (event instanceof Completable){
             Completable correctEvent = (Completable)event;
             add(new JLabel("Completion - " + (correctEvent.isComplete()?"Complete":"Not Complete")));

         }

     }

}
