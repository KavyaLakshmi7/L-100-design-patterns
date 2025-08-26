package model;

public abstract class GameObject implements Cloneable {

    private String name;
    private int x;
    private int y;
    public abstract void render();
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getX() { return x; }
    public void setX(int x) { this.x = x; }
    public int getY() { return y; }
    public void setY(int y) { this.y = y; }

    @Override
    public GameObject clone() {
        try {
            return (GameObject) super.clone();
        } catch (CloneNotSupportedException e) {
            System.err.println("Cloning not supported for this object!");
            return null;
        }
    }
}