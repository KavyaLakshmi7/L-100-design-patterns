public class Game {
    public static void main(String[] args) {
        Player player = new Player("StartPoint", 100, 1);
        CheckpointManager checkpointManager = new CheckpointManager();

        // Initial state
        checkpointManager.save(player.saveCheckpoint());

        // Player plays
        player.play("Forest", 30);
        checkpointManager.save(player.saveCheckpoint());

        player.play("Dungeon", 50);
        checkpointManager.save(player.saveCheckpoint());

        // Player gets hit badly
        player.play("DragonLair", 80); 

        // Oops! Rewind to last checkpoint
        PlayerMemento lastCheckpoint = checkpointManager.undo();
        if (lastCheckpoint != null) {
            player.restoreCheckpoint(lastCheckpoint);
        }

        // Player levels up
        player.levelUp();
        checkpointManager.save(player.saveCheckpoint());

        // Another rewind
        lastCheckpoint = checkpointManager.undo();
        if (lastCheckpoint != null) {
            player.restoreCheckpoint(lastCheckpoint);
        }
    }
}
