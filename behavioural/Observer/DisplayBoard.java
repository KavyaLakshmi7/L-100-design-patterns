public class DisplayBoard implements Observer {
    private String location;

    public DisplayBoard(String location) {
        this.location = location;
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        System.out.println("[" + location + "] DisplayBoard: Temp=" + temperature +
                           "°C, Humidity=" + humidity + "%, Pressure=" + pressure + "hPa");
    }
}
