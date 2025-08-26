import java.util.Scanner;

public class WeatherStationClient {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        WeatherStation station = new WeatherStation();
        MobileApp app1 = new MobileApp("User1");
        DisplayBoard board = new DisplayBoard("Main Square");
        AlertSystem alert = new AlertSystem();

        station.registerObserver(app1);
        station.registerObserver(board);
        station.registerObserver(alert);

        System.out.println("Weather Station started. Enter measurements:");

        while (true) {
            System.out.print("Enter temperature (°C) or '999' to exit: ");
            float temp = sc.nextFloat();
            if (temp == 999) break;

            System.out.print("Enter humidity (%): ");
            float humidity = sc.nextFloat();

            System.out.print("Enter pressure (hPa): ");
            float pressure = sc.nextFloat();

            station.setMeasurements(temp, humidity, pressure);
            System.out.println();
        }

        System.out.println("Weather Station stopped.");
        sc.close();
    }
}
