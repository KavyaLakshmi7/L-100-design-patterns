public class NormalMode implements TrafficLightState {
    @Override
    public void handleRequest() {
        System.out.println("Normal Mode: Green → Yellow → Red with standard timings.");
    }
}
