import javax.swing.*;
import java.awt.*;

public class EventPanel {

     Event event;
     JButton completeButton;

     public EventPanel(Event event){
         setPreferredSize(new Dimension(670, 50));
         this.event = event;

         setBackground(new Color (150, 150, 50));
     }
}
