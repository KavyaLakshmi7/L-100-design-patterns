import core.PrototypeRegistry;
import model.GameObject;
import prototypes.BrickBlock;
import prototypes.Goomba;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Prototype Pattern: Game Level Editor ---");
        System.out.println("Loading master game object prototypes...");
        PrototypeRegistry registry = new PrototypeRegistry();
        registry.addPrototype("goomba", new Goomba());
        registry.addPrototype("brick", new BrickBlock());
        System.out.println("Prototypes loaded!\n");


        System.out.println(">> Level designer places a Goomba.");
        GameObject goomba1 = registry.getClone("goomba");
        goomba1.setX(100);
        goomba1.setY(50);
        goomba1.render();

        System.out.println("\n>> Level designer places another Goomba.");
        GameObject goomba2 = registry.getClone("goomba");
        goomba2.setX(150);
        goomba2.setY(50);
        ((Goomba) goomba2).setSpeed(2); 
        goomba2.render();

        System.out.println("\n>> Level designer places a Brick Block.");
        GameObject block1 = registry.getClone("brick");
        block1.setX(200);
        block1.setY(100);
        block1.render();

        System.out.println("\n--- Verification ---");
        System.out.println("Is goomba1 the same object as goomba2? " + (goomba1 == goomba2));
        System.out.println("--------------------\n");
        System.out.println("Re-rendering the first Goomba to show it's unchanged:");
        goomba1.render();
    }
}