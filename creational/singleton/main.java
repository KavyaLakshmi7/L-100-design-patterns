public class Main {
    public static void main(String[] args) {
        System.out.println("Starting the Food Delivery App...");
        System.out.println("---------------------------------");

        System.out.println("The User Module needs the configuration...");
        AppConfig config1 = AppConfig.getInstance();
        System.out.println("User Module using DB URL: " + config1.getDatabaseUrl());

        System.out.println("\nThe Order Module needs the configuration...");
        AppConfig config2 = AppConfig.getInstance();
        System.out.println("Order Module using API Key: " + config2.getApiKey());
        
        System.out.println("\n--- Verifying Singleton ---");
        if (config1 == config2) {
            System.out.println("SUCCESS: config1 and config2 are the same instance.");
            System.out.println("Object reference for config1: " + config1);
            System.out.println("Object reference for config2: " + config2);
        } else {
            System.out.println("FAILURE: The Singleton pattern is broken. Different instances were created.");
        }
    }
}