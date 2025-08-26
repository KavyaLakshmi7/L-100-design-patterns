public class EmergencyMode implements TrafficLightState {
    @Override
    public void handleRequest() {
        System.out.println("Emergency Mode: Always Green to allow quick passage.");
    }
}
