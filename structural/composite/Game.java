public class Game {
    public static void main(String[] args) {
        Weapon sword = new Sword("Excalibur");
        Weapon bow = new Bow("Elven Bow");
        Weapon gun = new Gun("Desert Eagle");

        WeaponPack starterPack = new WeaponPack("Starter Pack");
        starterPack.addWeapon(sword);
        starterPack.addWeapon(bow);

        WeaponPack ultimatePack = new WeaponPack("Ultimate Pack");
        ultimatePack.addWeapon(starterPack); 
        ultimatePack.addWeapon(gun);

        System.out.println("\n--- Showing Details ---");
        ultimatePack.showDetails();

        System.out.println("\n--- Attacking ---");
        ultimatePack.attack();
    }
}
