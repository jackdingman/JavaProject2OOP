import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.*;

public class EventListPanel extends JPanel {
    ArrayList<Event> events; // list of events to be listed
    JPanel controlPanel; // panel for holding controls for event display
    JPanel displayPanel; // panel for holding the EventPanels corresponding to the events
    JComboBox sortDropDown; //a drop down that will sort the events by name, date, or qualities in reverse order. Use addItem to add items
    JCheckBox filterDisplay; //filter events: remove complete tasks, overdue tasks, reminders, deadlines
    JButton addEventButton;
    JCheckBox deadlineFilter;
    JCheckBox meetingFilter;

    public EventListPanel() {

        events = new ArrayList<>();
        controlPanel = new JPanel();
        displayPanel = new JPanel();

        setLayout(new BorderLayout());

        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));
        displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.Y_AXIS));
        sortDropDown = new JComboBox<>(new String[]{"Sort by date", "Sort by name", "Sort by name (reverse)", "Sort by date (reverse)"});
        filterDisplay = new JCheckBox("Filter Completed");
        deadlineFilter = new JCheckBox("Deadline Filter");
        meetingFilter = new JCheckBox("Meeting Filter");
        addEventButton = new JButton("Add Event");

        setLayout(new BorderLayout());
        add(controlPanel, BorderLayout.NORTH);
        controlPanel.add(addEventButton);
        controlPanel.add(filterDisplay);
        controlPanel.add(deadlineFilter);
        controlPanel.add(meetingFilter);
        controlPanel.add(sortDropDown);

        filterDisplay.addActionListener(e->changeDisplay());
        deadlineFilter.addActionListener(e->changeDisplay());
        meetingFilter.addActionListener(e->changeDisplay());

        sortDropDown.addActionListener(e -> {
            String item = (String) sortDropDown.getSelectedItem(); // dropdown menu item sorting lambda statements
            if (item == "Name") {
                events.sort((e1, e2) -> e1.getName().compareTo(e2.getName()));
            } else if (item == "Sort by name (reverse)") {
                events.sort((e1, e2) -> e2.getName().compareTo(e1.getName()));
            } else if (item == "Sort by date") {
                events.sort((e1, e2) -> e1.compareTo(e2));
            } else if (item == "Sort by date (reverse)") {
                events.sort((e1, e2) -> e2.compareTo(e1));
            }

            displayPanel.removeAll();
            for (Event event : events) {
                if (!filterDisplay.isSelected() || (event instanceof Completable && !((Completable) event).isComplete())) {
                    displayPanel.add(new EventPanel(event));
                }

            }
            displayPanel.revalidate();
            displayPanel.repaint();
        });

        addEventButton.addActionListener(e -> new AddEventModal(this));

        add(displayPanel, BorderLayout.CENTER);


    }
    public void addEvent(Event event) {
        events.add(event);
        changeDisplay();
    }

    public void changeDisplay() {
        displayPanel.removeAll();
        for (Event event : events) {
            boolean option = true; //for presenting different filter options
            if (filterDisplay.isSelected() && (event instanceof Completable && ((Completable) event).isComplete())) {
                option = false;
            }
            if (meetingFilter.isSelected() && !(event instanceof Meeting)) { //don't display if event is a meeting
                option = false;
            }
            if (deadlineFilter.isSelected() && !(event instanceof Deadline)) {
                option = false;
            }
            if (option) {
                displayPanel.add(new EventPanel(event)); // add the panel if above filters are passed
            }
        }
        displayPanel.revalidate(); //reshow display panel after events are filtered
        displayPanel.repaint();
    }
}