public class AlertSystem implements Observer {
    @Override
    public void update(float temperature, float humidity, float pressure) {
        if (temperature > 40) {
            System.out.println("Alert: Extreme temperature detected!");
        }
        if (humidity < 20) {
            System.out.println("Alert: Low humidity warning!");
        }
    }
}
