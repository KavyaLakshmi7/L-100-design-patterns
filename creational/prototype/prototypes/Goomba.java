package prototypes;

import model.GameObject;

public class Goomba extends GameObject {

    private int speed;

    public Goomba() {
        setName("Goomba");
        this.speed = 1;
    }

    public void setSpeed(int speed) { this.speed = speed; }
    
    @Override
    public void render() {
        System.out.printf(
            "Rendering a '%s' at (%d, %d) with speed %d.\n",
            getName(), getX(), getY(), this.speed
        );
    }
}