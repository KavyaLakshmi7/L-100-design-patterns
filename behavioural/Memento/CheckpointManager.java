import java.util.Stack;

public class CheckpointManager {
    private Stack<PlayerMemento> history = new Stack<>();

    public void save(PlayerMemento memento) {
        history.push(memento);
        System.out.println("💾 Checkpoint saved.");
    }

    public PlayerMemento undo() {
        if (!history.isEmpty()) {
            System.out.println("Undoing to last checkpoint...");
            return history.pop();
        }
        System.out.println("No checkpoints available!");
        return null;
    }
}
