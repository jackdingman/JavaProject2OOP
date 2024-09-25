import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;

public class AddEventModal extends JDialog {

     JTextField eventNameField; // field for inputting event
     JTextField eventDateField; // inputting event start date/time
     JTextField endEventField;  // end date/time
     JTextField locationField; // location
     JTextField eventLocationField; //location field for input
     JButton addButton;
     JComboBox<String> eventTypeDropDown;


    // Constructor
    public AddEventModal(EventListPanel eventListPanel) {

        setTitle("Add Event"); // settings for the modal window
        setSize(300, 200); //dialog window
        setLayout(new GridLayout(7, 2)); // 7 rows and 2 columns is the best format

        add(new JLabel("Event Name:"));
        eventNameField = new JTextField(); //label for name of event
        add(eventNameField); //addition of labels to the EventModal window for creating new events

        add(new JLabel("Start Date/Time:"));
        eventDateField = new JTextField(); // label for time
        add(eventDateField);

        add(new JLabel("End Date/Time (Not for Deadline):"));
        endEventField = new JTextField();
        add(endEventField);

        add(new JLabel("Location (Not for Deadline):"));
        eventLocationField = new JTextField();
        add(eventLocationField);

        add(new JLabel("Event Type:"));
        eventTypeDropDown = new JComboBox<>(new String[]{"Deadline", "Meeting"}); // dropdown for the two types of event
        add(eventTypeDropDown);


        // Add button
        JButton addButton = new JButton("Add Event"); // button for event submission
        add(addButton); //addition to dialog window

        addButton.addActionListener(e -> {
            String name = eventNameField.getText(); // gathers text from eventNameField JText Field
            LocalDateTime dateTime = LocalDateTime.parse(eventDateField.getText()); // gathers parsed LocalDateTime information from input JTextField.
            String menuOption = (String) eventTypeDropDown.getSelectedItem(); //cast drop down menu selection as a string for definition of event in if statements below

            if (menuOption.equals("Deadline")) { //add deadline type to eventListPanel
                eventListPanel.addEvent(new Deadline(name, dateTime));
            }
            if (menuOption.equals("Meeting")) { //add Meeting type to eventListPanel
                LocalDateTime endTime = LocalDateTime.parse(endEventField.getText()); //parse end time
                String location = eventLocationField.getText(); //get location field input, stored as a String
                eventListPanel.addEvent(new Meeting(name, dateTime, endTime, location)); // addition of new meeting event
            }
            dispose();
        });
        pack();
        setVisible(true);
    }


}

