public class NightMode implements TrafficLightState {
    @Override
    public void handleRequest() {
        System.out.println("Night Mode: Blinking Yellow for caution.");
    }
}
