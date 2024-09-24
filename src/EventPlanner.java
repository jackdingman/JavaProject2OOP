import java.awt.*;
import java.time.LocalDateTime;
import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.JFrame;



public class EventPlanner extends JPanel {

    JFrame frame = new JFrame("Event Planner"); //creation of JFrame
    frame.setPreferredSize(670, 50);                 //set size of jFrame for EventPlanner which will add the list of events.

    public static void addDefaultEvents(EventPanel events) {

        LocalDateTime deadline = LocalDateTime.of(2024, 12, 7, 17, 0); // deadline parameters
        Deadline firstDeadline = new Deadline("First Deadline", deadline.minusDays(20) ); //deadline object creation for output

        LocalDateTime start = LocalDateTime.of(2024, 10, 7, 15, 0); // taken from EventTester.java
        LocalDateTime end = LocalDateTime.of(2024, 10, 7, 16, 0); // start point, end point, and location used to create Meeting object for panel output
        String location = "MCS 321";

        Meeting firstMeeting = new Meeting("First Meeting", start, end, location);

        //will need to add these events to the EventListPanel
    }
}