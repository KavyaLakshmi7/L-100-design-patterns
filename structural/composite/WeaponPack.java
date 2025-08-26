import java.util.ArrayList;
import java.util.List;

public class WeaponPack implements Weapon {
    private String packName;
    private List<Weapon> weapons = new ArrayList<>();

    public WeaponPack(String packName) {
        this.packName = packName;
    }

    public void addWeapon(Weapon weapon) {
        weapons.add(weapon);
    }

    public void removeWeapon(Weapon weapon) {
        weapons.remove(weapon);
    }

    @Override
    public void attack() {
        System.out.println(">>> " + packName + " attacks with all weapons!");
        for (Weapon weapon : weapons) {
            weapon.attack();
        }
    }

    @Override
    public void showDetails() {
        System.out.println("Weapon Pack: " + packName);
        for (Weapon weapon : weapons) {
            weapon.showDetails();
        }
    }
}
