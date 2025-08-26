public class Player {
    private String position;
    private int health;
    private int level;

    public Player(String position, int health, int level) {
        this.position = position;
        this.health = health;
        this.level = level;
    }

    public void play(String newPosition, int damage) {
        this.position = newPosition;
        this.health -= damage;
        System.out.println("Player moved to " + newPosition + " and took " + damage + " damage. Health: " + health);
    }

    public void levelUp() {
        this.level++;
        this.health = 100; 
        System.out.println("Level up! Now at Level " + level + " with full health.");
    }

    public PlayerMemento saveCheckpoint() {
        return new PlayerMemento(position, health, level);
    }

    public void restoreCheckpoint(PlayerMemento memento) {
        this.position = memento.getPosition();
        this.health = memento.getHealth();
        this.level = memento.getLevel();
        System.out.println("Rewind to checkpoint → Position: " + position + ", Health: " + health + ", Level: " + level);
    }
}
