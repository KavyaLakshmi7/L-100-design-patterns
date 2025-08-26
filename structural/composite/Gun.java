public class Gun implements Weapon {
    private String name;

    public Gun(String name) {
        this.name = name;
    }

    @Override
    public void attack() {
        System.out.println(name + " fires a bullet!");
    }

    @Override
    public void showDetails() {
        System.out.println("Weapon: " + name + " (Gun)");
    }
}
