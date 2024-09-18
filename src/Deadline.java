import java.time.LocalDateTime;

public class Deadline extends Event implements Completable {

    private boolean complete;

    public Deadline(String name, LocalDateTime dateTime){ //constructor
        this.name = name;
        this.dateTime = dateTime;
    }

    @Override
    public void complete() { //holds boolean representing whether the task this deadline tracks is complete
        complete = true;     //complete boolean is set to true
    }

    @Override
    public boolean isComplete() {
        return complete;
    }
}
