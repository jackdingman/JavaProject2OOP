import java.awt.*;
import java.time.LocalDateTime;
import javax.swing.*;

public class EventPlanner extends JPanel { //includes main method responsible for creating JFrame and adding it to EventListPANEL


    public static void main(String[] args) {

        JFrame frame = new JFrame("Event Planner"); //creation of JFrame

        frame.setPreferredSize(new Dimension(670, 50));     //set preferred size of jFrame for EventPlanner which will add the list of events.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);           //Exit upon clicking x
        frame.setBackground(new Color(150,150,50));            //Background color declaration

        EventListPanel eventListPanel = new EventListPanel();           //new EventListPanel object. Adding it to frame will allow for listing the events.
        addDefaultEvents(eventListPanel);                               //add the defaultEvents onto the event list
        frame.add(eventListPanel);
        frame.pack();                                                   //fit contents on window
        frame.setVisible(true);

    }

    public static void addDefaultEvents(EventListPanel eventListPanel) {

        LocalDateTime deadline = LocalDateTime.of(2024, 12, 7, 17, 0); // deadline parameters
        Deadline firstDeadline = new Deadline("First Deadline", deadline.minusDays(20) ); //deadline object creation for output

        LocalDateTime start = LocalDateTime.of(2024, 10, 7, 15, 0); // taken from EventTester.java
        LocalDateTime end = LocalDateTime.of(2024, 10, 7, 16, 0); // start point, end point, and location used to create Meeting object for panel output
        String location = "MCS 321";

        Meeting firstMeeting = new Meeting("First Meeting", start, end, location);

        eventListPanel.addEvent(firstDeadline); //add events to the eventListPanel
        eventListPanel.addEvent(firstMeeting);

    }
}