import java.util.ArrayList;
import java.util.List;

public class ApprovalSystem {
    private List<Command> commandQueue = new ArrayList<>();

    public void addCommand(Command command) {
        commandQueue.add(command);
        System.out.println("Command added to the queue.");
    }

    public void processCommands() {
        System.out.println("\nProcessing all approval commands...");
        for (Command command : commandQueue) {
            command.execute();
        }
        commandQueue.clear();
    }
}

