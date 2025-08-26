public class Sword implements Weapon {
    private String name;

    public Sword(String name) {
        this.name = name;
    }

    @Override
    public void attack() {
        System.out.println(name + " slashes with a sharp blade!");
    }

    @Override
    public void showDetails() {
        System.out.println("Weapon: " + name + " (Sword)");
    }
}
