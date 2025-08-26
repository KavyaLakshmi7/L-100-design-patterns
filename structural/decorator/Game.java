import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Character player = new BasicCharacter();
        System.out.println("Your character starts as: " + player.getDescription() + " (Power: " + player.getPower() + ")");

        boolean running = true;

        while (running) {
            System.out.println("\nChoose a power-up:");
            System.out.println("1. Speed Boost (+5 power)");
            System.out.println("2. Shield (+8 power)");
            System.out.println("3. Double Damage (+15 power)");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> player = new SpeedBoost(player);
                case 2 -> player = new Shield(player);
                case 3 -> player = new DoubleDamage(player);
                case 4 -> running = false;
                default -> System.out.println("Invalid choice.");
            }

            System.out.println("Current Character: " + player.getDescription() + " (Power: " + player.getPower() + ")");
        }

        System.out.println("Game Over! Final Character: " + player.getDescription() + " (Power: " + player.getPower() + ")");
        scanner.close();
    }
}
