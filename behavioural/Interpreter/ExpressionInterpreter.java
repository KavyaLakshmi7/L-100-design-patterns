import java.util.Scanner;

public class ExpressionInterpreter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Simple Math Expression Interpreter");
        System.out.println("Enter expressions like: add 5 10 | subtract 20 7 | multiply 3 4");
        System.out.println("Type 'exit' to quit.");

        while (true) {
            System.out.print("\nEnter expression: ");
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("exit")) break;

            String[] parts = input.split(" ");
            if (parts.length != 3) {
                System.out.println("Invalid format! Try again.");
                continue;
            }

            String operator = parts[0].toLowerCase();
            int a, b;
            try {
                a = Integer.parseInt(parts[1]);
                b = Integer.parseInt(parts[2]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid numbers! Try again.");
                continue;
            }

            Expression exp;
            switch (operator) {
                case "add":
                    exp = new AddExpression(a, b);
                    break;
                case "subtract":
                    exp = new SubtractExpression(a, b);
                    break;
                case "multiply":
                    exp = new MultiplyExpression(a, b);
                    break;
                default:
                    System.out.println("Unknown operation! Try again.");
                    continue;
            }

            System.out.println("Result: " + exp.interpret());
        }

        sc.close();
        System.out.println("Interpreter exited.");
    }
}
