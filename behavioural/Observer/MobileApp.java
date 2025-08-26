public class MobileApp implements Observer {
    private String name;

    public MobileApp(String name) {
        this.name = name;
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        System.out.println("[" + name + "] Mobile App Update: Temp=" + temperature +
                           "°C, Humidity=" + humidity + "%, Pressure=" + pressure + "hPa");
    }
}
