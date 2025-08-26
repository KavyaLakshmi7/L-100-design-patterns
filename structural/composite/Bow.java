public class Bow implements Weapon {
    private String name;

    public Bow(String name) {
        this.name = name;
    }

    @Override
    public void attack() {
        System.out.println(name + " shoots an arrow!");
    }

    @Override
    public void showDetails() {
        System.out.println("Weapon: " + name + " (Bow)");
    }
}
