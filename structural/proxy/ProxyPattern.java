import java.util.Scanner;

public class ProxyPattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your username:");
        String userName = scanner.nextLine();

        System.out.println("Are you a premium user? (yes/no):");
        String premiumInput = scanner.nextLine();

        boolean isPremium = premiumInput.equalsIgnoreCase("yes");

        Video videoService = new ProxyVideo(userName, isPremium);

        System.out.println("Enter the video you want to play:");
        String videoName = scanner.nextLine();

        videoService.play(videoName);

        scanner.close();
    }
}
