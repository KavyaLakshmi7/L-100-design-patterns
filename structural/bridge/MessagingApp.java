import java.util.Scanner;

public class MessagingApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose message type: 1) Text  2) Urgent");
        int msgType = sc.nextInt();
        sc.nextLine(); 

        System.out.println("Choose sender: 1) Email  2) SMS");
        int senderType = sc.nextInt();
        sc.nextLine(); 

        System.out.println("Enter your message:");
        String messageContent = sc.nextLine();

        MessageSender sender;
        if (senderType == 1) {
            sender = new EmailSender();
        } else {
            sender = new SMSSender();
        }

        Message message;
        if (msgType == 1) {
            message = new TextMessage(sender);
        } else {
            message = new UrgentMessage(sender);
        }

        message.send(messageContent);

        sc.close();
    }
}
