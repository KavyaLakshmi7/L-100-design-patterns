import java.util.Scanner;

public class ApprovalClient {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ApprovalSystem system = new ApprovalSystem();
        Manager manager = new Manager("Alice");

        while (true) {
            System.out.println("\nChoose action:");
            System.out.println("1. Approve Document");
            System.out.println("2. Reject Document");
            System.out.println("3. Request Changes");
            System.out.println("4. Process All Commands");
            System.out.println("5. Exit");

            int choice = sc.nextInt();
            sc.nextLine(); 

            if (choice == 5) break;

            if (choice >= 1 && choice <= 3) {
                System.out.print("Enter document name: ");
                String doc = sc.nextLine();

                Command cmd = null;
                switch (choice) {
                    case 1: cmd = new ApproveCommand(manager, doc); break;
                    case 2: cmd = new RejectCommand(manager, doc); break;
                    case 3: cmd = new RequestChangesCommand(manager, doc); break;
                }

                system.addCommand(cmd);
            } else if (choice == 4) {
                system.processCommands();
            } else {
                System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}
