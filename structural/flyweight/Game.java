import java.util.*;

public class Game {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<GameCharacter> characters = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("=== Flyweight Pattern Demo: Shared CharacterType & WeaponType ===");
        seedDefaultTypes(); 

        boolean running = true;
        while (running) {
            printMenu();
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1" -> createCharacter();
                case "2" -> listCharacters();
                case "3" -> createCharacterType();
                case "4" -> createWeaponType();
                case "5" -> showFactoryStats();
                case "6" -> changeCharacterWeapon();
                case "0" -> {
                    running = false;
                    System.out.println("Exiting. Bye!");
                }
                default -> System.out.println("Invalid choice, try again.");
            }
        }
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\nMenu:");
        System.out.println("1) Add a GameCharacter (choose or create types)");
        System.out.println("2) List all GameCharacters");
        System.out.println("3) Create a CharacterType (flyweight)");
        System.out.println("4) Create a WeaponType (flyweight)");
        System.out.println("5) Show Factory Stats (unique shared objects)");
        System.out.println("6) Change a character's weapon");
        System.out.println("0) Exit");
        System.out.print("Choose: ");
    }

    private static void createCharacter() {
        System.out.println("\n-- Add Character --");
        CharacterType ctype = pickOrCreateCharacterType();
        WeaponType wtype = pickOrCreateWeaponType();

        int x = readInt("Enter X position: ");
        int y = readInt("Enter Y position: ");

        GameCharacter gc = new GameCharacter(ctype, wtype, x, y);
        characters.add(gc);
        System.out.println("Created GameCharacter id=" + gc.getId());
    }

    private static CharacterType pickOrCreateCharacterType() {
        List<CharacterType> list = CharacterFactory.listTypes();
        if (!list.isEmpty()) {
            System.out.println("Existing CharacterTypes:");
            for (int i = 0; i < list.size(); i++) {
                CharacterType t = list.get(i);
                System.out.printf("  %d) %s %s (power:%d)%n", i + 1, t.getName(), t.getSprite(), t.getBasePower());
            }
        } else {
            System.out.println("No existing CharacterTypes.");
        }
        System.out.print("Pick index or type 'n' to create new: ");
        String s = scanner.nextLine().trim();
        if (s.equalsIgnoreCase("n")) {
            return createCharacterType();
        } else {
            try {
                int idx = Integer.parseInt(s) - 1;
                if (idx >= 0 && idx < list.size()) {
                    return list.get(idx);
                } else {
                    System.out.println("Invalid index, creating new type.");
                    return createCharacterType();
                }
            } catch (Exception e) {
                System.out.println("Parse error, creating new type.");
                return createCharacterType();
            }
        }
    }

    private static WeaponType pickOrCreateWeaponType() {
        List<WeaponType> list = WeaponFactory.listTypes();
        if (!list.isEmpty()) {
            System.out.println("Existing WeaponTypes:");
            for (int i = 0; i < list.size(); i++) {
                WeaponType w = list.get(i);
                System.out.printf("  %d) %s %s (dmg:%d)%n", i + 1, w.getName(), w.getSprite(), w.getDamage());
            }
        } else {
            System.out.println("No existing WeaponTypes.");
        }
        System.out.print("Pick index or type 'n' to create new: ");
        String s = scanner.nextLine().trim();
        if (s.equalsIgnoreCase("n")) {
            return createWeaponType();
        } else {
            try {
                int idx = Integer.parseInt(s) - 1;
                if (idx >= 0 && idx < list.size()) {
                    return list.get(idx);
                } else {
                    System.out.println("Invalid index, creating new weapon.");
                    return createWeaponType();
                }
            } catch (Exception e) {
                System.out.println("Parse error, creating new weapon.");
                return createWeaponType();
            }
        }
    }

    private static void listCharacters() {
        System.out.println("\n-- Characters --");
        if (characters.isEmpty()) {
            System.out.println("No characters created yet.");
            return;
        }
        for (GameCharacter gc : characters) {
            gc.render();
        }
    }

    private static CharacterType createCharacterType() {
        System.out.print("Enter character name (e.g., Warrior): ");
        String name = scanner.nextLine().trim();
        System.out.print("Enter sprite (small string, e.g., ⚔️): ");
        String sprite = scanner.nextLine().trim();
        int power = readInt("Enter base power (integer): ");
        return CharacterFactory.getCharacterType(name, sprite, power);
    }

    private static WeaponType createWeaponType() {
        System.out.print("Enter weapon name (e.g., Sword): ");
        String name = scanner.nextLine().trim();
        System.out.print("Enter sprite (e.g., 🗡️): ");
        String sprite = scanner.nextLine().trim();
        int damage = readInt("Enter damage (integer): ");
        return WeaponFactory.getWeaponType(name, sprite, damage);
    }

    private static void showFactoryStats() {
        System.out.println("\n-- Flyweight Stats --");
        System.out.println("Total GameCharacters: " + characters.size());
        System.out.println("Unique CharacterType instances: " + CharacterFactory.uniqueCount());
        System.out.println("Unique WeaponType instances: " + WeaponFactory.uniqueCount());
    }

    private static void changeCharacterWeapon() {
        if (characters.isEmpty()) {
            System.out.println("No characters to modify.");
            return;
        }
        System.out.println("Choose character ID to modify:");
        for (GameCharacter gc : characters) {
            System.out.printf("  id=%d -> %s at weapon=%s%n", gc.getId(), gc.getCharacterType().getName(), gc.getWeaponType().getName());
        }
        int id = readInt("Enter id: ");
        GameCharacter found = null;
        for (GameCharacter gc : characters) {
            if (gc.getId() == id) { found = gc; break; }
        }
        if (found == null) {
            System.out.println("Character id not found.");
            return;
        }
        WeaponType newWeapon = pickOrCreateWeaponType();
        found.setWeaponType(newWeapon);
        System.out.println("Weapon changed for character id=" + found.getId());
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }

    private static void seedDefaultTypes() {
        CharacterFactory.getCharacterType("Warrior", "⚔️", 30);
        CharacterFactory.getCharacterType("Archer", "🏹", 20);
        WeaponFactory.getWeaponType("Sword", "🗡️", 12);
        WeaponFactory.getWeaponType("Bow", "🏹", 9);
    }
}
