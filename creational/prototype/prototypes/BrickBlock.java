package prototypes;

import model.GameObject;

public class BrickBlock extends GameObject {

    private boolean breakable;

    public BrickBlock() {
        setName("Brick Block");
        this.breakable = true; 
    }

    public void setBreakable(boolean breakable) { this.breakable = breakable; }

    @Override
    public void render() {
        System.out.printf(
            "Rendering a '%s' at (%d, %d). Breakable: %b\n",
            getName(), getX(), getY(), this.breakable
        );
    }
}