public class PlayerMemento {
    private final String position;
    private final int health;
    private final int level;

    public PlayerMemento(String position, int health, int level) {
        this.position = position;
        this.health = health;
        this.level = level;
    }

    public String getPosition() {
        return position;
    }

    public int getHealth() {
        return health;
    }

    public int getLevel() {
        return level;
    }
}
