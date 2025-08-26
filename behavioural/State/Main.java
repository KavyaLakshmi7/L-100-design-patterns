import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TrafficLightContext context = new TrafficLightContext();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nChoose Traffic Light Mode:");
            System.out.println("1. Normal Mode");
            System.out.println("2. Night Mode");
            System.out.println("3. Emergency Mode");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    context.setState(new NormalMode());
                    break;
                case 2:
                    context.setState(new NightMode());
                    break;
                case 3:
                    context.setState(new EmergencyMode());
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
                    continue;
            }

            context.applyState();
        }
    }
}
