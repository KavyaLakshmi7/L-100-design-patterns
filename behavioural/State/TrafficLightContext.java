public class TrafficLightContext {
    private TrafficLightState currentState;

    public void setState(TrafficLightState state) {
        this.currentState = state;
    }

    public void applyState() {
        if (currentState != null) {
            currentState.handleRequest();
        } else {
            System.out.println("No state set yet.");
        }
    }
}
