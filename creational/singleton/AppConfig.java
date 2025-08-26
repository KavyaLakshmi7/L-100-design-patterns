public class AppConfig {
    private static final AppConfig instance = new AppConfig();

    private String databaseUrl;
    private String apiKey;

    private AppConfig() {
        System.out.println("AppConfig instance created. Reading configuration...");
        this.databaseUrl = "jdbc:mysql://localhost/food_delivery_db";
        this.apiKey = "ABC123XYZ789-SECRET";
    }
    public static AppConfig getInstance() {
        return instance;
    }

    public String getDatabaseUrl() {
        return databaseUrl;
    }

    public String getApiKey() {
        return apiKey;
    }
}