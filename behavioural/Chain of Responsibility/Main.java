import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SupportHandler chatbot = new ChatbotHandler();
        SupportHandler junior = new JuniorSupportHandler();
        SupportHandler senior = new SeniorSupportHandler();
        SupportHandler manager = new ManagerHandler();

        chatbot.setNextHandler(junior);
        junior.setNextHandler(senior);
        senior.setNextHandler(manager);

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your support query:");
        String query = sc.nextLine();

        chatbot.handleRequest(query);
    }
}
