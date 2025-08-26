import app.Application;
import factories.UIFactory;
import factories.MacOSFactory;
import factories.WindowsFactory;

public class Main {

    public static Application configureApplication() {
        UIFactory factory;
        
        String osName = System.getProperty("os.name").toLowerCase();
        System.out.println("Detected OS: " + osName);

        if (osName.contains("mac")) {
            System.out.println("OS is macOS, creating macOS UI components.");
            factory = new MacOSFactory();
        } else {
            System.out.println("OS is not macOS, creating Windows UI components.");
            factory = new WindowsFactory();
        }

        return new Application(factory);
    }

    public static void main(String[] args) {
        System.out.println("--- Abstract Factory Pattern: Cross-Platform UI ---");
        
        Application app = configureApplication();
        
        app.run();
    }
}